package com.facturaExpress.InvoiceService.Commons.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRegisterDto {
    @NotNull
    private String name;
    @NotNull
    private String email;
    private String phone;
    @NotNull
    private String userName;
    @NotNull
    private String password;
}
