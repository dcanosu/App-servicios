package com.servicios.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicioMotoRespuesta {
    private ClienteDTO cliente;
    private MotoDTO moto;

    public ServicioMotoRespuesta(ClienteDTO cliente) {
        this.cliente = cliente;
    }
}
