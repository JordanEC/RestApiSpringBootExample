package com.jordanec.restbootexample.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.jordanec.restbootexample.model.Player;

public class PlayerRepositoryImpl implements EntityRepositoryCustom<Player>{
	
	@PersistenceContext
    private EntityManager em;
	
	@Transactional
	@Override
	public boolean update(Player player) {
		getEm().merge(player);
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
	public Collection<Player> getOlderThan(int age) {
		return (Collection<Player>) getEm()
				.createQuery("FROM Player where age > :age")
				.setParameter("age", age)
				.getResultList();
		
	}

}
