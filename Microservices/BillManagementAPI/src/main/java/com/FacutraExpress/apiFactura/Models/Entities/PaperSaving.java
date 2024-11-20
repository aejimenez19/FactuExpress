package com.FacutraExpress.apiFactura.Models.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaperSaving {
    @Id
    private Long idCustomer;
    private Integer totalInvoice;
    private Integer totalItems;
}
