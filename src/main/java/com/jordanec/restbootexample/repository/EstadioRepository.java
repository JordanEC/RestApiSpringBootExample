package com.jordanec.restbootexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordanec.restbootexample.model.*;


@Repository
public interface EstadioRepository extends CrudRepository<Estadio, Integer>, EntityRepositoryCustom<Estadio>{
	public Estadio findByNombre(String nombre);
	

	
}