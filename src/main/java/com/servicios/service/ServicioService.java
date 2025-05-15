package com.servicios.service;

import java.util.List;

import com.servicios.model.entities.Servicio;

public interface ServicioService {
    // List<Servicio>getAllServicios();

    public Servicio insertServicio(Servicio servicioServicio);

    public Servicio findServicio(Long id) throws Exception;

    public List<Servicio> listServicio();

    public Servicio updateServicio(Servicio servicioServicio) throws Exception;

    public void deleteServicio(Long id) throws Exception;

    public List<Servicio>getAllServicios();
}
