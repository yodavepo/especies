package com.openapi.taxonomiaservice.especies.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.openapi.taxonomiaservice.especies.domain.Especie;
import com.openapi.taxonomiaservice.especies.dto.RegistroEspecieRequest;
import com.openapi.taxonomiaservice.especies.service.EspecieService;

@RestController

public class EspecieController implements EspecieApi {
	
	@Autowired
	private EspecieService especieService;
	
	@Override
	public Especie registrarEspecie(
			RegistroEspecieRequest request) {
		return especieService.registrarEspecie(
			request.getEspecie(), request.getFamilia());
	}

}
