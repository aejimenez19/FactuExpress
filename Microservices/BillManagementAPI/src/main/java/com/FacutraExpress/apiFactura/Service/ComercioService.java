package com.FacutraExpress.apiFactura.Service;

import com.FacutraExpress.apiFactura.Models.Comercio;
import com.FacutraExpress.apiFactura.Repository.ComercioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComercioService {

    private ComercioRepository comercioRepository;
    public ComercioService(ComercioRepository comercioRepository) {
        this.comercioRepository = comercioRepository;
    }

    public List<Comercio> obtenerFacturaPorFecha(int idUsuario) {
        return comercioRepository.getComerciosForUser(idUsuario);
    }
}
