package com.jordanec.restbootexample.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.jordanec.restbootexample.model.Jugador;

public class JugadorRepositoryImpl implements JugadorRepositoryCustom{
	
	@PersistenceContext
    private EntityManager em;
	
	@Transactional
	@Override
	public boolean update(Object object) {
		getEm().merge(object);
		return true;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Collection<Jugador> getOlderThan(int edad) {
		return (Collection<Jugador>) getEm().createQuery("FROM Jugador where edad > :edad").setParameter("edad", edad).getResultList();
		
	}

}
