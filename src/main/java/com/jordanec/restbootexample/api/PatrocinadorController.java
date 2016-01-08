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

import com.jordanec.restbootexample.model.Patrocinador;
import com.jordanec.restbootexample.model.PatrocinadorRepository;
import com.jordanec.restbootexample.model.Status;
import com.google.common.collect.*;

@RestController
@RequestMapping("/v1/patrocinadores")
public class PatrocinadorController {

	@Autowired
	PatrocinadorRepository patrocinadorRepository;

	static final Logger logger = Logger.getLogger(PatrocinadorController.class);
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"Content-Type=application/json" })
	Status createPatrocinador(@RequestBody Patrocinador patrocinador) {
		try {
			patrocinadorRepository.save(patrocinador);
			return new Status(1, "Patrocinador added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	Patrocinador readPatrocinador(@PathVariable("id") int id) {
		return patrocinadorRepository.findOne(id);
	}
	
	@RequestMapping(value="/nombre={nombre}", method=RequestMethod.GET)
	Patrocinador findByNombre(@PathVariable("nombre") String nombre) {
		
		return patrocinadorRepository.findByNombre(nombre);
	}
	
	@RequestMapping(value="/{id}/update", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
	"Content-Type=application/json" })
	Status updatePatrocinador(@RequestBody Patrocinador patrocinador, @PathVariable int id) {
		try {
			patrocinadorRepository.update(patrocinador);
			return new Status(1, "Patrocinador updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
	Status deletePatrocinador(@PathVariable int id) {
		try {
			patrocinadorRepository.delete(id);
			return new Status(1, "Patrocinador deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	Collection<Patrocinador> listPatrocinadores() {
		return Lists.newArrayList(patrocinadorRepository.findAll());
	}
	
	
}
