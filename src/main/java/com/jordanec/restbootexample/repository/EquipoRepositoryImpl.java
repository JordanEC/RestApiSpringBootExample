package com.jordanec.restbootexample.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.jordanec.restbootexample.model.Equipo;

public class EquipoRepositoryImpl implements EntityRepositoryCustom<Equipo>{
	
	@PersistenceContext
    private EntityManager em;
	
	@Transactional
	@Override		// TODO Auto-generated method stub
	public boolean update(Equipo equipo) {
		getEm().merge(equipo);
		return true;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Collection<Equipo> getOlderThan(int edad) {
		return null;
	}

}
