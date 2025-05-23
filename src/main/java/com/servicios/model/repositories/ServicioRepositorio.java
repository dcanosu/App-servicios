package com.servicios.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.servicios.model.entities.Servicio;

@Repository
public interface ServicioRepositorio extends JpaRepository<Servicio, Long>{

    @Query(value = "SELECT * FROM servicios", nativeQuery = true)
    List<Servicio> getAllServicios();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios WHERE nombre = :nombre", nativeQuery = true)
    int deleteOneServicio(@Param("nombre") String nombre);
}
