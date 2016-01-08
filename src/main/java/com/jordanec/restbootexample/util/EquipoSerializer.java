package com.jordanec.restbootexample.util;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.jordanec.restbootexample.model.Equipo;
import com.jordanec.restbootexample.model.Estadio;
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
		gen.writeFieldName("estadios");
		gen.writeStartArray();
		Iterator<Estadio> iterator = value.getEstadios().iterator();

		while (iterator.hasNext())
			gen.writeObject(iterator.next());

		gen.writeEndArray();
		gen.writeEndObject();

	}

}
