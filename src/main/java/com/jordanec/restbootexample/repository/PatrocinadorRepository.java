package com.jordanec.restbootexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordanec.restbootexample.model.*;

@Repository
public interface PatrocinadorRepository extends CrudRepository<Patrocinador, Integer>, EntityRepositoryCustom<Patrocinador>{
	public Patrocinador findByNombre(String nombre);
	

	
}