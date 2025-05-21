package com.servicios.service;

import java.util.List;

import com.servicios.model.entities.Servicio;

public interface ServicioService {

    Servicio createServicio(Servicio servicio);

    Servicio getServicioById(Long id) throws Exception;

    List<Servicio> getAllServicios();

    List<Servicio>getCustomServicios();

    Servicio updateServicio(Servicio servicio) throws Exception;

    public void deleteServicio(Long id) throws Exception;
}