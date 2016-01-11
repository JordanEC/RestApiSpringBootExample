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
@RequestMapping("/"+Constants.API_VERSION+"/estadios")
public class EstadioController {

	@Autowired
	EstadioRepository estadioRepository;

	static final Logger logger = Logger.getLogger(EstadioController.class);
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"Content-Type=application/json" })
	Status createEstadio(@RequestBody Estadio estadio) {
		try {
			estadioRepository.save(estadio);
			return new Status(1, "Estadio added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	Estadio readEstadio(@PathVariable("id") int id) {
		return estadioRepository.findOne(id);
	}
	
	@RequestMapping(value="/nombre={nombre}", method=RequestMethod.GET)
	Estadio findByNombre(@PathVariable("nombre") String nombre) {
		
		return estadioRepository.findByNombre(nombre);
	}
	
	@RequestMapping(value="/{id}/update", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
	"Content-Type=application/json" })
	Status updateEstadio(@RequestBody Estadio estadio, @PathVariable int id) {
		try {
			estadioRepository.update(estadio);
			return new Status(1, "Estadio updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
	Status deleteEstadio(@PathVariable int id) {
		try {
			estadioRepository.delete(id);
			return new Status(1, "Estadio deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	Collection<Estadio> listEstadioes() {
		return Lists.newArrayList(estadioRepository.findAll());
	}
	
	
}
