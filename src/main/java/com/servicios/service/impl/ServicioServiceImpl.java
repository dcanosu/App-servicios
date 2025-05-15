package com.servicios.service.impl;

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
    public Servicio insertServicio(Servicio servicioServicio){
        return servicioRepositorio.save(servicioServicio);
    }

    @Override
    public Servicio findServicio(Long id) throws Exception {
        return servicioRepositorio.findById(id).orElseThrow(() -> new Exception("No se encontró el servicio: " + id));
    }

    @Override
    public List<Servicio> listServicio(){
        return servicioRepositorio.findAll();
    }

    @Override
    public Servicio updateServicio(Servicio servicio) throws Exception{
        if (!servicioRepositorio.existsById(servicio.getId())) {
            throw new Exception("No se encontró el servicio: " + servicio.getId());
        }
        return servicioRepositorio.save(servicio);
    }

    public void deleteServicio(Long id) throws Exception{
        findServicio(id); // lanza excepción si no existe
        servicioRepositorio.deleteById(id);
    }

    @Override
    public List<Servicio> getAllServicios(){
        return servicioRepositorio.getAllServicios(); //Metodo personalizado
        // return servicioRepositorio.findAll();
    }
}
