package com.jordanec.restbootexample.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class ConfederacionRepositoryImpl implements ConfederacionRepositoryCustom{
	
	@PersistenceContext
    private EntityManager em;
	
	@Transactional
	@Override
	public boolean update(Object object) {
		//em.getTransaction().begin();
		getEm().merge(object);
		//em.getTransaction().commit();
		//em.createQuery("UPDATE Confederacion set ");
		return true;
		
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
