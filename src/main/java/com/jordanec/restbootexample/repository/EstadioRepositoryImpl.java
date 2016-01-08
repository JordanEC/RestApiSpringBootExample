package com.jordanec.restbootexample.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class EstadioRepositoryImpl implements EstadioRepositoryCustom{
	
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

}
