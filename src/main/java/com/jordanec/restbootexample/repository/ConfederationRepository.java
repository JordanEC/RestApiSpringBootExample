package com.jordanec.restbootexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordanec.restbootexample.model.*;

@Repository
public interface ConfederationRepository extends CrudRepository<Confederation, Integer>, EntityRepositoryCustom<Confederation>{
	public Confederation findByName(String name);
	

	
}