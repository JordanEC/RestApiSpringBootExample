package com.jordanec.restbootexample.repository;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import com.jordanec.restbootexample.model.Confederation;

public class ConfederationRepositoryImpl implements EntityRepositoryCustom<Confederation>{
	
	@PersistenceContext
    private EntityManager em;
	
	@Transactional
	@Override
	public boolean update(Confederation object) {
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
	public Collection<Confederation> getOlderThan(int age) {
			System.out.println("Not supported");
		return null;
	}

}
