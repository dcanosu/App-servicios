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

import com.servicios.model.entities.ServicioMoto;
import com.servicios.service.ServicioMotoService;

@RestController
@RequestMapping("/api/serviciomotos")
public class ServicioMotoController {

    private final ServicioMotoService servicioMotoService;

    public ServicioMotoController(ServicioMotoService servicioMotoService) {
        this.servicioMotoService = servicioMotoService;
    }

    // Insertar (POST)
    @PostMapping
    public ResponseEntity<ServicioMoto> insertarServicioMoto(@RequestBody ServicioMoto servicioMoto){
        ServicioMoto nuevo = servicioMotoService.insertServicioMoto(servicioMoto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // Buscar por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<ServicioMoto> obtenerServicioMoto(@PathVariable Long id){
        try{
            ServicioMoto servicio = servicioMotoService.findServicioMoto(id);
            return ResponseEntity.ok(servicio);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    // Listar todos (GET)
    @GetMapping
    public ResponseEntity<List<ServicioMoto>> listarServicioMoto(){
        return ResponseEntity.ok(servicioMotoService.listServicioMoto());
    }

    // Actualizar (PUT)
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

    // Eliminar (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicioMoto(@PathVariable Long id) {
        try {
            servicioMotoService.deleteServicioMoto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/todos")
    public List<ServicioMoto> getAllServicios(){
        return servicioMotoService.getAllServicioMotos();
    }
}
