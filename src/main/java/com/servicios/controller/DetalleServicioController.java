package com.servicios.controller;

import com.servicios.model.dto.DetalleServicioDTO;
import com.servicios.service.DetalleServicioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/detalles")
public class DetalleServicioController {

    @Autowired
    private DetalleServicioService detalleServicioService;

    @GetMapping("/info/{idCliente}/{idMoto}/{idServicio}")
    public ResponseEntity<DetalleServicioDTO> obtenerDetalle(
        @PathVariable Long idCliente,
        @PathVariable Long idMoto,
        @PathVariable Long idServicio
    ) {
        DetalleServicioDTO detalle = detalleServicioService.obtenerInfoServicio(idCliente, idMoto, idServicio);
        return ResponseEntity.ok(detalle);
    }
}
