package com.jordanec.restbootexample.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jordanec.restbootexample.model.Confederacion;
import com.jordanec.restbootexample.model.ConfederacionRepository;
import com.jordanec.restbootexample.model.Status;
import com.google.common.collect.*;

@RestController
@RequestMapping("/v1/confederacion")
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
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	Collection<Confederacion> listConfederaciones() {
		Iterator<Confederacion> iterator = confederacionRepository.findAll().iterator();
		//while(iterator.hasNext())
		//	System.out.println(iterator.next());
		//return makeCollection(iterator);
		return Lists.newArrayList(confederacionRepository.findAll());
		//return ((List<Confederacion>) Lists.newArrayList(confederacionRepository.findAll()));
		//return new Status(1, "Correct!");
			
	}
	
	private static <E> Collection<E> makeCollection(Iterator<E> iterator) {
	    Collection<E> list = new ArrayList<E>();
	    while(iterator.hasNext())
	        list.add(iterator.next());
	    
	    return list;
	}
	
	
}
