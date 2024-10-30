package com.facturaExpress.InvoiceService.Commons.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemsDto {
    @NotNull
    @JsonProperty(value = "code_reference")
    private String codeReference;
    @NotNull
    @JsonProperty(value = "name")
    private String name;
    @NotNull
    @JsonProperty(value = "quantity")
    private Double quantity;
    @JsonProperty(value = "discount")
    private Double discount;
    @JsonProperty(value = "discount_rate")
    private Double discountRate;
    @NotNull
    @JsonProperty(value = "price")
    private Double price;
    @NotNull
    @JsonProperty(value = "tax_rate")
    private Double taxRate;
}
