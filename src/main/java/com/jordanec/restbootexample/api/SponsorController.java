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

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

import com.google.common.collect.*;

@RestController
@RequestMapping("/"+Constants.API_VERSION+"/")
public class SponsorController {

	@Autowired
	SponsorRepository sponsorRepository;

	static final Logger logger = Logger.getLogger(SponsorController.class);
	
	@RequestMapping(value =Constants.SPONSORS_PATH, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"Content-Type=application/json" })
	Status createSponsor(@RequestBody Sponsor sponsor) {
		try {
			sponsorRepository.save(sponsor);
			return new Status(1, "Sponsor added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value=Constants.SPONSORS_PATH+"/{idSponsor}", method= RequestMethod.GET)
	Sponsor readSponsor(@PathVariable("idSponsor") int idSponsor) {
		return sponsorRepository.findOne(idSponsor);
	}
	
	@RequestMapping(value=Constants.SPONSORS_PATH+"/name={name}", method=RequestMethod.GET)
	Sponsor findByName(@PathVariable("name") String name) {
		
		return sponsorRepository.findByName(name);
	}
	
	@RequestMapping(value=Constants.SPONSORS_PATH+"/{idSponsor}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
	"Content-Type=application/json" })
	Status updateSponsor(@RequestBody Sponsor sponsor, @PathVariable int idSponsor) {
		try {
			sponsorRepository.update(sponsor);
			return new Status(1, "Sponsor updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value=Constants.SPONSORS_PATH+"/{idSponsor}", method=RequestMethod.DELETE)
	Status deleteSponsor(@PathVariable int idSponsor) {
		try {
			sponsorRepository.delete(idSponsor);
			return new Status(1, "Sponsor deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	
	@RequestMapping(value=Constants.SPONSORS_PATH, method=RequestMethod.GET)
	Collection<Sponsor> listSponsors() {
		return Lists.newArrayList(sponsorRepository.findAll());
	}
	
	@RequestMapping(value=Constants.SPONSORS_PATH+"/{idSponsor}/"+Constants.TEAMS_PATH, method= RequestMethod.GET)
	Collection<Team> readSponsorTeams(@PathVariable("idSponsor") int idSponsor) {
		return sponsorRepository.findOne(idSponsor).getTeams();
	}
	
	@RequestMapping(value=Constants.SPONSORS_PATH+"/{idSponsor}/"+Constants.PLAYERS_PATH, method= RequestMethod.GET)
	Collection<Player> readSponsorPlayers(@PathVariable("idSponsor") int idSponsor) {
		return sponsorRepository.findOne(idSponsor).getPlayers();
	}
	
}
