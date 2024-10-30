package com.facturaExpress.InvoiceService.Controller.BillController;

import com.facturaExpress.InvoiceService.Commons.Contanst.ApiPathConstants;
import com.facturaExpress.InvoiceService.Commons.Dto.BillDto;
import com.facturaExpress.InvoiceService.Commons.Dto.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.BILLS_ROUTE)
public interface BillApi {

    @PostMapping("/create")
    ResponseEntity<ResponseDto> saveBill(@Valid @RequestBody BillDto billDto);



}
