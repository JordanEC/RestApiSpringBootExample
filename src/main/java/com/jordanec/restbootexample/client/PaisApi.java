package com.jordanec.restbootexample.client;

import java.util.Collection;

import com.jordanec.restbootexample.model.*;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.DELETE;

public interface PaisApi {
	public static final String MAIN_PATH = "/v2/paises";
	public static final String CREATE = "/create"; 
	public static final String UPDATE = "/update"; 
	public static final String DELETE = "/delete";
	public static final String FIND_BY_NAME = "/nombre=";
	//public static final String C = "";
	//public static final String C = "";
	//public static final String C = "";
	
	@POST(MAIN_PATH+CREATE)
	Call<Status> createPais(@Body Pais pais);
	
	@GET(MAIN_PATH+"/{idPais}")
	Call<Pais> readPais(@Path("idPais") int idPais);
	
	@GET(MAIN_PATH+FIND_BY_NAME+"{nombre}")
	Call<Pais> findByNombre(@Path("nombre") String nombre);
	
	@PUT(MAIN_PATH+"/{idPais}"+UPDATE)
	Call<Status> updatePais(@Body Pais pais, @Path("idPais") int idPais);
	
	@DELETE(MAIN_PATH+"/{idPais}"+DELETE)
	Call<Status> deletePais(@Path("idPais") int idPais);
	
	@GET(MAIN_PATH+"/")
	Call<Collection<Pais>> listPaises();
	
	@GET(MAIN_PATH+"/{idPais}/equipos")
	Call<Collection<Equipo>> readPaisEquipos(@Path("idPais") int idPais);
	
	@GET(MAIN_PATH+"/{idPais}/jugadores")
	Call<Collection<Jugador>> readPaisJugadores(@Path("idPais") int idPais);
	
	@GET(MAIN_PATH+"/{idPais}/confederacion")
	Call<Confederacion> readPaisConfederacion(@Path("idPais") int idPais);
	
	
	
}
