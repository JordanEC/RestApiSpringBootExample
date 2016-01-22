package com.jordanec.restbootexample.repository;

import java.util.Collection;

import org.springframework.security.access.prepost.PreAuthorize;


public interface EntityRepositoryCustom<T> {
	@PreAuthorize("#oauth2.hasScope('write')")
	boolean update(T entity);
	Collection<T> getOlderThan(int age);
}
