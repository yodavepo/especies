package com.openapi.taxonomiaservice.especies.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import com.openapi.taxonomiaservice.especies.domain.Especie;
import com.openapi.taxonomiaservice.especies.dto.RegistroEspecieRequest;


@RequestMapping(path="api/especies", produces="application/json")
@CrossOrigin(origins="*")
@Tag(name="especie", description="API del Recurso Especie")

public interface EspecieApi {

	@Operation(summary = "Registrar Especie")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", 
		description = "Especie Creada Exitosamente", 
	    content = { 
	    	@Content(mediaType="application/json", 
	    	schema = @Schema(implementation=Especie.class)) }),
	  @ApiResponse(responseCode = "409", 
	  	description="Ya existe una especie con el nombre especificado", 
	    content = @Content) })
	@PostMapping(path="registro", consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	Especie registrarEspecie(
		@NotNull @Valid @RequestBody RegistroEspecieRequest request);

	
	
}
