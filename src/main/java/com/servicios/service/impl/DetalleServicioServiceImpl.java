package com.servicios.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servicios.model.dto.ClienteDTO;
import com.servicios.model.dto.DetalleServicioDTO;
import com.servicios.model.dto.MotoDTO;
import com.servicios.model.dto.ServicioMotoDTO;
import com.servicios.service.DetalleServicioService;

@Service
public class DetalleServicioServiceImpl implements DetalleServicioService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public DetalleServicioDTO obtenerInfoServicio(Long idCliente, Long idMoto, Long idServicio) {
        ClienteDTO cliente = restTemplate.getForObject("http://localhost:9090/api/clientes/" + idCliente, ClienteDTO.class);
        MotoDTO moto = restTemplate.getForObject("http://localhost:9090/api/motos/" + idMoto, MotoDTO.class);
        ServicioMotoDTO servicio = restTemplate.getForObject("http://localhost:9091/api/servicios/todos/" + idServicio, ServicioMotoDTO.class);

        DetalleServicioDTO detalle = new DetalleServicioDTO();
        detalle.setNombre(cliente.getNombre());


        detalle.setApellido(cliente.getApellido());
        detalle.setEmail(cliente.getEmail());
        detalle.setMarca(moto.getMarca());
        detalle.setModelo(moto.getModelo());
        detalle.setPlaca(moto.getPlaca());
        detalle.setFechaServicio(servicio.getFecha_servicio());
        detalle.setComentarios(servicio.getComentarios());
        detalle.setEstado(servicio.getEstado());
        detalle.setDescripcion(servicio.getDescripcion());
        detalle.setPrecio(servicio.getPrecio());


        return detalle;
    }
}
