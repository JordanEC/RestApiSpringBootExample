package com.jordanec.restbootexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordanec.restbootexample.model.Confederacion;

@Repository
public interface ConfederacionRepository extends CrudRepository<Confederacion, Integer>, EntityRepositoryCustom<Confederacion>{
	public Confederacion findByNombre(String nombre);
	

	
}