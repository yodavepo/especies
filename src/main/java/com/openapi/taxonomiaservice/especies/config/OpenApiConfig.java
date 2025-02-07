package com.openapi.taxonomiaservice.especies.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
			version = "v1",
			title = "Microservicio para Información de Especies", 
			description = "Definición de los Endpoints de "
					+ "Especie Service para el sistema Pixup", 
			contact = @Contact(
				name = "Universidad Nacional Autónoma de México", 
				url = "https://www.ib.unam.mx/", 
			email = "davepo@ib.unam.mx")))

public class OpenApiConfig {

}
