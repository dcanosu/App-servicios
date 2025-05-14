package com.servicios.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servicios.model.dto.ClienteDto;
import com.servicios.model.dto.MotoDto;
import com.servicios.model.dto.ServicioMotoRespuesta;
import com.servicios.model.entities.ServicioMoto;
import com.servicios.model.repositories.ServicioMotoRepositorio;
import com.servicios.service.ServicioMotoService;

// http://blog.hadsonpar.com/2023/01/crud-con-spring-boot-postgresql-y.html
@Service
public class ServicioServiceMotoImpl implements ServicioMotoService {

    private final ServicioMotoRepositorio servicioMotoRepositorio;

    // @Autowired -> No es recomendable prosionalmente dado que no facilita pruebas mocks
    // ServicioMotoRepositorio servicioMotoRepositorio2;

    @Override
    public ServicioMoto insertServicioMoto(ServicioMoto servicioMoto){
        return servicioMotoRepositorio.save(servicioMoto);
    }

    public ServicioServiceMotoImpl(ServicioMotoRepositorio servicioMotoRepositorio) {
        this.servicioMotoRepositorio = servicioMotoRepositorio;
    }

    @Override
    public ServicioMoto findServicioMoto(Long id) throws Exception{
        return servicioMotoRepositorio.findById(id).orElseThrow(
            () -> new Exception("No se encontro el id"));
    }

    @Override
    public List<ServicioMoto> listServicioMoto(){
        return servicioMotoRepositorio.findAll();
    }

    @Override
    public ServicioMoto updateServicioMoto(ServicioMoto servicioMoto) throws Exception{
        if (!servicioMotoRepositorio.existsById(servicioMoto.getId())) {
            throw new Exception("No se encontró el ID: " + servicioMoto.getId());
        }
        return servicioMotoRepositorio.save(servicioMoto);
    }

    // @Override
    // public ServicioMoto updateServicioMoto(ServicioMoto servicioMoto) throws Exception{
    //     findServicioMoto(servicioMoto.getId());
    //     return servicioMotoRepositorio.save(servicioMoto);
    // }

    public void deleteServicioMoto(Long id) throws Exception{
        findServicioMoto(id); // lanza excepción si no existe
        servicioMotoRepositorio.deleteById(id);
    }

    @Override
    public List<ServicioMoto> getAllServicioMotos(){
        return servicioMotoRepositorio.getAllServicioMotos(); //Metodo personalizado
        // return servicioRepositorio.findAll();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ServicioMotoRespuesta obtenerInfoServicio(Long idCliente, Long idMoto) {
        ClienteDto cliente = restTemplate.getForObject(
            "http://localhost:9090/api/clientes/" + idCliente, ClienteDto.class);

        MotoDto moto = restTemplate.getForObject(
            "http://localhost:9090/api/motos/" + idMoto, MotoDto.class);
        
        // ServicioMoto servicioMoto = restTemplate.getForObject(
        //     "http://localhost:9091/api/servicios/" + moto_id, ServicioMoto.class);

        return new ServicioMotoRespuesta(cliente, moto);
    }
}
