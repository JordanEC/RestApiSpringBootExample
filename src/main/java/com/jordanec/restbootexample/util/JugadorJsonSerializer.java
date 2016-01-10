package com.jordanec.restbootexample.util;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.jordanec.restbootexample.model.Equipo;
import com.jordanec.restbootexample.model.Jugador;
import com.jordanec.restbootexample.model.Pais;

public class JugadorJsonSerializer extends JsonSerializer<Jugador> {

	@Override
	public void serialize(Jugador value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeStartObject();
        gen.writeNumberField("idJugador", value.getIdJugador());
        gen.writeStringField("nombre", value.getNombre());
        gen.writeStringField("apellido1", value.getApellido1());
        gen.writeStringField("apellido2", value.getApellido2());
        gen.writeNumberField("cedula", value.getCedula());
        gen.writeNumberField("edad", value.getEdad());
        gen.writeStringField("fechaNacimiento", value.getFechaNacimiento().toString());
        gen.writeStringField("posicion", value.getPosicion());
        gen.writeNumberField("salario", value.getSalario());
        gen.writeNumberField("anhosContratoRestante", value.getAnhosContratoRestante());
        gen.writeStringField("pais", value.getPais().getNombre());
        gen.writeStringField("patrocinador", value.getPatrocinador().getNombre());
        gen.writeStringField("equipo", value.getEquipo().getNombre());
        
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
