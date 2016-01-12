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

public interface EquipoApi {
	public static final String MAIN_PATH = "/v2/equipos";
	public static final String CREATE = "/create"; 
	public static final String UPDATE = "/update"; 
	public static final String DELETE = "/delete";
	public static final String FIND_BY_NAME = "/nombre=";
	//public static final String C = "";
	//public static final String C = "";
	//public static final String C = "";
	
	@POST(MAIN_PATH+CREATE)
	Call<Status> createEquipo(@Body Equipo equipo);
	
	@GET(MAIN_PATH+"/{idEquipo}")
	Call<Equipo> readEquipo(@Path("idEquipo") int idEquipo);
	
	@GET(MAIN_PATH+FIND_BY_NAME+"{nombre}")
	Call<Equipo> findByNombre(@Path("nombre") String nombre);
	
	@PUT(MAIN_PATH+"/{idEquipo}"+UPDATE)
	Call<Status> updateEquipo(@Body Equipo equipo, @Path("idEquipo") int idEquipo);
	
	@DELETE(MAIN_PATH+"/{idEquipo}"+DELETE)
	Call<Status> deleteEquipo(@Path("idEquipo") int idEquipo);
	
	@GET(MAIN_PATH+"/")
	Call<Collection<Equipo>> listEquipos();
	
	@GET(MAIN_PATH+"/{idEquipo}/estadios")
	Call<Collection<Estadio>> readEquipoEstadios(@Path("idEquipo") int idEquipo);
	
	@GET(MAIN_PATH+"/{idEquipo}/jugadores")
	Call<Collection<Jugador>> readEquipoJugadores(@Path("idEquipo") int idEquipo);
	
	@GET(MAIN_PATH+"/{idEquipo}/pais")
	Call<Pais> readEquipoPais(@Path("idEquipo") int idEquipo);
	
	@GET(MAIN_PATH+"/{idEquipo}/confederaciones")
	Call<Collection<Confederacion>> readEquipoConfederaciones(@Path("idEquipo") int idEquipo);
	
	
}
