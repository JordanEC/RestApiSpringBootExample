package com.jordanec.restbootexample.util;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.jordanec.restbootexample.model.Equipo;
import com.jordanec.restbootexample.model.Pais;

public class EquipoSerializer extends JsonSerializer<Equipo> {

	@Override
	public void serialize(Equipo value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeStartObject();
		gen.writeNumberField("idEquipo", value.getIdEquipo());
		gen.writeStringField("nombre", value.getNombre());
		gen.writeNumberField("campeonatos", value.getCampeonatos());
		gen.writeStringField("pais", value.getPais().getNombre());
		try {
			System.out.println(value.getEstadios().toString());
			System.out.println(value.getPatrocinadores().toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		/*
		 * gen.writeArrayFieldStart("equipos"); Iterator<Equipo> iterator =
		 * value.getEquipos().iterator(); Equipo equipo; while
		 * (iterator.hasNext()) { gen.writeStartObject(); equipo =
		 * iterator.next(); gen.writeNumberField("idEquipo",
		 * equipo.getIdEquipo()); gen.writeStringField("nombre",
		 * equipo.getNombre()); gen.writeEndObject(); } gen.writeEndArray();
		 */
		gen.writeEndObject();

	}

}
