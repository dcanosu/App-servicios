package com.servicios.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.servicios.model.entities.ServicioMoto;

@Repository
public interface ServicioMotoRepositorio extends JpaRepository<ServicioMoto, Long>{
    @Query(value = "SELECT * FROM servicio_motos", nativeQuery = true)
    List<ServicioMoto> getAllServicioMotos();
}
