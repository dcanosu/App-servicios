package com.servicios.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servicios.model.dto.ClienteDTO;
import com.servicios.model.dto.InformacionDTO;
import com.servicios.model.dto.MotoDTO;
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

    @Value("${servicio.servicioMotos.url}")
    private String servicioMotosUrl;

    @Override
    public InformacionDTO getInfo(Long idCliente, Long idMoto, Long idServicio) {
        ClienteDTO cliente = restTemplate.getForObject(clientesUrl + idCliente, ClienteDTO.class);
        // ClienteDTO cliente = restTemplate.getForObject("http://localhost:9090/api/clientes/" + idCliente, ClienteDTO.class);
        MotoDTO moto = restTemplate.getForObject(motosUrl + idMoto, MotoDTO.class);
        ServicioMotoDTO servicioMotos = restTemplate.getForObject(servicioMotosUrl + idServicio, ServicioMotoDTO.class);

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
        detalle.setDescripcion(servicioMotos.getDescripcion());
        detalle.setPrecio(servicioMotos.getPrecio());

        return detalle;
    }
}

    // @Autowired
    // private RestTemplate restTemplate;

    // @Override
    // public ServicioMotoRespuesta obtenerInfoServicio(Long idCliente, Long idMoto) {
    //     ClienteDTO cliente = obtenerCliente(idCliente);
    //     MotoDTO moto = obtenerMoto(idMoto);

    //     cliente.setMoto(moto); // Asignar la moto al cliente

    //     return new ServicioMotoRespuesta(cliente);
    // }

    // private ClienteDTO obtenerCliente(Long idCliente){
    //     return restTemplate.getForObject("http://localhost:9090/api/clientes/" + idCliente, ClienteDTO.class);
    // }

    // private MotoDTO obtenerMoto(Long idMoto){
    //     return restTemplate.getForObject("http://localhost:9090/api/motos/" + idMoto, MotoDTO.class);
    // }