package com.FacutraExpress.apiFactura.Models.Dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillResponseDto {
    private Long idCompany;
    private String namecompany;
    private List<BillDto> bills;
}
