package com.servicios.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // Le dice a Spring que esto es una clase de configuración
public class RestTemplateConfig {

    // Este método crea un "objeto" RestTemplate y lo registra en Spring
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
