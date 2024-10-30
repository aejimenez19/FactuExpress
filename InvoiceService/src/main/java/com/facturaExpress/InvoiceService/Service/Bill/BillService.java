package com.facturaExpress.InvoiceService.Service.Bill;

import com.facturaExpress.InvoiceService.Commons.Dto.BillDto;
import com.facturaExpress.InvoiceService.Commons.Dto.ResponseDto;


public interface BillService {
    ResponseDto saveBill(BillDto billDto, Long idCustomer);
    Long validateCustomer(String customerIdentification);
}
