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
	
	@RequestMapping(value="/{idJugador}", method= RequestMethod.GET)
	Jugador readJugador(@PathVariable("idJugador") int idJugador) {
		return jugadorRepository.findOne(idJugador);
	}
	
	@RequestMapping(value="/nombre={nombre}", method=RequestMethod.GET)
	Jugador findByNombre(@PathVariable("nombre") String nombre) {
		
		return jugadorRepository.findByNombre(nombre);
	}
		
	@RequestMapping(value="/{idJugador}/update", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
	"Content-Type=application/json" })
	Status updateJugador(@RequestBody Jugador pais, @PathVariable int idJugador) {
		try {
			jugadorRepository.update(pais);
			return new Status(1, "Jugador updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/{idJugador}/delete", method=RequestMethod.DELETE)
	Status deleteJugador(@PathVariable("idJugador") int idJugador) {
		try {
			jugadorRepository.delete(idJugador);
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
	
	@RequestMapping(value="/{idJugador}/equipo", method= RequestMethod.GET)
	Equipo readJugadorEquipo(@PathVariable("idJugador") int idJugador) {
		return jugadorRepository.findOne(idJugador).getEquipo();
	}
	
	@RequestMapping(value="/{idJugador}/pais", method= RequestMethod.GET)
	Pais readJugadorPais(@PathVariable("idJugador") int idJugador) {
		return jugadorRepository.findOne(idJugador).getPais();
	}
	
	@RequestMapping(value="/{idJugador}/patrocinador", method= RequestMethod.GET)
	Patrocinador readJugadorPatrocinador(@PathVariable("idJugador") int idJugador) {
		return jugadorRepository.findOne(idJugador).getPatrocinador();
	}
	
	
	
}
