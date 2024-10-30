package com.FacutraExpress.apiFactura.Models.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bills")
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_customer")
    private Long idCustomer;
    @ManyToOne
    @JoinColumn(name = "id_company")
    @JsonIgnore
    private Company company;
    @ManyToOne
    @JoinColumn(name = "id_type_payment")
    private TypePayment typePayment;
    @Column(name = "references_code")
    private String referencesCode;
    @OneToMany(mappedBy = "bills", cascade = CascadeType.ALL)
    private List<Item> items;
}
