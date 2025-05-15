package com.servicios.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    // Insertar (POST)
    @PostMapping
    public ResponseEntity<Servicio> insertarServicio(@RequestBody Servicio servicio){
        Servicio nuevo = servicioService.insertServicio(servicio);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // Buscar por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Servicio> obtenerServicio(@PathVariable Long id){
        try{
            Servicio servicio = servicioService.findServicio(id);
            return ResponseEntity.ok(servicio);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    // Listar todos (GET)
    @GetMapping
    public ResponseEntity<List<Servicio>> listarServicio(){
        return ResponseEntity.ok(servicioService.listServicio());
    }

    // Actualizar (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Servicio> actualizarServicio(@PathVariable Long id, @RequestBody Servicio servicio) {
        try {
            servicio.setId(id); // Asegura que el ID coincida
            Servicio actualizado = servicioService.updateServicio(servicio);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable Long id) {
        try {
            servicioService.deleteServicio(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/todos")
    public List<Servicio> getAllServicios(){
        return servicioService.getAllServicios();
    }
}
