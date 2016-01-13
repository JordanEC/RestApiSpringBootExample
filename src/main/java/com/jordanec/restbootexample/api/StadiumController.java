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
public class StadiumController {

	@Autowired
	StadiumRepository stadiumRepository;

	static final Logger logger = Logger.getLogger(StadiumController.class);
	
	@RequestMapping(value =Constants.STADIUMS_PATH+"/"+Constants.CREATE_FUNCTION, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"Content-Type=application/json" })
	Status createStadium(@RequestBody Stadium stadium) {
		try {
			stadiumRepository.save(stadium);
			return new Status(1, "Stadium added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value=Constants.STADIUMS_PATH+"/{id}", method= RequestMethod.GET)
	Stadium readStadium(@PathVariable("id") int id) {
		return stadiumRepository.findOne(id);
	}
	
	@RequestMapping(value=Constants.STADIUMS_PATH+"/name={name}", method=RequestMethod.GET)
	Stadium findByName(@PathVariable("name") String name) {
		
		return stadiumRepository.findByName(name);
	}
	
	@RequestMapping(value=Constants.STADIUMS_PATH+"/{id}/"+Constants.UPDATE_FUNCTION, method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
	"Content-Type=application/json" })
	Status updateStadium(@RequestBody Stadium stadium, @PathVariable int id) {
		try {
			stadiumRepository.update(stadium);
			return new Status(1, "Stadium updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value=Constants.STADIUMS_PATH+"/{id}/"+Constants.DELETE_FUNCTION, method=RequestMethod.DELETE)
	Status deleteStadium(@PathVariable int id) {
		try {
			stadiumRepository.delete(id);
			return new Status(1, "Stadium deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	
	@RequestMapping(value=Constants.STADIUMS_PATH, method=RequestMethod.GET)
	Collection<Stadium> listStadiums() {
		return Lists.newArrayList(stadiumRepository.findAll());
	}
	
	@RequestMapping(value=Constants.STADIUMS_PATH+"/{id}/"+Constants.TEAMS_PATH, method= RequestMethod.GET)
	Collection<Team> readStadiumTeams(@PathVariable("id") int id) {
		return stadiumRepository.findOne(id).getTeams();
	}
	
	
}
