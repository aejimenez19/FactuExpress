package com.FacutraExpress.apiFactura.Repository;

import com.FacutraExpress.apiFactura.Models.Comercio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComercioRepository extends JpaRepository<Comercio, Integer> {

    @Query(value = "SELECT c.nombre, c.id_comercio FROM usuario_comercio uc " +
            "INNER JOIN comercio c ON c.id_comercio = uc.id_comercio " +
            "WHERE id_usuario = ?1 AND estado = 1", nativeQuery = true)
    List<Comercio> getComerciosForUser(int idUser);

    @Query(value = "select * from comercio where id_comercio = ?1", nativeQuery = true)
    Comercio findById(int id);
}
