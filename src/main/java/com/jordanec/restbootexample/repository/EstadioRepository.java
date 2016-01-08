package com.jordanec.restbootexample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;

import com.jordanec.restbootexample.model.Estadio;

import java.util.Optional;

//@RepositoryRestResource(path="")
public interface EstadioRepository extends CrudRepository<Estadio, Integer>, EstadioRepositoryCustom{
	public Estadio findByNombre(String nombre);
	

	
}