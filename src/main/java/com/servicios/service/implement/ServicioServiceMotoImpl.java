package com.servicios.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.servicios.model.entities.ServicioMoto;
import com.servicios.model.repositories.ServicioMotoRepositorio;
import com.servicios.service.ServicioMotoService;

@Service
public class ServicioServiceMotoImpl implements ServicioMotoService {

    private final ServicioMotoRepositorio servicioMotoRepositorio;

    public ServicioServiceMotoImpl(ServicioMotoRepositorio servicioMotoRepositorio) {
        this.servicioMotoRepositorio = servicioMotoRepositorio;
    }

    @Override
    public List<ServicioMoto> getAllServicioMotos(){
        return servicioMotoRepositorio.getAllServicioMotos(); //Metodo personalizado
        // return servicioRepositorio.findAll();
    }
}
