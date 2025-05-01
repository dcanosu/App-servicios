CREATE DATABASE IF NOT EXISTS servicios_db;
USE servicios_db;

CREATE TABLE servicios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10,2) NOT NULL,
    ALTER TABLE servicios ADD COLUMN activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE servicio_motos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    moto_id INT,
    servicio_id INT,
    cargo_id INT,
    fecha_servicio DATE NOT NULL,
    comentarios VARCHAR(255),
    FOREIGN KEY (servicio_id) REFERENCES servicios(id),
    ALTER TABLE servicio_motos ADD COLUMN estado VARCHAR(20) DEFAULT "Terminado"
);

-- ESTADOS POSIBLES:
-- - Pendiente
-- - En proceso
-- - Cancelado
-- - Finalizado