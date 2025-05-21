package com.servicios.service.impl;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;

// import com.servicios.model.dto.ClienteDTO;
// import com.servicios.model.dto.MotoDTO;
// import com.servicios.model.dto.ServicioMotoRespuesta;
import com.servicios.model.entities.ServicioMoto;
import com.servicios.model.repositories.ServicioMotoRepositorio;
import com.servicios.service.ServicioMotoService;

// http://blog.hadsonpar.com/2023/01/crud-con-spring-boot-postgresql-y.html
@Service
public class ServicioMotoServiceImpl implements ServicioMotoService {

    private final ServicioMotoRepositorio servicioMotoRepositorio;

    public ServicioMotoServiceImpl(ServicioMotoRepositorio servicioMotoRepositorio) {
        this.servicioMotoRepositorio = servicioMotoRepositorio;
    }

    @Override
    public ServicioMoto createServicioMoto(ServicioMoto servicioMoto){
        return servicioMotoRepositorio.save(servicioMoto);
    }

    @Override
    public ServicioMoto getServicioMotoById(Long id) throws Exception{
        return servicioMotoRepositorio.findById(id).orElseThrow(() -> new Exception("No se encontró el servicioMoto con id: " + id));
    }

    @Override
    public List<ServicioMoto> getAllServicioMotos(){
        return servicioMotoRepositorio.findAll();
    }

    @Override
    public List<ServicioMoto> getCustomServicioMotos(){
        return servicioMotoRepositorio.getAllServicioMotos(); //Metodo personalizado
        // return servicioRepositorio.findAll();
    }

    @Override
    public ServicioMoto updateServicioMoto(ServicioMoto servicioMoto) throws Exception{
        if (!servicioMotoRepositorio.existsById(servicioMoto.getId())) {
            throw new Exception("No se encontró el servicioMoto con id: " + servicioMoto.getId());
        }
        return servicioMotoRepositorio.save(servicioMoto);
    }

    public void deleteServicioMoto(Long id) throws Exception{
        getServicioMotoById(id); // lanza excepción si no existe
        servicioMotoRepositorio.deleteById(id);
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
}
