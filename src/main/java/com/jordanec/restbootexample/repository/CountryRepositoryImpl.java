package com.jordanec.restbootexample.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.jordanec.restbootexample.model.Confederation;
import com.jordanec.restbootexample.model.Player;
import com.jordanec.restbootexample.model.Country;

public class CountryRepositoryImpl implements EntityRepositoryCustom<Country>{
	
	@PersistenceContext
    private EntityManager em;
	
	@Transactional
	@Override
	public boolean update(Country country) {
		Country countryOld = getEm().find(Country.class, country.getIdCountry());
		countryOld.setName(country.getName());
		countryOld.setPositionRankingFifa(country.getPositionRankingFifa());
		getEm().merge(countryOld);
		return true;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Collection<Country> getOlderThan(int age) {
		return null;
	}

}
