package com.FacutraExpress.apiFactura.Controllers;

import com.FacutraExpress.apiFactura.Models.Factura;
import com.FacutraExpress.apiFactura.Models.FacturasSalidaDto;
import com.FacutraExpress.apiFactura.Service.FacturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("factura")
public class FacturaController {
    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    
    @GetMapping("{id}")
    public int obteneFactura(@PathVariable int id){
        return facturaService.obtenerFactura(id);
    }

    @GetMapping("{id}/{fecha}")
    public ResponseEntity<List<FacturasSalidaDto>> obtenerFacturaPorFecha(@PathVariable int id, @PathVariable String fecha) {
        return new ResponseEntity<>(facturaService.obtenerFacturaPorFecha(id, fecha), HttpStatus.OK);
    }

    @PostMapping("save")
    public String newFactura(@RequestBody Factura factura) {
        return facturaService.saveFactura(factura);
    }
}
