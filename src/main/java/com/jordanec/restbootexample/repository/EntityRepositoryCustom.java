package com.jordanec.restbootexample.repository;

import java.util.Collection;

import com.jordanec.restbootexample.model.Player;

public interface EntityRepositoryCustom<T> {
	public boolean update(T entity);
	public Collection<T> getOlderThan(int age);
}
