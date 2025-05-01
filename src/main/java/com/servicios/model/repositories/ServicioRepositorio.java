package com.servicios.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.servicios.model.entities.Servicio;

// 📌 ¿Qué hace un repository?
// Conecta la entidad con la base de datos.

// Hereda métodos ya listos como: save(), findById(), findAll(), delete(), etc.

// Podés agregar métodos personalizados con nombres como findByNombre, findByPrecioGreaterThan, etc.

// ✅ ¿Qué hay que tener en cuenta?
// Tenés que usar @Repository (opcional pero recomendado por claridad).

// El primer parámetro de JpaRepository es la entidad y el segundo es el tipo de su ID (Long, Integer, etc.).

// Spring hace toda la magia, no necesitás implementaciones.

// 🧱 Siguiente paso:
// Ya con tu ServicioRepository creado, podrías ir al service y empezar a usarlo para hacer lógica de negocio. Si querés, te muestro cómo va la clase de servicio (ServicioService).

// ¿Te muestro un ejemplo de ServicioService con métodos básicos o querés que implementemos uno más específico, como buscar por nombre o crear un servicio?
@Repository
public interface ServicioRepositorio extends JpaRepository<Servicio, Long>{

    @Query(value = "SELECT * FROM servicios", nativeQuery = true)
    List<Servicio> getAllServicios();
}
