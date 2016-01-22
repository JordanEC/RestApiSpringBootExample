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
public class TeamController {

	@Autowired
	TeamRepository teamRepository;

	static final Logger logger = Logger.getLogger(TeamController.class);
	
	@RequestMapping(value = Constants.TEAMS_PATH, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"Content-Type=application/json" })
	Status createTeam(@RequestBody Team team) {
		try {
			teamRepository.save(team);
			return new Status(1, "Team added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value=Constants.TEAMS_PATH+"/{id}", method= RequestMethod.GET)
	Team readTeam(@PathVariable("id") int id) {
		return teamRepository.findOne(id);
	}
	
	@RequestMapping(value=Constants.TEAMS_PATH+"/name={name}", method=RequestMethod.GET)
	Team findByName(@PathVariable("name") String name) {
		
		return teamRepository.findByName(name);
	}
	
	@RequestMapping(value=Constants.TEAMS_PATH+"/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
	"Content-Type=application/json" })
	Status updateTeam(@RequestBody Team team, @PathVariable int id) {
		try {
			teamRepository.update(team);
			return new Status(1, "Team updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value=Constants.TEAMS_PATH+"/{id}", method=RequestMethod.DELETE)
	Status deleteTeam(@PathVariable int id) {
		try {
			teamRepository.delete(id);
			return new Status(1, "Team deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value=Constants.TEAMS_PATH, method=RequestMethod.GET)
	Collection<Team> listTeams() {
		return Lists.newArrayList(teamRepository.findAll());
	}
	
	@RequestMapping(value=Constants.TEAMS_PATH+"/{id}/"+Constants.STADIUMS_PATH, method= RequestMethod.GET)
	Collection<Stadium> readTeamStadiums(@PathVariable("id") int id) {
		return teamRepository.findOne(id).getStadiums();
	}
	
	@RequestMapping(value=Constants.TEAMS_PATH+"/{id}/"+Constants.PLAYERS_PATH, method= RequestMethod.GET)
	Collection<Player> readTeamPlayers(@PathVariable("id") int id) {
		return teamRepository.findOne(id).getPlayers();
	}
	
	@RequestMapping(value=Constants.TEAMS_PATH+"/{id}/"+Constants.COUNTRY_PATH, method= RequestMethod.GET)
	Country readTeamCountry(@PathVariable("id") int id) {
		return teamRepository.findOne(id).getCountry();
	}
	
	@RequestMapping(value=Constants.TEAMS_PATH+"/{id}/"+Constants.SPONSORS_PATH, method= RequestMethod.GET)
	Collection<Sponsor> readTeamSponsors(@PathVariable("id") int id) {
		return teamRepository.findOne(id).getSponsors();
	}
	
	
}
