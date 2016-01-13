package com.jordanec.restbootexample.util;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.jordanec.restbootexample.model.Team;
import com.jordanec.restbootexample.model.Country;

public class CountryJsonSerializer/* extends JsonSerializer<Country> */{
/*
	@Override
	public void serialize(Country value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeStartObject();
        gen.writeNumberField("idPais", value.getIdPais());
        gen.writeStringField("nombre", value.getNombre());
        gen.writeNumberField("puestoRankingFifa", value.getPuestoRankingFifa());
        //gen.writeStringField("confederacion", value.getConfederacion().getNombre());
        gen.writeObjectField("confederacion", value.getConfederacion());
        /*gen.writeArrayFieldStart("equipos");
        Iterator<Team> iterator = value.getEquipos().iterator();
        Team equipo;
        while (iterator.hasNext()) {
        	gen.writeStartObject();
        	equipo = iterator.next();
        	gen.writeNumberField("idEquipo", equipo.getIdEquipo());
			gen.writeStringField("nombre", equipo.getNombre());
			gen.writeEndObject();
        }
        gen.writeEndArray();
        gen.writeEndObject();
		
	}
*/
}
