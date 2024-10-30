package com.facturaExpress.InvoiceService.Commons.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_bill", nullable = false)
    private Bill idBill;
    @Column(name = "code_reference")
    private String codeReference;
    private String name;
    private Double quantity;
    private Double discount;
    @Column(name = "discount_rate")
    private Double discountRate;
    private Double price;
    @Column(name = "tax_rate")
    private Double taxRate;
}
