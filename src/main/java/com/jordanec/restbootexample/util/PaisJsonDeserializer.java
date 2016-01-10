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
import com.jordanec.restbootexample.model.Confederacion;
import com.jordanec.restbootexample.model.Pais;

public class PaisJsonDeserializer extends JsonDeserializer<Pais>{

	@Override
	public Pais deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = p.getCodec().readTree(p);
		int idPais = (Integer) ((IntNode) node.get("idPais")).numberValue();
		String nombre = node.get("nombre").asText();		
		int puestoRankingFifa = (Integer) ((IntNode) node.get("puestoRankingFifa")).numberValue();
		
		Confederacion confederacion = new Confederacion();
		JsonNode confNode = node.get("confederacion").get(0);
		int idConfederacion = (Integer) ((IntNode) confNode.get("idConfederacion")).numberValue();
		String nombreConf = confNode.get("nombre").asText();
		int cantidadDePaises = (Integer) ((IntNode) confNode.get("cantidadDePaises")).numberValue();
		confederacion.setIdConfederacion(idConfederacion);
		confederacion.setNombre(nombreConf);
		confederacion.setCantidadDePaises(cantidadDePaises);
		
		return new Pais(idPais, confederacion, nombre, puestoRankingFifa);
	}

}
