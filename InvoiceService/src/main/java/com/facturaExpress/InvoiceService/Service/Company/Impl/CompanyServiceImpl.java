package com.facturaExpress.InvoiceService.Service.Company.Impl;

import com.facturaExpress.InvoiceService.Commons.Dto.CompanyRegisterDto;
import com.facturaExpress.InvoiceService.Commons.Dto.LoginDto;
import com.facturaExpress.InvoiceService.Commons.Dto.ResponseDto;
import com.facturaExpress.InvoiceService.Commons.Entities.Company;
import com.facturaExpress.InvoiceService.Commons.Entities.Credential;
import com.facturaExpress.InvoiceService.Commons.Exceptions.CustomException;
import com.facturaExpress.InvoiceService.Repository.CompanyRepository;
import com.facturaExpress.InvoiceService.Repository.CredentialsRepository;
import com.facturaExpress.InvoiceService.Service.Company.CompanyService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public ResponseDto register(CompanyRegisterDto companyRegisterDto) {
        try {
            companyRepository.save(mapToEntity(companyRegisterDto));
            return ResponseDto.builder().message("Registro exitoso.").build();
        } catch (DataAccessException e) {
            throw new CustomException("Error saving the Company: " + e.getMessage(), e);
        }
    }



    private Company mapToEntity(CompanyRegisterDto companyRegisterDto) {
        Credential credential = new Credential();
        credential.setUserName(companyRegisterDto.getUserName());
        credential.setPassword(companyRegisterDto.getPassword());
        Company newCompany = Company.builder()
                .name(companyRegisterDto.getName())
                .email(companyRegisterDto.getEmail())
                .phone(companyRegisterDto.getPhone())
                .status(1)
                .build();
        credential.setCompany(newCompany);
        newCompany.setCredential(credential);
        return newCompany;
    }
}
