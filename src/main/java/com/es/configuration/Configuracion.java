package com.es.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.*;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
/**
 *
 * @author Faustino Lopez Ramos
 * @version 0.1
 * @since 2024-02-20
 */
@Configuration
public class Configuracion {

    @Bean("modelMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info().title("Easy Shop").version("0.1.0"));
    }

}
