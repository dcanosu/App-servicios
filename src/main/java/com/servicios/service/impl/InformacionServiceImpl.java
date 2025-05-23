package com.servicios.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servicios.model.dto.ClienteDTO;
// import com.servicios.model.dto.EmpleadoDTO;
import com.servicios.model.dto.InformacionDTO;
import com.servicios.model.dto.MotoDTO;
import com.servicios.model.dto.ServicioDTO;
import com.servicios.model.dto.ServicioMotoDTO;
import com.servicios.service.InformacionService;

@Service
public class InformacionServiceImpl implements InformacionService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${servicio.clientes.url}")
    private String clientesUrl;

    @Value("${servicio.motos.url}")
    private String motosUrl;

    @Value("${servicio.serviciomotos.url}")
    private String serviciomotosUrl;

    @Value("${servicio.servicios.url}")
    private String servicioUrl;

    @Value("${servicio.empleados.url}")
    private String empleadosUrl;

    @Override    
    // public InformacionDTO getInfo(Long idCliente, Long idMoto, Long idServicioMoto, Long idServicio, Long idEmpleado) {
    public InformacionDTO getInfo(Long idCliente, Long idMoto, Long idServicioMoto, Long idServicio) {
        ClienteDTO cliente = restTemplate.getForObject(clientesUrl + idCliente, ClienteDTO.class);
        // ClienteDTO cliente = restTemplate.getForObject("http://localhost:9090/api/clientes/" + idCliente, ClienteDTO.class);
        MotoDTO moto = restTemplate.getForObject(motosUrl + idMoto, MotoDTO.class);
        ServicioMotoDTO servicioMotos = restTemplate.getForObject(serviciomotosUrl + idServicioMoto, ServicioMotoDTO.class);
        ServicioDTO servicio = restTemplate.getForObject(servicioUrl + idServicio, ServicioDTO.class);
        // EmpleadoDTO empleado = restTemplate.getForObject(empleadosUrl, idEmpleado, EmpleadoDTO.class);

        InformacionDTO detalle = new InformacionDTO();
        detalle.setNombre(cliente.getNombre());
        detalle.setApellido(cliente.getApellido());
        detalle.setEmail(cliente.getEmail());
        detalle.setMarca(moto.getMarca());
        detalle.setModelo(moto.getModelo());
        detalle.setPlaca(moto.getPlaca());
        detalle.setFechaServicio(servicioMotos.getFecha_servicio());
        detalle.setComentarios(servicioMotos.getComentarios());
        detalle.setEstado(servicioMotos.getEstado());
        detalle.setDescripcion(servicio.getDescripcion());
        detalle.setPrecio(servicio.getPrecio());
        // detalle.setNombre(empleado.getNombre));

        return detalle;
    }
}