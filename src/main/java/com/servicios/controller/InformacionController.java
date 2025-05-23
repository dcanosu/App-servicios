package com.servicios.controller;

import com.servicios.model.dto.InformacionDTO;
import com.servicios.service.InformacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/informacion")
public class InformacionController {

    @Autowired
    private InformacionService informacionService;

    @GetMapping("/info/{idCliente}/{idMoto}/{idServicioMoto}/{idServicio}")
    public ResponseEntity<InformacionDTO> obtenerDetalle(
        @PathVariable("idCliente") Long idCliente,
        @PathVariable("idMoto") Long idMoto,
        @PathVariable("idServicioMoto") Long idServicioMoto,
        @PathVariable("idServicio") Long idServicio
    ) {
        InformacionDTO informacion = informacionService.getInfo(idCliente, idMoto, idServicioMoto, idServicio);
        return ResponseEntity.ok(informacion);
    }
}