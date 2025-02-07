package com.openapi.taxonomiaservice.especies.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.openapi.taxonomiaservice.especies.domain.Familia;
import com.openapi.taxonomiaservice.especies.domain.Especie;
import com.openapi.taxonomiaservice.especies.domain.Genero;

@Data
@NoArgsConstructor
public class RegistroEspecieRequest {

	@NotNull
	@Valid
	private Especie especie;
	@NotNull
	@Valid
	private Familia familia;
	@NotNull
	@Valid
	private Genero genero;

	
}
