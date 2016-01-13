package com.jordanec.restbootexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordanec.restbootexample.model.*;

@Repository
public interface SponsorRepository extends CrudRepository<Sponsor, Integer>, EntityRepositoryCustom<Sponsor>{
	public Sponsor findByName(String name);
	

	
}