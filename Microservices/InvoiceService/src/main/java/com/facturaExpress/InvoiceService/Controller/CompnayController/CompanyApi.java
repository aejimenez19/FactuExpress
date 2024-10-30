package com.facturaExpress.InvoiceService.Controller.CompnayController;

import com.facturaExpress.InvoiceService.Commons.Contanst.ApiPathConstants;
import com.facturaExpress.InvoiceService.Commons.Dto.CompanyRegisterDto;
import com.facturaExpress.InvoiceService.Commons.Dto.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.COMPANY_ROUTE)
public interface CompanyApi {
    @PostMapping("register")
    public ResponseEntity<ResponseDto> register(@Valid @RequestBody CompanyRegisterDto companyRegisterDto);


}
