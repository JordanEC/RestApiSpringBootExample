package com.jordanec.restbootexample.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.jordanec.restbootexample.model.Jugador;

public class JugadorRepositoryImpl implements EntityRepositoryCustom<Jugador>{
	
	@PersistenceContext
    private EntityManager em;
	
	@Transactional
	@Override
	public boolean update(Jugador jugador) {
		getEm().merge(jugador);
		return true;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Jugador> getOlderThan(int edad) {
		return (Collection<Jugador>) getEm()
				.createQuery("FROM Jugador where edad > :edad")
				.setParameter("edad", edad)
				.getResultList();
		
	}

}
