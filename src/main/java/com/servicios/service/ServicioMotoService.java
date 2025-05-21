package com.servicios.service;

import java.util.List;

// import com.servicios.model.dto.ServicioMotoRespuesta;
import com.servicios.model.entities.ServicioMoto;

public interface ServicioMotoService {
    
    ServicioMoto createServicioMoto(ServicioMoto servicioMoto);

    ServicioMoto getServicioMotoById(Long id) throws Exception;

    List<ServicioMoto> getAllServicioMotos();

    List<ServicioMoto>getCustomServicioMotos();

    ServicioMoto updateServicioMoto(ServicioMoto servicioMoto) throws Exception;

    void deleteServicioMoto(Long id) throws Exception;

    // ServicioMotoRespuesta obtenerInfoServicio(Long idCliente, Long idMoto);
}