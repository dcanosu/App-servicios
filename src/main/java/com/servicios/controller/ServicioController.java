package com.servicios.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.model.entities.Servicio;
import com.servicios.service.ServicioService;


// @RestController: Le dice a Spring que esta clase maneja peticiones REST.
@RestController
// @RequestMapping("/api/servicios"): agrupa los endpoints bajo una ruta base clara y RESTful.
@RequestMapping("/api/servicios")
public class ServicioController {
    
    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping("/todos")
    public List<Servicio> getAllServicios(){
        return servicioService.getAllServicios();
    }
    

}
