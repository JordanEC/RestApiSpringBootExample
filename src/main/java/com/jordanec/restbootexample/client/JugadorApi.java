package com.jordanec.restbootexample.client;

import java.util.Collection;

import com.jordanec.restbootexample.model.Jugador;
import com.jordanec.restbootexample.model.Status;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.DELETE;

public interface JugadorApi {
	public static final String MAIN_PATH = "/v2/jugadores";
	public static final String CREATE = "/create"; 
	public static final String UPDATE = "/update"; 
	public static final String DELETE = "/delete";
	public static final String FIND_BY_NAME = "/nombre=";
	//public static final String C = "";
	//public static final String C = "";
	//public static final String C = "";
	
	@POST(MAIN_PATH+CREATE)
	Call<Status> createJugador(@Body Jugador jugador);
	
	@GET(MAIN_PATH+"/{idJugador}")
	Call<Jugador> readJugador(@Path("idJugador") int idJugador);
	
	@GET(MAIN_PATH+FIND_BY_NAME+"{nombre}")
	Call<Jugador> findByNombre(@Path("nombre") String nombre);
	
	@PUT(MAIN_PATH+"/{idJugador}"+UPDATE)
	Call<Status> updateJugador(@Body Jugador jugador, @Path("idJugador") int idJugador);
	
	@DELETE(MAIN_PATH+"/{idJugador}"+DELETE)
	Call<Status> deleteJugador(@Path("idJugador") int idJugador);
	
	@GET(MAIN_PATH+"/")
	Call<Collection<Jugador>> listJugadores();
	
}
