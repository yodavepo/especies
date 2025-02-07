package com.openapi.taxonomiaservice.especies.domain;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection="especies")

public class Especie {
	
	@Id
	private String id;
	@NotBlank(message="Nombre de la especie no puede ser blanco")
	private String nombreEspecie;
	@NotBlank(message="La familia no puede ser blanco")
	private String familia;
	private String genero;
	private Collection<Familia> familias = new LinkedHashSet<>();

}
