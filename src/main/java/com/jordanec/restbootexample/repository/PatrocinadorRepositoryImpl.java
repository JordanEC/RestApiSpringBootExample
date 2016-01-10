package com.jordanec.restbootexample.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.jordanec.restbootexample.model.Jugador;
import com.jordanec.restbootexample.model.Patrocinador;

public class PatrocinadorRepositoryImpl implements EntityRepositoryCustom<Patrocinador>{
	
	@PersistenceContext
    private EntityManager em;
	
	@Transactional
	@Override
	public boolean update(Patrocinador patrocinador) {
		getEm().merge(patrocinador);
		return true;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Collection<Patrocinador> getOlderThan(int edad) {
		return null;
	}

}
