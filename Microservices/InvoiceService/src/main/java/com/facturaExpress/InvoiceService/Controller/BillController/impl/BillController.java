package com.facturaExpress.InvoiceService.Controller.BillController.impl;

import com.facturaExpress.InvoiceService.Commons.Dto.BillDto;
import com.facturaExpress.InvoiceService.Commons.Dto.ResponseDto;
import com.facturaExpress.InvoiceService.Controller.BillController.BillApi;
import com.facturaExpress.InvoiceService.Service.Bill.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController implements BillApi {
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }


    @Override
    public ResponseEntity<ResponseDto> saveBill(BillDto billDto) {
        Long idCustomer = billService.validateCustomer(billDto.getCustomerIdentification());
        if (idCustomer != null) {
            return ResponseEntity.ok(billService.saveBill(billDto, idCustomer));
        } else {
            return new ResponseEntity<>(ResponseDto.builder().message("Customer not found").build(), HttpStatus.NOT_FOUND);
        }
    }

}
