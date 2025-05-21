package com.servicios.service;

import com.servicios.model.dto.InformacionDTO;

public interface InformacionService {
    InformacionDTO getInfo(Long idCliente, Long idMoto, Long idServicio);
}