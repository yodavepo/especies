package com.openapi.taxonomiaservice.especies.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.openapi.taxonomiaservice.especies.domain.Especie;


public interface EspecieRepository 

	extends MongoRepository<Especie, String>{
	
	Optional<Especie> findByFamilia(String familia);

}
