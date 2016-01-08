package com.jordanec.restbootexample.repository;

import java.util.Collection;

import com.jordanec.restbootexample.model.Jugador;

public interface JugadorRepositoryCustom {
	public boolean update(Object object);
	public Collection<Jugador> getOlderThan(int edad);
}
