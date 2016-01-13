package com.jordanec.restbootexample.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.jordanec.restbootexample.model.Team;
import com.jordanec.restbootexample.model.Stadium;
import com.jordanec.restbootexample.model.Player;
import com.jordanec.restbootexample.model.Country;
import com.jordanec.restbootexample.model.Sponsor;

public class TeamJsonSerializer/* extends JsonSerializer<Team>*/ {
/*
	@Override
	public void serialize(Team value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeStartObject();
		gen.writeNumberField("idEquipo", value.getIdEquipo());
		gen.writeStringField("nombre", value.getNombre());
		gen.writeNumberField("campeonatos", value.getCampeonatos());
		gen.writeStringField("pais", value.getPais().getNombre());
		// estadios	//
		gen.writeFieldName("estadios");
		gen.writeStartArray();
		Iterator<Stadium> estadiosIterator = value.getEstadios().iterator();
		while (estadiosIterator.hasNext())
			gen.writeObject(estadiosIterator.next());
		gen.writeEndArray();
		// patrocinadores //
		gen.writeFieldName("patrocinadores");
		gen.writeStartArray();
		Iterator<Sponsor> patrocinadoresIterator = value.getPatrocinadores().iterator();
		while (patrocinadoresIterator.hasNext())
			gen.writeObject(patrocinadoresIterator.next());
		gen.writeEndArray();
		// jugadores //
		gen.writeFieldName("jugadores");
		
		gen.writeStartArray();
		Iterator<Player> jugadorIterator =	value.getJugadores().iterator();
		/*List<Integer> jugadoresIds = new ArrayList<>();
		while (jugadorIterator.hasNext())
			jugadoresIds.add(jugadorIterator.next().getIdJugador());
		gen.writeObject(jugadoresIds);
		while (jugadorIterator.hasNext())
			gen.writeNumber(jugadorIterator.next().getIdJugador());
		gen.writeEndArray();
		
		gen.writeEndObject();
	}
*/
}
