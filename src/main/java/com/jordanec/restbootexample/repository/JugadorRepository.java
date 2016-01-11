package com.jordanec.restbootexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordanec.restbootexample.model.*;

@Repository
public interface JugadorRepository extends CrudRepository<Jugador, Integer>, EntityRepositoryCustom<Jugador>{
	public Jugador findByNombre(String nombre);
}