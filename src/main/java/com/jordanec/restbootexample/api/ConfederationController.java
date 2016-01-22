package com.jordanec.restbootexample.api;

import java.util.Collection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class ConfederationController {

	@Autowired
	ConfederationRepository confederationRepository;

	static final Logger logger = Logger.getLogger(ConfederationController.class);
	
	@RequestMapping(value =Constants.CONFEDERATIONS_PATH/*+"/"+Constants.CREATE_FUNCTION*/, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"Content-Type=application/json" })
	 Status createConfederation(@RequestBody Confederation confederation) {
		try {
			confederationRepository.save(confederation);
			return new Status(1, "Confederation added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value=Constants.CONFEDERATIONS_PATH+"/{id}", method= RequestMethod.GET)
	Confederation readConfederation(@PathVariable("id") int id) {
		return confederationRepository.findOne(id);
	}
	
	@RequestMapping(value=Constants.CONFEDERATIONS_PATH+"/name={name}", method=RequestMethod.GET)
	Confederation findByName(@PathVariable("name") String name) {
		
		return confederationRepository.findByName(name);
	}
	
	@RequestMapping(value=Constants.CONFEDERATIONS_PATH+"/{id}"/*/"+Constants.UPDATE_FUNCTION*/, method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
	"Content-Type=application/json" })
	Status updateConfederation(@RequestBody Confederation confederation, @PathVariable int id) {
		try {
			confederationRepository.update(confederation);
			return new Status(1, "Confederation updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value=Constants.CONFEDERATIONS_PATH+"/{id}"/*/"+Constants.DELETE_FUNCTION*/, method=RequestMethod.DELETE)
	Status deleteConfederation(@PathVariable int id) {
		try {
			confederationRepository.delete(id);
			return new Status(1, "Confederation deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value=Constants.CONFEDERATIONS_PATH, method=RequestMethod.GET)
	Collection<Confederation> listConfederations() {
		return Lists.newArrayList(confederationRepository.findAll());
	}

	@RequestMapping(value=Constants.CONFEDERATIONS_PATH+"/{id}/"+Constants.COUNTRIES_PATH, method= RequestMethod.GET)
	Collection<Country> readConfederationCountries(@PathVariable("id") int id) {
		return confederationRepository.findOne(id).getCountries();
	}
	
	
}