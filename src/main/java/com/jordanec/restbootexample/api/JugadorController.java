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

import com.jordanec.restbootexample.model.Jugador;
import com.jordanec.restbootexample.model.Status;
import com.jordanec.restbootexample.repository.JugadorRepository;
import com.jordanec.restbootexample.util.Constants;
import com.google.common.collect.*;

@RestController
@RequestMapping("/"+Constants.API_VERSION+"/jugadores")
public class JugadorController {

	@Autowired
	JugadorRepository jugadorRepository;

	static final Logger logger = Logger.getLogger(JugadorController.class);
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"Content-Type=application/json" })
	Status createJugador(@RequestBody Jugador pais) {
		try {
			jugadorRepository.save(pais);
			return new Status(1, "Jugador added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	Jugador readJugador(@PathVariable("id") int id) {
		return jugadorRepository.findOne(id);
	}
	
	@RequestMapping(value="/nombre={nombre}", method=RequestMethod.GET)
	Jugador findByNombre(@PathVariable("nombre") String nombre) {
		
		return jugadorRepository.findByNombre(nombre);
	}
		
	@RequestMapping(value="/{id}/update", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
	"Content-Type=application/json" })
	Status updateJugador(@RequestBody Jugador pais, @PathVariable int id) {
		try {
			jugadorRepository.update(pais);
			return new Status(1, "Jugador updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
	Status deleteJugador(@PathVariable("id") int id) {
		try {
			jugadorRepository.delete(id);
			return new Status(1, "Jugador deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	Collection<Jugador> listJugadores() {
		return Lists.newArrayList(jugadorRepository.findAll());
	}
	
	@RequestMapping(value="/edadMayorA={edad}", method=RequestMethod.GET)
	Collection<Jugador> getOlderThan(@PathVariable int edad) {
		return jugadorRepository.getOlderThan(edad);
	}
	
	
}
