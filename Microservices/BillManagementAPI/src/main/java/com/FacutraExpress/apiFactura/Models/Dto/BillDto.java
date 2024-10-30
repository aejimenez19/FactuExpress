package com.FacutraExpress.apiFactura.Models.Dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillDto {
    private Long id;
    private String typePayment;
    private String referencesCode;
    private String date;
}
