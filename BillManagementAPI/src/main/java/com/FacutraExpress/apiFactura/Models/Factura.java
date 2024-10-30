package com.FacutraExpress.apiFactura.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import com.FacutraExpress.apiFactura.Models.Comercio;

import java.util.Date;
import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private int id;
    private Date fecha;
    private double total;
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario Usuario;
    @ManyToOne()
    @JoinColumn(name = "id_comercio")
    private Comercio comercio;

}
