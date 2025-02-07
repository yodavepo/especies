package com.openapi.taxonomiaservice.especies.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openapi.taxonomiaservice.especies.domain.Especie;
import com.openapi.taxonomiaservice.especies.domain.Familia;
import com.openapi.taxonomiaservice.especies.domain.EspecieAlreadyExistsException;
import com.openapi.taxonomiaservice.especies.repository.EspecieRepository;
import com.openapi.taxonomiaservice.especies.repository.FamiliaRepository;



@Service
public class EspecieServiceImpl implements EspecieService {

	@Autowired 
	private EspecieRepository especieReposity ;

	private static final Logger LOG = 
			LoggerFactory.getLogger(EspecieServiceImpl.class);

	@Override
	public Especie registrarEspecie(Especie especie, Familia familia) {
		// validacion Especie existente
		Optional<Especie> especieExistente = 
				especieReposity.findByFamilia(especie.getFamilia());
		if (especieExistente.isPresent()) {
			throw new EspecieAlreadyExistsException(especie.getNombreEspecie());
		}
		
		// guardar especie
		especie.getFamilias().add(familia);
		especieReposity.save(especie);
		LOG.info("Especie Registrada: " + especie);
		
		return especie;
	}
	
}
