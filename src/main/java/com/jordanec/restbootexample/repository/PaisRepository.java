package com.jordanec.restbootexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordanec.restbootexample.model.*;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Integer>, EntityRepositoryCustom<Pais>{
	public Pais findByNombre(String nombre);
}