
package com.servicios.model.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class InformacionDTO {
    // App-clientes -> clientes_bd -> clientes
    private String nombre;
    private String apellido;
    private String email;

    // App-clientes -> clientes_bd -> motos
    private String marca;
    private String modelo;
    private String placa;

    // App-servicios -> servicios_db -> servicio_motos
    private Date fechaServicio;
    private String comentarios;
    private String estado;

    // App-servicios -> servicios_db -> servicio_motos
    private String descripcion;
    private String precio;
}
