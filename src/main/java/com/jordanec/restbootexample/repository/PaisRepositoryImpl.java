package com.jordanec.restbootexample.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.jordanec.restbootexample.model.Confederacion;
import com.jordanec.restbootexample.model.Jugador;
import com.jordanec.restbootexample.model.Pais;

public class PaisRepositoryImpl implements EntityRepositoryCustom<Pais>{
	
	@PersistenceContext
    private EntityManager em;
	
	@Transactional
	@Override
	public boolean update(Pais pais) {
		Pais paisOld = getEm().find(Pais.class, pais.getIdPais());
		paisOld.setNombre(pais.getNombre());
		paisOld.setPuestoRankingFifa(pais.getPuestoRankingFifa());
		getEm().merge(paisOld);
		return true;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Collection<Pais> getOlderThan(int edad) {
		return null;
	}

}
