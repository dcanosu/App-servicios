package com.servicios.service;

import java.util.List;

import com.servicios.model.dto.ServicioMotoRespuesta;
import com.servicios.model.entities.ServicioMoto;

public interface ServicioMotoService {
    
    public ServicioMoto insertServicioMoto(ServicioMoto servicioMoto);

    public ServicioMoto findServicioMoto(Long id) throws Exception;

    public List<ServicioMoto> listServicioMoto();

    public ServicioMoto updateServicioMoto(ServicioMoto servicioMoto) throws Exception;

    public void deleteServicioMoto(Long id) throws Exception;

    public List<ServicioMoto>getAllServicioMotos();

    ServicioMotoRespuesta obtenerInfoServicio(Long idCliente, Long idMoto);
}