package com.servicios.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    // private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private MotoDTO moto;
    // private ServicioDto servicio;
}
