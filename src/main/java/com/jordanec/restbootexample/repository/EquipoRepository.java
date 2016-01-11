package com.jordanec.restbootexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordanec.restbootexample.model.*;

@Repository
public interface EquipoRepository extends CrudRepository<Equipo, Integer>, EntityRepositoryCustom<Equipo>{
	public Equipo findByNombre(String nombre);
	

	
}