package com.servicios.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @PostMapping("/crear")
    public ResponseEntity<Servicio> createServicio(@RequestBody Servicio servicio){
        Servicio createdServicio = servicioService.createServicio(servicio);
        return new ResponseEntity<>(createdServicio, HttpStatus.CREATED);
    }

    @PostMapping("/crearManual")
    public ResponseEntity<Servicio> createServicioManual(@RequestBody Servicio servicio){
        Servicio createdServicio = servicioService.createServicioManual(servicio);
        return new ResponseEntity<>(createdServicio, HttpStatus.CREATED);  // Responde con 201 (Created)
    }

    @PutMapping("/actualizar/{id}")
    public Servicio updatedServicio2(@PathVariable Long id, @RequestBody Servicio servicio){
        servicio.setId(id); // Establecemos el id para que se actualice el servicio con el id correspondiente
        return servicioService.updateServicio2(id, servicio); // Llamamos al servicio que realiza la actualización
    }
}
