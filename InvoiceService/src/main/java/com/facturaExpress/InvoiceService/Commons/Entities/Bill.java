package com.facturaExpress.InvoiceService.Commons.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_customer")
    private Long idCustomer;
    @Column(name = "id_Company")
    private Long idCompany;
    @Column(name = "id_type_payment")
    private Long idTypePayment;
    @Column(name = "references_code")
    private String referenceCode;
    @Column(name = "billing_date")
    private Date dateBill;
    @OneToMany(mappedBy = "idBill", cascade = CascadeType.ALL)
    List<Item> items;
}
