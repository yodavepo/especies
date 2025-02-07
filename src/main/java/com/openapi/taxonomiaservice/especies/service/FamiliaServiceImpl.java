package com.openapi.taxonomiaservice.especies.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openapi.taxonomiaservice.especies.domain.Familia;
import com.openapi.taxonomiaservice.especies.repository.FamiliaRepository;

@Service
public class FamiliaServiceImpl implements FamiliaService {

	@Autowired
	private FamiliaRepository familiaRepository;

	@Override
	public Familia actualizarFamilia(String id, Familia familia) {
		Optional<Familia> familiaExistente = familiaRepository.findById(id);
		if (familiaExistente.isPresent()) {
			Familia familiaActualizar = familiaExistente.get();
			familiaActualizar.setFamilia(familia.getFamilia());
			familiaRepository.save(familiaActualizar);
			return familiaActualizar;
		}
		return null;
	}
	
}
