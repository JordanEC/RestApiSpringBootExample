package com.jordanec.restbootexample.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jordanec.restbootexample.model.Confederation;
import com.jordanec.restbootexample.model.Country;

public class CountryJsonDeserializer/* extends JsonDeserializer<Country>*/{
	/*
	@Override
	public Country deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = p.getCodec().readTree(p);
		int idPais = (Integer) ((IntNode) node.get("idPais")).numberValue();
		String nombre = node.get("nombre").asText();		
		int puestoRankingFifa = (Integer) ((IntNode) node.get("puestoRankingFifa")).numberValue();
		
		Confederation confederation = new Confederation();
		JsonNode confNode = node.get("confederacion").get(0);
		int idConfederacion = (Integer) ((IntNode) confNode.get("idConfederacion")).numberValue();
		String nombreConf = confNode.get("nombre").asText();
		int cantidadDePaises = (Integer) ((IntNode) confNode.get("cantidadDePaises")).numberValue();
		confederation.setIdConfederacion(idConfederacion);
		confederation.setNombre(nombreConf);
		confederation.setCantidadDePaises(cantidadDePaises);
		
		return new Country(idPais, confederation, nombre, puestoRankingFifa);
	}*/

}
