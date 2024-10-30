package com.facturaExpress.InvoiceService.Service.Company;

import com.facturaExpress.InvoiceService.Commons.Dto.CompanyRegisterDto;
import com.facturaExpress.InvoiceService.Commons.Dto.LoginDto;
import com.facturaExpress.InvoiceService.Commons.Dto.ResponseDto;
import com.facturaExpress.InvoiceService.Commons.Entities.Company;

public interface CompanyService {

    ResponseDto register(CompanyRegisterDto companyRegisterDto);

}
