package com.facturaExpress.InvoiceService.Commons.Dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
    private String token;
    private Long idCompany;
}
