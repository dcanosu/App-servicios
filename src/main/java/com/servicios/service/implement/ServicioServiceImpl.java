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
    public Servicio createServicioManual(Servicio datos){
        Servicio nuevo = new Servicio(); // Creamos un nuevo objeto
    
        // Asignamos manualmente los datos
        nuevo.setNombre(datos.getNombre());
        nuevo.setDescripcion(datos.getDescripcion());
        nuevo.setPrecio(datos.getPrecio());
    
        // Podés agregar validaciones acá si querés
    
        return servicioRepositorio.save(nuevo); // Guardamos en la base
    }

    @Override
    public Servicio updateServicio(Long id, Servicio servicio){
        servicio.setId(id); // Establecemos el id para que se actualice el registro con el id correspondiente
        return servicioRepositorio.save(servicio); // Esto actualizará el servicio si el id existe
    }

    @Override
    public Servicio updateServicio2(Long id, Servicio servicio){
        Servicio servicioExistente = servicioRepositorio.findById(id)
            .orElseThrow(() -> new RuntimeException("Servicio no encontrado con ID: " + id));
    
        // Solo actualiza los campos que vienen distintos de null
        if(servicio.getNombre() != null){
            servicioExistente.setNombre(servicio.getNombre());
        }
        if(servicio.getDescripcion() != null){
            servicioExistente.setDescripcion(servicio.getDescripcion());
        }
        if(servicio.getPrecio() != null){
            servicioExistente.setPrecio(servicio.getPrecio());
        }
        return servicioRepositorio.save(servicioExistente);
    }    
}
