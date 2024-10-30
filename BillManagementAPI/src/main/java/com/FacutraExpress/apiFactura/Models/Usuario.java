package com.FacutraExpress.apiFactura.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;
    @Column(name = "ahorro_papel")
    private int ahorroPapel;
    private String apellido;
    private String cedula;
    private String correo;
    private String nombre;
}
