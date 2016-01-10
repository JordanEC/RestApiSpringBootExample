package com.jordanec.restbootexample.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.jordanec.restbootexample.model.Estadio;

public class EstadioRepositoryImpl implements EntityRepositoryCustom<Estadio>{
	
	@PersistenceContext
    private EntityManager em;
	
	@Transactional
	@Override
	public boolean update(Estadio estadio) {
		getEm().merge(estadio);
		return true;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Collection<Estadio> getOlderThan(int edad) {
		return null;
	}

}
