package com.facturaExpress.InvoiceService.Controller.CredentialController.Impl;

import com.facturaExpress.InvoiceService.Commons.Dto.LoginDto;
import com.facturaExpress.InvoiceService.Commons.Dto.TokenDto;
import com.facturaExpress.InvoiceService.Commons.Entities.Credential;
import com.facturaExpress.InvoiceService.Config.JwtUtil;
import com.facturaExpress.InvoiceService.Controller.CredentialController.CredentialApi;
import com.facturaExpress.InvoiceService.Service.Credential.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CredentialControllerImpl implements CredentialApi {
    private final CredentialService credentialService;

    public CredentialControllerImpl(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<TokenDto> login(LoginDto loginDto) {
        Credential credentialCompany = credentialService.validCompanyCredentials(loginDto);
        return new ResponseEntity<>(TokenDto.builder()
                .token(jwtUtil.generateToken(credentialCompany.getCompany().getName(), credentialCompany.getCompany().getId()))
                .idCompany(credentialCompany.getCompany().getId())
                .build(), HttpStatus.OK);
    }
}
