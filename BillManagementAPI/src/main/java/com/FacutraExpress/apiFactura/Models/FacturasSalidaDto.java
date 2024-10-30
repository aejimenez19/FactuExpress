package com.FacutraExpress.apiFactura.Models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class FacturasSalidaDto {
    private int id;
    private String nombre;
    private List<FacturaDto> factura;
}
