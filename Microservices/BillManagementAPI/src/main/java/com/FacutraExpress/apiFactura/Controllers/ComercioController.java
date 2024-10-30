package com.FacutraExpress.apiFactura.Controllers;

import com.FacutraExpress.apiFactura.Models.Comercio;
import com.FacutraExpress.apiFactura.Service.ComercioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("comercio")
public class ComercioController {

    private ComercioService comercioService;

    public ComercioController(ComercioService comercioService) {
        this.comercioService = comercioService;
    }

    @GetMapping("{idUsuario}")
    public ResponseEntity<List<Comercio>> getComercionsWithUser(@PathVariable int idUsuario) {
        return new ResponseEntity<>(comercioService.obtenerFacturaPorFecha(idUsuario), HttpStatus.OK);
    }

}
