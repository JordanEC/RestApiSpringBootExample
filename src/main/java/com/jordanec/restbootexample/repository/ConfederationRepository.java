package com.jordanec.restbootexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import com.jordanec.restbootexample.model.*;

@Repository
public interface ConfederationRepository extends CrudRepository<Confederation, Integer>, EntityRepositoryCustom<Confederation>{
	@PreAuthorize("#oauth2.hasScope('read') || #oauth2.hasScope('write')")
	public Confederation findByName(String name);
	
	@Override
	@PreAuthorize("#oauth2.hasScope('read') || #oauth2.hasScope('write')")
	Confederation findOne(Integer aInt);
	
	@Override
	@PreAuthorize("#oauth2.hasScope('read') || #oauth2.hasScope('write')")
	Iterable<Confederation> findAll();
	
	@Override
	@PreAuthorize("#oauth2.hasScope('write')")
	<S extends Confederation> S save(S entity);
	
	@Override
	@PreAuthorize("#oauth2.hasScope('write')")
	void delete(Integer id);
}