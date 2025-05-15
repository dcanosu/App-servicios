package com.servicios.service;

import com.servicios.model.dto.DetalleServicioDTO;

public interface DetalleServicioService {
    DetalleServicioDTO obtenerInfoServicio(Long idCliente, Long idMoto, Long idServicio);
}
