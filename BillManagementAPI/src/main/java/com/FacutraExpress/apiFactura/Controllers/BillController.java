package com.FacutraExpress.apiFactura.Controllers;

import com.FacutraExpress.apiFactura.Models.Dto.BillResponseDto;
import com.FacutraExpress.apiFactura.Service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bill")
public class BillController {
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("{id}/{date}")
    public ResponseEntity<List<BillResponseDto>> getBillByDate(@PathVariable Long id,
                                                              @PathVariable String date) {
        return new ResponseEntity<>(billService.getBillsByDate(id, date), HttpStatus.OK);
    }
}
