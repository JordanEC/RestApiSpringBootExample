package com.jordanec.restbootexample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.stereotype.Repository;

import com.jordanec.restbootexample.model.Equipo;

import java.util.Optional;

@Repository
public interface EquipoRepository extends CrudRepository<Equipo, Integer>, EquipoRepositoryCustom{
	public Equipo findByNombre(String nombre);
	

	
}