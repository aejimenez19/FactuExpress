package com.facturaExpress.InvoiceService.Service.Bill.impl;

import com.facturaExpress.InvoiceService.Commons.Dto.BillDto;
import com.facturaExpress.InvoiceService.Commons.Dto.ResponseDto;
import com.facturaExpress.InvoiceService.Commons.Entities.Bill;
import com.facturaExpress.InvoiceService.Commons.Entities.Item;
import com.facturaExpress.InvoiceService.Commons.Exceptions.CustomException;
import com.facturaExpress.InvoiceService.Repository.BillRepository;
import com.facturaExpress.InvoiceService.Service.Bill.BillService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    private final BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public ResponseDto saveBill(BillDto billDto, Long idCustomer) {

        try {
            Bill bill = mapToEntity(billDto, idCustomer);
            billRepository.save(bill);
            return ResponseDto.builder().message("Bill saved.").build();
        } catch (DataAccessException e) {
            throw new CustomException("Error saving the bill: " + e.getMessage(), e);
        }
    }

    @Override
    public Long validateCustomer(String customerIdentification) {
        return billRepository.getIdCustomerByIdentification(customerIdentification);
    }



    private Bill mapToEntity(BillDto billDto, Long idCustomer) {
        Bill newBill = new Bill();
        newBill.setIdCompany(billDto.getCompanyId());
        newBill.setIdCustomer(idCustomer);
        newBill.setReferenceCode(billDto.getReferenceCode());
        newBill.setIdTypePayment((long) billDto.getPaymentMetod());
        newBill.setDateBill(new Date());
        List<Item> itemArrayList = new ArrayList<>();
        billDto.getItems().forEach(
                item -> {
                    Item newItem = new Item();
                    newItem.setCodeReference(item.getCodeReference());
                    newItem.setName(item.getName());
                    newItem.setQuantity(item.getQuantity());
                    newItem.setDiscount(item.getDiscount());
                    newItem.setDiscountRate(item.getDiscountRate());
                    newItem.setPrice(item.getPrice());
                    newItem.setTaxRate(item.getTaxRate());
                    newItem.setIdBill(newBill);
                    itemArrayList.add(newItem);
                }
        );
        newBill.setItems(itemArrayList);
        return newBill;
    }
}
