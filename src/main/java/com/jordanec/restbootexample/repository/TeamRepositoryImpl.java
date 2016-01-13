package com.jordanec.restbootexample.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.jordanec.restbootexample.model.Team;

public class TeamRepositoryImpl implements EntityRepositoryCustom<Team>{
	
	@PersistenceContext
    private EntityManager em;
	
	@Transactional
	@Override		// TODO Auto-generated method stub
	public boolean update(Team team) {
		getEm().merge(team);
		return true;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Collection<Team> getOlderThan(int age) {
		return null;
	}

}
