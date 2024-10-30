package com.facturaExpress.InvoiceService.Controller.CompnayController.Impl;

import com.facturaExpress.InvoiceService.Commons.Dto.CompanyRegisterDto;
import com.facturaExpress.InvoiceService.Commons.Dto.LoginDto;
import com.facturaExpress.InvoiceService.Commons.Dto.ResponseDto;
import com.facturaExpress.InvoiceService.Commons.Dto.TokenDto;
import com.facturaExpress.InvoiceService.Commons.Entities.Company;
import com.facturaExpress.InvoiceService.Config.JwtUtil;
import com.facturaExpress.InvoiceService.Controller.CompnayController.CompanyApi;
import com.facturaExpress.InvoiceService.Service.Company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyControllerImpl implements CompanyApi {
    private final CompanyService companyService;



    public CompanyControllerImpl(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public ResponseEntity<ResponseDto> register(CompanyRegisterDto companyRegisterDto) {
        return new ResponseEntity<>(companyService.register(companyRegisterDto), HttpStatus.OK);
    }


}
