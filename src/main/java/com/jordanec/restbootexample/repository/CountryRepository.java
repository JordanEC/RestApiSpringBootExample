package com.jordanec.restbootexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordanec.restbootexample.model.*;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer>, EntityRepositoryCustom<Country>{
	public Country findByName(String name);
}