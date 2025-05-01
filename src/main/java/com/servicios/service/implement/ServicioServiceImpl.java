package com.servicios.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.servicios.model.entities.Servicio;
import com.servicios.model.repositories.ServicioRepositorio;
import com.servicios.service.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService {
    
    private final ServicioRepositorio servicioRepositorio;

    public ServicioServiceImpl(ServicioRepositorio servicioRepositorio) {
        this.servicioRepositorio = servicioRepositorio;
    }

    @Override
    public List<Servicio> getAllServicios(){
        return servicioRepositorio.getAllServicios(); //Metodo personalizado
    }
}
