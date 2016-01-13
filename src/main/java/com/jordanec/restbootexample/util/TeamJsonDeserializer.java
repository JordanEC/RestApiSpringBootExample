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
import com.jordanec.restbootexample.model.Confederation;
import com.jordanec.restbootexample.model.Team;
import com.jordanec.restbootexample.model.Stadium;
import com.jordanec.restbootexample.model.Country;

public class TeamJsonDeserializer/* extends JsonDeserializer<Team>*/{
/*
	@Override
	public Team deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = p.getCodec().readTree(p);
		Team team = new Team();
		try {
			int idEquipo = (Integer) ((IntNode) node.get("idEquipo")).numberValue();
			team.setIdEquipo(idEquipo);
		}catch(NullPointerException e) {}
		
		team.setNombre(node.get("nombre").asText());	
		team.setCampeonatos((Integer) ((IntNode) node.get("campeonatos")).numberValue());
		
		
		//int puestoRankingFifa = (Integer) ((IntNode) node.get("puestoRankingFifa")).numberValue();
		/*Confederation confederacion = new Confederation();
		JsonNode confNode = node.get("confederacion").get(0);
		int idConfederacion = (Integer) ((IntNode) confNode.get("idConfederacion")).numberValue();
		String nombreConf = confNode.get("nombre").asText();
		int cantidadDePaises = (Integer) ((IntNode) confNode.get("cantidadDePaises")).numberValue();
		confederacion.setIdConfederacion(idConfederacion);
		confederacion.setNombre(nombreConf);
		confederacion.setCantidadDePaises(cantidadDePaises);
		//Confederation confederacion =  
		ArrayNode estadiosArrayNode = (ArrayNode) node.get("estadios");
		Iterator<JsonNode> iterator = estadiosArrayNode.iterator();
		Set<Stadium> stadiums = new HashSet<>();
		while(iterator.hasNext()) {
			Stadium stadium = new Stadium();
			stadium.setIdEstadio((Integer) ((IntNode)iterator.next().get("idEstadio")).numberValue());
			stadiums.add(stadium);
		}
		team.setEstadios(stadiums);
		
		
		//Stadium estadio = ((ObjectNode)((ArrayNode) node.get("estadios")).get(0)).get("idEstadio").numberValue()
		
	
		return team;
	}
*/
}
