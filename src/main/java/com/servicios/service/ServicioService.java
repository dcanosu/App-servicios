package com.servicios.service;

import java.util.List;

import com.servicios.model.entities.Servicio;

public interface ServicioService {
    List<Servicio>getAllServicios();

    Servicio createServicio(Servicio servicio);

    Servicio updateServicio(Long id, Servicio servicio);
}
