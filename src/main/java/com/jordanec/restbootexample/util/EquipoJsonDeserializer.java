package com.jordanec.restbootexample.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jordanec.restbootexample.model.Confederacion;
import com.jordanec.restbootexample.model.Equipo;
import com.jordanec.restbootexample.model.Estadio;
import com.jordanec.restbootexample.model.Pais;

public class EquipoJsonDeserializer extends JsonDeserializer<Equipo>{

	@Override
	public Equipo deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = p.getCodec().readTree(p);
		Equipo equipo = new Equipo();
		try {
			int idEquipo = (Integer) ((IntNode) node.get("idEquipo")).numberValue();
			equipo.setIdEquipo(idEquipo);
		}catch(NullPointerException e) {}
		
		equipo.setNombre(node.get("nombre").asText());	
		equipo.setCampeonatos((Integer) ((IntNode) node.get("campeonatos")).numberValue());
		
		
		//int puestoRankingFifa = (Integer) ((IntNode) node.get("puestoRankingFifa")).numberValue();
		/*Confederacion confederacion = new Confederacion();
		JsonNode confNode = node.get("confederacion").get(0);
		int idConfederacion = (Integer) ((IntNode) confNode.get("idConfederacion")).numberValue();
		String nombreConf = confNode.get("nombre").asText();
		int cantidadDePaises = (Integer) ((IntNode) confNode.get("cantidadDePaises")).numberValue();
		confederacion.setIdConfederacion(idConfederacion);
		confederacion.setNombre(nombreConf);
		confederacion.setCantidadDePaises(cantidadDePaises);*/
		//Confederacion confederacion =  
		ArrayNode estadiosArrayNode = (ArrayNode) node.get("estadios");
		Iterator<JsonNode> iterator = estadiosArrayNode.iterator();
		Set<Estadio> estadios = new HashSet<>();
		while(iterator.hasNext()) {
			Estadio estadio = new Estadio();
			estadio.setIdEstadio((Integer) ((IntNode)iterator.next().get("idEstadio")).numberValue());
			estadios.add(estadio);
		}
		equipo.setEstadios(estadios);
		
		
		//Estadio estadio = ((ObjectNode)((ArrayNode) node.get("estadios")).get(0)).get("idEstadio").numberValue()
		
	
		return equipo;
	}

}
