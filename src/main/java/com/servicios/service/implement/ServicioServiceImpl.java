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
        // return servicioRepositorio.findAll();
    }

    @Override
    public Servicio createServicio(Servicio servicio){
        return servicioRepositorio.save(servicio);
    }

    @Override
    public Servicio updateServicio(Long id, Servicio servicio){
        servicio.setId(id); // Establecemos el id para que se actualice el registro con el id correspondiente
        return servicioRepositorio.save(servicio); // Esto actualizará el servicio si el id existe
    }
}
