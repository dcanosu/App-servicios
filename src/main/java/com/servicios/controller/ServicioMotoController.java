package com.servicios.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

// import com.servicios.model.dto.ServicioMotoRespuesta;
import com.servicios.model.entities.ServicioMoto;
import com.servicios.service.ServicioMotoService;

@RestController
@RequestMapping("/api/serviciomotos")
public class ServicioMotoController {

    private final ServicioMotoService servicioMotoService;

    public ServicioMotoController(ServicioMotoService servicioMotoService) {
        this.servicioMotoService = servicioMotoService;
    }

    // Crear servicioMoto (POST)
    @PostMapping
    public ResponseEntity<ServicioMoto> crearServicioMoto(@RequestBody ServicioMoto servicioMoto){
        ServicioMoto nuevo = servicioMotoService.createServicioMoto(servicioMoto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // Buscar un servicioMoto por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerServicioMoto(@PathVariable("id") Long id){
        try{
            ServicioMoto servicioMoto = servicioMotoService.getServicioMotoById(id);
            return ResponseEntity.ok(servicioMoto);
        }catch (Exception e){
            Map<String, String> error = new HashMap<>();
            error.put("mensaje", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el servicio con id: " + id);
        }
    }

    // Listar todos los servicioMotos (GET)
    @GetMapping
    public ResponseEntity<List<ServicioMoto>> listarServicioMotos(){
        return ResponseEntity.ok(servicioMotoService.getAllServicioMotos());
    }

    @GetMapping("/todos")
    public List<ServicioMoto> listarServicioMotosPersonalizado(){
        return servicioMotoService.getCustomServicioMotos();
    }

    // Actualizar un servicioMoto (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<ServicioMoto> actualizarServicioMoto(@PathVariable Long id, @RequestBody ServicioMoto servicioMoto) {
        try {
            servicioMoto.setId(id); // Asegura que el ID coincida
            ServicioMoto actualizado = servicioMotoService.updateServicioMoto(servicioMoto);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un servicioMoto (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicioMoto(@PathVariable Long id) {
        try {
            servicioMotoService.deleteServicioMoto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
