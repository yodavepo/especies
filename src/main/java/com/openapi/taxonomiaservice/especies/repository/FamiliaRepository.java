package com.openapi.taxonomiaservice.especies.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.openapi.taxonomiaservice.especies.domain.Familia;

public interface FamiliaRepository 
extends MongoRepository<Familia, String>{

}
