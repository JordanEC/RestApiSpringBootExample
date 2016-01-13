package com.jordanec.restbootexample.repository;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import com.jordanec.restbootexample.model.Stadium;

public class StadiumRepositoryImpl implements EntityRepositoryCustom<Stadium>{
	@PersistenceContext
    private EntityManager em;
	
	@Transactional
	@Override
	public boolean update(Stadium stadium) {
		getEm().merge(stadium);
		return true;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Collection<Stadium> getOlderThan(int age) {
		System.out.println("Not supported");
		return null;
	}

}
