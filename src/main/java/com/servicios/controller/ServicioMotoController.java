package com.servicios.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.model.entities.ServicioMoto;
import com.servicios.service.ServicioMotoService;

@RestController
@RequestMapping("/api/serviciomotos")
public class ServicioMotoController {

    private final ServicioMotoService servicioMotoService;

    public ServicioMotoController(ServicioMotoService servicioMotoService) {
        this.servicioMotoService = servicioMotoService;
    }

    @GetMapping("/todos")
    public List<ServicioMoto> getAllServicios(){
        return servicioMotoService.getAllServicioMotos();
    }
}
