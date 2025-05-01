package com.servicios.model.entities;

// Estas son anotaciones de JPA (Jakarta Persistence API) para trabajar con entidades y mapear esta clase a una tabla en la base de datos.
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// Estas son anotaciones de Lombok, una librería que reduce el código repetitivo (como getters, setters, constructores, etc.).
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Marca esta clase como una entidad JPA, es decir, que se va a mapear a una tabla en la base de datos.
@Entity
// @Getter y @Setter: Genera automáticamente los métodos get y set para todos los atributos.
@Setter
@Getter
// @Builder: Permite construir objetos usando el patrón builder (Servicio.builder().nombre("...").build()).
@Builder
// @NoArgsConstructor: Genera un constructor sin parámetros.
@NoArgsConstructor
// @AllArgsConstructor: Genera un constructor con todos los atributos como parámetros.
@AllArgsConstructor
// Especifica que esta entidad se mapea a la tabla llamada servicios en la base de datos.
@Table(name = "servicios")
public class Servicio {
    // @Id: Define que este campo es la clave primaria de la tabla.
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY): Indica que el valor de id será generado automáticamente por la base de datos, usando auto-incremento.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Estos son los atributos que representan las columnas de la tabla servicios. No necesitan anotaciones extra si los nombres coinciden con los nombres de las columnas (por convención).
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
}
