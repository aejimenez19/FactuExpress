package com.facturaExpress.InvoiceService.Service.Credential.Impl;

import com.facturaExpress.InvoiceService.Commons.Dto.LoginDto;
import com.facturaExpress.InvoiceService.Commons.Entities.Credential;
import com.facturaExpress.InvoiceService.Repository.CredentialsRepository;
import com.facturaExpress.InvoiceService.Service.Credential.CredentialService;
import org.springframework.stereotype.Service;

@Service
public class CredentialServiceImpl implements CredentialService {
    private final CredentialsRepository credentialsRepository;

    public CredentialServiceImpl(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    @Override
    public Credential validCompanyCredentials(LoginDto loginDto) {
        Credential credential = credentialsRepository.findByUserName(loginDto.getUser());

        if (credential == null || !credential.getPassword().equals(loginDto.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password.");
        }

        return credential;
    }
}
