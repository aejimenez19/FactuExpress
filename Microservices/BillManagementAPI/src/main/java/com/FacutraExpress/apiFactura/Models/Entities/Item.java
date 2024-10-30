package com.FacutraExpress.apiFactura.Models.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_bill")
    @JsonIgnore
    private Bills bills;
    @Column(name = "code_reference")
    private String codeReference;
    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "discount_rate")
    private Double discountRate;
    @Column(name = "price")
    private Double price;
    @Column(name = "tax_rate")
    private Double taxRate;
}
