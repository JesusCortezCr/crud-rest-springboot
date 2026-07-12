package com.cortez.proyectos.api_crud.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info=@Info(
        title = "API PERSONAS",
        description="API DONDE SE PUEDE GESTIONAR PERSONAS , CREACIONES , LISTADO , BUSQUEDAS Y ACTUALIZACIONES",
        termsOfService = "www.unprogramadornace.com/terminos_y_servicios",
        version = "1.0.0",
        contact = @Contact(
            name="cortez jesus",
            email = "cortezeduardor15@gmail.com"
        )
    
    ),
    servers = {
        @Server(
            description = "DEV SERVER",
            url = "http://localhost:8080"
        ),
        @Server(
            description = "PROD SERVER",
            url = "http://unprogramador:8080"
        )
    }
)
public class SwaggerConfig {

}
