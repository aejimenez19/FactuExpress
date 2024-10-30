package com.facturaExpress.InvoiceService.Service.Credential;

import com.facturaExpress.InvoiceService.Commons.Dto.LoginDto;
import com.facturaExpress.InvoiceService.Commons.Entities.Company;
import com.facturaExpress.InvoiceService.Commons.Entities.Credential;

public interface CredentialService {
    Credential validCompanyCredentials(LoginDto loginDto);
}
