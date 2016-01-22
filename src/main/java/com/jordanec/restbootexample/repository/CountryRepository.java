package com.jordanec.restbootexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.jordanec.restbootexample.model.*;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer>, EntityRepositoryCustom<Country>{
	@PreAuthorize("#oauth2.hasScope('read') || #oauth2.hasScope('write')")
	public Country findByName(String name);
	
	@Override
	@PreAuthorize("#oauth2.hasScope('read') || #oauth2.hasScope('write')")
	Country findOne(Integer aInt);
	
	@Override
	@PreAuthorize("#oauth2.hasScope('read') || #oauth2.hasScope('write')")
	Iterable<Country> findAll();
	
	@Override
	@PreAuthorize("#oauth2.hasScope('write')")
	<S extends Country> S save(S entity);
	
	@Override
	@PreAuthorize("#oauth2.hasScope('write')")
	void delete(Integer id);
	
	
}