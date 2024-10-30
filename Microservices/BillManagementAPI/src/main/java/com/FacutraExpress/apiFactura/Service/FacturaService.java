package com.FacutraExpress.apiFactura.Service;

import com.FacutraExpress.apiFactura.Models.*;
import com.FacutraExpress.apiFactura.Repository.ComercioRepository;
import com.FacutraExpress.apiFactura.Repository.FacturaRepository;
import com.FacutraExpress.apiFactura.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;

    private final UsuarioRepository usuarioRepository;

    private final ComercioRepository comercioRepository;

    public FacturaService(FacturaRepository facturaRepository,
                          UsuarioRepository usuarioRepository,
                          ComercioRepository comercioRepository) {
        this.facturaRepository = facturaRepository;
        this.comercioRepository = comercioRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public int obtenerFactura(int idUsuario) {
        return facturaRepository.obtenerNumFacturaIdUsuario(idUsuario);
    }


    public List<FacturasSalidaDto> obtenerFacturaPorFecha(int idUsuario, String fecha) {
        List<FacturasSalidaDto> facturasSalidaDtos = new ArrayList<>();
        List<Factura> facturas = facturaRepository.obtenerFacturaIdUsuarioAndFecha(idUsuario, fecha);
        for (Factura factura: facturas) {
            facturasSalidaDtos = tranformadorFacturaSalida(factura, facturasSalidaDtos);
        }

        return facturasSalidaDtos;
    }


    private List<FacturasSalidaDto> tranformadorFacturaSalida(Factura factura, List<FacturasSalidaDto> facturasSalidaDtos) {
        long count = facturasSalidaDtos.stream().filter(x -> x.getId() == factura.getComercio().getId()).count();
        if (count == 0) {
            FacturasSalidaDto newfacturas = FacturasSalidaDto.builder()
                    .id(factura.getComercio().getId())
                    .nombre(factura.getComercio().getNombre())
                    .factura(new ArrayList<>()).build();
            newfacturas.getFactura().add(new FacturaDto(factura.getId(), factura.getFecha(), factura.getTotal(),factura.getDescripcion()));
            facturasSalidaDtos.add(newfacturas);
        } else {
            for (FacturasSalidaDto facturasSalidaDto : facturasSalidaDtos) {
                if (facturasSalidaDto.getId() == factura.getComercio().getId()) {
                    facturasSalidaDto.getFactura().add(new FacturaDto(factura.getId(), factura.getFecha(), factura.getTotal(),factura.getDescripcion()));
                }
            }
        }
        return facturasSalidaDtos;
    }

    public String saveFactura(Factura factura) {
        Usuario usuario = getUsuario(factura.getUsuario().getId());
        Comercio comercio = getComercio(factura.getComercio().getId());
        if (comercio != null && usuario != null){
            factura.setUsuario(usuario);
            factura.setComercio(comercio);
            factura.setFecha(new Date());
            facturaRepository.save(factura);
            int n = usuarioRepository.updateAhorro(usuario.getAhorroPapel() + 15, usuario.getId());
            return "Factura enviada correctamente";
        } else {
            return "Factura no enviada";
        }

    }


    public Usuario getUsuario(int id){
        return usuarioRepository.findById(id);
    }

    public Comercio getComercio(int id) {
        return comercioRepository.findById(id);
    }
}
