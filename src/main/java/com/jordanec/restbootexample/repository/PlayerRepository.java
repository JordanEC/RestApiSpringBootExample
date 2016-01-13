package com.jordanec.restbootexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordanec.restbootexample.model.*;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer>, EntityRepositoryCustom<Player>{
	public Player findByName(String name);
}