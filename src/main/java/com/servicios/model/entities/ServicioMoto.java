package com.servicios.model.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "servicio_motos")
public class ServicioMoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long moto_id;
    @Column(name = "servicio_id")
    Long fk_servicio_id;
    Long cargo_id;
    Date fecha_servicio;
    String comentarios;
    String estado;
}
