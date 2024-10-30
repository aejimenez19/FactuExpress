package com.FacutraExpress.apiFactura.Models.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillsByCompany {
    @Id
    @Column(name = "id_bill")
    private Long idBill;
    @Column(name = "references_code")
    private String referencesCode;
    @Column(name = "billing_date")
    private LocalDate dateBill;
    @Column(name = "id_company")
    private Long idCompany;
    @Column(name = "name_company")
    private String nameComany;
    @Column(name = "type_payment")
    private String typePayment;
}
