package com.jordanec.restbootexample.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.jordanec.restbootexample.model.Player;
import com.jordanec.restbootexample.model.Sponsor;

public class SponsorRepositoryImpl implements EntityRepositoryCustom<Sponsor>{
	
	@PersistenceContext
    private EntityManager em;
	
	@Transactional
	@Override
	public boolean update(Sponsor sponsor) {
		getEm().merge(sponsor);
		return true;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Collection<Sponsor> getOlderThan(int age) {
		return null;
	}

}
