package com.openapi.taxonomiaservice.especies.service;

import com.openapi.taxonomiaservice.especies.domain.Familia;
import com.openapi.taxonomiaservice.especies.domain.Especie;

public interface EspecieService {

	Especie registrarEspecie(
			Especie especie, Familia familia);
	
}
