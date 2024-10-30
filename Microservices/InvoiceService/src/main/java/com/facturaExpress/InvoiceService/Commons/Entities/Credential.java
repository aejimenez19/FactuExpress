package com.facturaExpress.InvoiceService.Commons.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "credentials")
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password_hash")
    private String password;
    @Column(name = "last_login")
    private LocalDate lastLogin;
    @OneToOne
    @JoinColumn(name = "id_company")
    private Company company;
}
