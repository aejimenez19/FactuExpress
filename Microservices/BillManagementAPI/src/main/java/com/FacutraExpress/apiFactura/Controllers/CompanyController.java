package com.FacutraExpress.apiFactura.Controllers;

import com.FacutraExpress.apiFactura.Models.Entities.Company;
import com.FacutraExpress.apiFactura.Service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("{idBill}")
    public ResponseEntity<Company> getComercioWithIdBill(@PathVariable Long idBill) {
        return new ResponseEntity<>(companyService.getCompanyWithIdBill(idBill), HttpStatus.OK);
    }
}
