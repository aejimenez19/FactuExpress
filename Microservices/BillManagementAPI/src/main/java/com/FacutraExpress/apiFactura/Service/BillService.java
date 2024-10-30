package com.FacutraExpress.apiFactura.Service;

import com.FacutraExpress.apiFactura.Models.Dto.BillDto;
import com.FacutraExpress.apiFactura.Models.Dto.BillResponseDto;
import com.FacutraExpress.apiFactura.Models.Entities.BillsByCompany;
import com.FacutraExpress.apiFactura.Repository.BillsByCompanyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class BillService {
    private final BillsByCompanyRepository billsByCompanyRepository;

    public BillService(BillsByCompanyRepository billsByCompanyRepository) {
        this.billsByCompanyRepository = billsByCompanyRepository;
    }

    public List<BillResponseDto> getBillsByDate(Long id, String date) {
        List<BillsByCompany> bills = billsByCompanyRepository.getBillOrderByCompany(id, date);
        return mapToBillResponseDto(bills);
    }

    private List<BillResponseDto> mapToBillResponseDto(List<BillsByCompany> bills) {
        Map<Long, BillResponseDto> billResponseDtoMap = new HashMap<>();

        for (BillsByCompany billsByCompany : bills) {
            addBillToMap(billResponseDtoMap, billsByCompany);
        }

        return new ArrayList<>(billResponseDtoMap.values());
    }

    private void addBillToMap(Map<Long, BillResponseDto> billResponseDtoMap, BillsByCompany billsByCompany) {
        Long idCompany = billsByCompany.getIdCompany();
        BillDto billDto = createBillDto(billsByCompany);

        BillResponseDto billResponseDto = billResponseDtoMap.get(idCompany);
        if (billResponseDto != null) {
            // Si existe, agrega el nuevo BillDto
            billResponseDto.getBills().add(billDto);
        } else {
            // Si no existe, crea uno nuevo
            billResponseDto = createNewBillResponseDto(billsByCompany, billDto);
            billResponseDtoMap.put(idCompany, billResponseDto);
        }
    }

    private BillDto createBillDto(BillsByCompany billsByCompany) {
        LocalDate dateBill = billsByCompany.getDateBill(); // Asegúrate de que este es LocalDate
        String formattedDate = formatDate(dateBill);
        return new BillDto(billsByCompany.getIdBill(),
                billsByCompany.getTypePayment(),
                billsByCompany.getReferencesCode(),
                formattedDate);
    }

    private String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    private BillResponseDto createNewBillResponseDto(BillsByCompany billsByCompany, BillDto billDto) {
        BillResponseDto newBillResponseDto = new BillResponseDto();
        newBillResponseDto.setIdCompany(billsByCompany.getIdCompany());
        newBillResponseDto.setNamecompany(billsByCompany.getNameComany());
        newBillResponseDto.setBills(new ArrayList<>(Collections.singletonList(billDto)));
        return newBillResponseDto;
    }


}
