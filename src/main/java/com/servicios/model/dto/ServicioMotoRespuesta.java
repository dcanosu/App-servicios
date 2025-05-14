package com.servicios.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicioMotoRespuesta {
    private ClienteDto cliente;
    private MotoDto moto;
    // private ServicioMoto servicioMoto;

    public ServicioMotoRespuesta(ClienteDto cliente, MotoDto moto) {
        this.cliente = cliente;
        this.moto = moto;
        // this.servicioMoto = servicioMoto;
    }

}
