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
@RequestMapping("/"+Constants.API_VERSION+"/confederaciones")
public class ConfederacionController {

	@Autowired
	ConfederacionRepository confederacionRepository;

	static final Logger logger = Logger.getLogger(ConfederacionController.class);
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"Content-Type=application/json" })
	 Status createConfederacion(@RequestBody Confederacion confederacion) {
		try {
			confederacionRepository.save(confederacion);
			return new Status(1, "Confederacion added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	Confederacion readConfederacion(@PathVariable("id") int id) {
		return confederacionRepository.findOne(id);
	}
	
	@RequestMapping(value="/nombre={nombre}", method=RequestMethod.GET)
	Confederacion findByNombre(@PathVariable("nombre") String nombre) {
		
		return confederacionRepository.findByNombre(nombre);
	}
	
	@RequestMapping(value="/{id}/update", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
	"Content-Type=application/json" })
	Status updateConfederacion(@RequestBody Confederacion confederacion, @PathVariable int id) {
		try {
			confederacionRepository.update(confederacion);
			return new Status(1, "Confederacion updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
	Status deleteConfederacion(@PathVariable int id) {
		try {
			confederacionRepository.delete(id);
			return new Status(1, "Confederacion deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	Collection<Confederacion> listConfederaciones() {
		return Lists.newArrayList(confederacionRepository.findAll());
	}
		
	@RequestMapping(value="/{id}/paises", method= RequestMethod.GET)
	Collection<Pais> readConfederacionPaises(@PathVariable("id") int id) {
		return confederacionRepository.findOne(id).getPaises();
	}
	
	
}