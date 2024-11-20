package com.FacutraExpress.apiFactura.Service;

import com.FacutraExpress.apiFactura.Models.Entities.Company;
import com.FacutraExpress.apiFactura.Repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company getCompanyWithIdBill(Long idBill) {
        return companyRepository.getCompanyWithIdBill(idBill);
    }
}
