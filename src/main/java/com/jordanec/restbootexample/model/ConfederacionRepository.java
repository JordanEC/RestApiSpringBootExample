package com.jordanec.restbootexample.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;

import java.util.Optional;

//@RepositoryRestResource(path="")
public interface ConfederacionRepository extends CrudRepository<Confederacion, Integer>, ConfederacionRepositoryCustom{
	public Confederacion findByNombre(String nombre);
	

	
}