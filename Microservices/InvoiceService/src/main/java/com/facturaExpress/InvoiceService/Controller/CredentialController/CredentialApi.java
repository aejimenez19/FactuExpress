package com.facturaExpress.InvoiceService.Controller.CredentialController;

import com.facturaExpress.InvoiceService.Commons.Contanst.ApiPathConstants;
import com.facturaExpress.InvoiceService.Commons.Dto.LoginDto;
import com.facturaExpress.InvoiceService.Commons.Dto.TokenDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)
public interface CredentialApi {
    @PostMapping("login")
    public ResponseEntity<TokenDto> login(@Valid @RequestBody LoginDto loginDto);
}
