package com.openapi.taxonomiaservice.especies.domain;

public class EspecieAlreadyExistsException extends RuntimeException {
	
	public EspecieAlreadyExistsException(String nombreEspecie) {
		super("Ya existe una especie registrada con el mismo nombre: " + nombreEspecie);
	}

}
