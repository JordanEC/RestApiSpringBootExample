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
public class CountryController {

	@Autowired
	CountryRepository countryRepository;

	static final Logger logger = Logger.getLogger(CountryController.class);
	
	@RequestMapping(value =Constants.COUNTRIES_PATH, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"Content-Type=application/json" })
	Status createCountry(@RequestBody Country country) {
		try {
			countryRepository.save(country);
			return new Status(1, "Country added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value=Constants.COUNTRIES_PATH+"/{id}", method= RequestMethod.GET)
	Country readCountry(@PathVariable("id") int id) {
		return countryRepository.findOne(id);
	}
	
	@RequestMapping(value=Constants.COUNTRIES_PATH+"/name={name}", method=RequestMethod.GET)
	Country findByName(@PathVariable("name") String name) {
		return countryRepository.findByName(name);
	}
	
	@RequestMapping(value=Constants.COUNTRIES_PATH+"/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
	"Content-Type=application/json" })
	Status updateCountry(@RequestBody Country country, @PathVariable int id) {
		try {
			countryRepository.update(country);
			return new Status(1, "Country updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value=Constants.COUNTRIES_PATH+"/{id}", method=RequestMethod.DELETE)
	Status deleteCountry(@PathVariable int id) {
		try {
			countryRepository.delete(id);
			return new Status(1, "Country deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value=Constants.COUNTRIES_PATH, method=RequestMethod.GET)
	Collection<Country> listCountries() {
		return Lists.newArrayList(countryRepository.findAll());
	}
	
	@RequestMapping(value=Constants.COUNTRIES_PATH+"/{id}/"+Constants.TEAMS_PATH, method= RequestMethod.GET)
	Collection<Team> readCountryTeams(@PathVariable("id") int id) {
		return countryRepository.findOne(id).getTeams();
	}
	
	@RequestMapping(value=Constants.COUNTRIES_PATH+"/{id}/"+Constants.PLAYERS_PATH, method= RequestMethod.GET)
	Collection<Player> readCountryPlayers(@PathVariable("id") int id) {
		return countryRepository.findOne(id).getPlayers();
	}
	
	@RequestMapping(value=Constants.COUNTRIES_PATH+"/{id}/"+Constants.CONFEDERATION_PATH, method= RequestMethod.GET)
	Confederation readCountryConfederation(@PathVariable("id") int id) {
		return countryRepository.findOne(id).getConfederation();
	}
	
	
	
}
