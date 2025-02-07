package com.openapi.taxonomiaservice.especies.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Familia {
	
	@NotBlank(message="La Familia de la especie no puede ser blanco")
	private String familia;
}
