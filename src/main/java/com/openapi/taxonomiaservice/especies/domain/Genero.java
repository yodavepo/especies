package com.openapi.taxonomiaservice.especies.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection="familias")
public class Genero {

	@Id
	private String id;
	private String genero;
}
