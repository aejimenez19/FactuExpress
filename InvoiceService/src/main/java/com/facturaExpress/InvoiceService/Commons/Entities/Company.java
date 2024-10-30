package com.facturaExpress.InvoiceService.Commons.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "companys")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Integer status;
    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
    private Credential credential;
}
