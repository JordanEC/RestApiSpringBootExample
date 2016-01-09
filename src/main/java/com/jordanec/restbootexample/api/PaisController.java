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

import com.jordanec.restbootexample.model.Pais;
import com.jordanec.restbootexample.repository.PaisRepository;
import com.jordanec.restbootexample.util.Constants;
import com.jordanec.restbootexample.util.Status;
import com.google.common.collect.*;

@RestController
@RequestMapping("/"+Constants.API_VERSION+"/paises")
public class PaisController {

	@Autowired
	PaisRepository paisRepository;

	static final Logger logger = Logger.getLogger(PaisController.class);
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"Content-Type=application/json" })
	Status createPais(@RequestBody Pais pais) {
		try {
			paisRepository.save(pais);
			return new Status(1, "Pais added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	Pais readPais(@PathVariable("id") int id) {
		return paisRepository.findOne(id);
	}
	
	@RequestMapping(value="/nombre={nombre}", method=RequestMethod.GET)
	Pais findByNombre(@PathVariable("nombre") String nombre) {
		
		return paisRepository.findByNombre(nombre);
	}
	
	@RequestMapping(value="/{id}/update", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
	"Content-Type=application/json" })
	Status updatePais(@RequestBody Pais pais, @PathVariable int id) {
		try {
			paisRepository.update(pais);
			return new Status(1, "Pais updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
	Status deletePais(@PathVariable int id) {
		try {
			paisRepository.delete(id);
			return new Status(1, "Pais deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	Collection<Pais> listPaises() {
		return Lists.newArrayList(paisRepository.findAll());
	}
	
	
}
