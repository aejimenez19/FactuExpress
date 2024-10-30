package com.facturaExpress.InvoiceService.Commons.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {
    @JsonProperty(value = "reference_code")
    private String referenceCode;
    @JsonProperty(value = "payment_method_code")
    private int paymentMetod;
    @NotNull
    @JsonProperty(value = "customer_identification")
    private String customerIdentification;
    @JsonProperty(value = "companyId")
    private Long companyId;
    @JsonProperty(value = "items")
    private List<ItemsDto> items;
}
