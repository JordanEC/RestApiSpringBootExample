package com.jordanec.restbootexample.util;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.jordanec.restbootexample.model.Equipo;
import com.jordanec.restbootexample.model.Pais;

public class PaisJsonSerializer extends JsonSerializer<Pais> {

	@Override
	public void serialize(Pais value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeStartObject();
        gen.writeNumberField("idPais", value.getIdPais());
        gen.writeStringField("nombre", value.getNombre());
        gen.writeNumberField("puestoRankingFifa", value.getPuestoRankingFifa());
        //gen.writeStringField("confederacion", value.getConfederacion().getNombre());
        gen.writeObjectField("confederacion", value.getConfederacion());
        /*gen.writeArrayFieldStart("equipos");
        Iterator<Equipo> iterator = value.getEquipos().iterator();
        Equipo equipo;
        while (iterator.hasNext()) {
        	gen.writeStartObject();
        	equipo = iterator.next();
        	gen.writeNumberField("idEquipo", equipo.getIdEquipo());
			gen.writeStringField("nombre", equipo.getNombre());
			gen.writeEndObject();
        }
        gen.writeEndArray();*/
        gen.writeEndObject();
		
	}

}
