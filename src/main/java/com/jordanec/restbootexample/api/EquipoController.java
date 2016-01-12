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
@RequestMapping("/"+Constants.API_VERSION+"/equipos")
public class EquipoController {

	@Autowired
	EquipoRepository equipoRepository;

	static final Logger logger = Logger.getLogger(EquipoController.class);
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"Content-Type=application/json" })
	Status createEquipo(@RequestBody Equipo equipo) {
		try {
			equipoRepository.save(equipo);
			return new Status(1, "Equipo added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	Equipo readEquipo(@PathVariable("id") int id) {
		return equipoRepository.findOne(id);
	}
	
	@RequestMapping(value="/nombre={nombre}", method=RequestMethod.GET)
	Equipo findByNombre(@PathVariable("nombre") String nombre) {
		
		return equipoRepository.findByNombre(nombre);
	}
	
	@RequestMapping(value="/{id}/update", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
	"Content-Type=application/json" })
	Status updateEquipo(@RequestBody Equipo equipo, @PathVariable int id) {
		try {
			equipoRepository.update(equipo);
			return new Status(1, "Equipo updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.DELETE)
	Status deleteEquipo(@PathVariable int id) {
		try {
			equipoRepository.delete(id);
			return new Status(1, "Equipo deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.getMessage());
		}
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	Collection<Equipo> listEquipos() {
		return Lists.newArrayList(equipoRepository.findAll());
	}
	
	@RequestMapping(value="/{id}/estadios", method= RequestMethod.GET)
	Collection<Estadio> readEquipoEstadios(@PathVariable("id") int id) {
		return equipoRepository.findOne(id).getEstadios();
	}
	
	@RequestMapping(value="/{id}/jugadores", method= RequestMethod.GET)
	Collection<Jugador> readEquipoJugadores(@PathVariable("id") int id) {
		return equipoRepository.findOne(id).getJugadores();
	}
	
	@RequestMapping(value="/{id}/pais", method= RequestMethod.GET)
	Pais readEquipoPais(@PathVariable("id") int id) {
		return equipoRepository.findOne(id).getPais();
	}
	
	@RequestMapping(value="/{id}/patrocinadores", method= RequestMethod.GET)
	Collection<Patrocinador> readEquipoPatrocinadores(@PathVariable("id") int id) {
		return equipoRepository.findOne(id).getPatrocinadores();
	}
	
	
}
