package com.FacutraExpress.apiFactura.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDto {
    private int id;
    private Date fecha;
    private double total;
    private String descripcion;
}
