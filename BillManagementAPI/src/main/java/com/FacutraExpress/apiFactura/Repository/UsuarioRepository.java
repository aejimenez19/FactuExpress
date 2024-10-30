package com.FacutraExpress.apiFactura.Repository;

import com.FacutraExpress.apiFactura.Models.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "select * from Usuario where correo = ?1", nativeQuery = true)
    Usuario findByCorreo(String correo);

    @Query(value = "select * from Usuario where id_usuario = ?1", nativeQuery = true)
    Usuario findById(int id);
    @Modifying
    @Transactional
    @Query(value = "insert into Usuario (ahorro_papel, apellido, cedula, correo, nombre) " +
            "values (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void save(int ahorro, String apellido, String cedula, String correo, String nombre);


    @Modifying
    @Transactional
    @Query(value = "update Usuario set ahorro_papel = ?1 where id_usuario = ?2", nativeQuery = true)
    int updateAhorro(int ahorro, int idUsuario);

}
