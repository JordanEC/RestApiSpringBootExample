package com.jordanec.restbootexample.api;

import java.util.Collection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jordanec.restbootexample.model.*;
import com.jordanec.restbootexample.repository.*;
import com.jordanec.restbootexample.util.Constants;
import com.google.common.collect.*;

@RestController
@RequestMapping("/"+Constants.API_VERSION+"/")
public class PlayerController {

	@Autowired
	PlayerRepository playerRepository;

	static final Logger logger = Logger.getLogger(PlayerController.class);
	
	@RequestMapping(value =Constants.PLAYERS_PATH, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"Content-Type=application/json" })
	Status createPlayer(@RequestBody Player country) {
		try {
			playerRepository.save(country);
			return new Status(1, "Player added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value=Constants.PLAYERS_PATH+"/{idPlayer}", method= RequestMethod.GET)
	Player readPlayer(@PathVariable("idPlayer") int idPlayer) {
		return playerRepository.findOne(idPlayer);
	}
	
	@RequestMapping(value=Constants.PLAYERS_PATH+"/name={name}", method=RequestMethod.GET)
	Player findByName(@PathVariable("name") String name) {
		
		return playerRepository.findByName(name);
	}
		
	@RequestMapping(value=Constants.PLAYERS_PATH+"/{idPlayer}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
	"Content-Type=application/json" })
	Status updatePlayer(@RequestBody Player country, @PathVariable int idPlayer) {
		try {
			playerRepository.update(country);
			return new Status(1, "Player updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value=Constants.PLAYERS_PATH+"/{idPlayer}", method=RequestMethod.DELETE)
	Status deletePlayer(@PathVariable("idPlayer") int idPlayer) {
		try {
			playerRepository.delete(idPlayer);
			return new Status(1, "Player deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	
	@RequestMapping(value=Constants.PLAYERS_PATH, method=RequestMethod.GET)
	Collection<Player> listPlayers() {
		return Lists.newArrayList(playerRepository.findAll());
	}
	
	@RequestMapping(value=Constants.PLAYERS_PATH+"/older={age}", method=RequestMethod.GET)
	Collection<Player> getOlderThan(@PathVariable int age) {
		return playerRepository.getOlderThan(age);
	}
	
	@RequestMapping(value=Constants.PLAYERS_PATH+"/{idPlayer}/"+Constants.TEAM_PATH, method= RequestMethod.GET)
	Team readPlayerTeam(@PathVariable("idPlayer") int idPlayer) {
		return playerRepository.findOne(idPlayer).getTeam();
	}
	
	@RequestMapping(value=Constants.PLAYERS_PATH+"/{idPlayer}/"+Constants.COUNTRY_PATH, method= RequestMethod.GET)
	Country readPlayerCountry(@PathVariable("idPlayer") int idPlayer) {
		return playerRepository.findOne(idPlayer).getCountry();
	}
	
	@RequestMapping(value=Constants.PLAYERS_PATH+"/{idPlayer}/"+Constants.SPONSOR_PATH, method= RequestMethod.GET)
	Sponsor readPlayerSponsor(@PathVariable("idPlayer") int idPlayer) {
		return playerRepository.findOne(idPlayer).getSponsor();
	}
	
	
	
}
