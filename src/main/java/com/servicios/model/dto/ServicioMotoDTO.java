package com.servicios.model.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicioMotoDTO {
    // private Long cargo_id;
    private Date fecha_servicio;
    private String comentarios;
    private String estado;
    private String descripcion;
    private String precio;
}
