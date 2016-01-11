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

public interface PatrocinadorApi {
	public static final String MAIN_PATH = "/v2/patrocinadores";
	public static final String CREATE = "/create"; 
	public static final String UPDATE = "/update"; 
	public static final String DELETE = "/delete";
	public static final String FIND_BY_NAME = "/nombre=";
	//public static final String C = "";
	//public static final String C = "";
	//public static final String C = "";
	
	@POST(MAIN_PATH+CREATE)
	Call<Status> createPatrocinador(@Body Patrocinador patrocinador);
	
	@GET(MAIN_PATH+"/{idPatrocinador}")
	Call<Patrocinador> readPatrocinador(@Path("idPatrocinador") int idPatrocinador);
	
	@GET(MAIN_PATH+FIND_BY_NAME+"{nombre}")
	Call<Patrocinador> findByNombre(@Path("nombre") String nombre);
	
	@PUT(MAIN_PATH+"/{idPatrocinador}"+UPDATE)
	Call<Status> updatePatrocinador(@Body Patrocinador patrocinador, @Path("idPatrocinador") int idPatrocinador);
	
	@DELETE(MAIN_PATH+"/{idPatrocinador}"+DELETE)
	Call<Status> deletePatrocinador(@Path("idPatrocinador") int idPatrocinador);
	
	@GET(MAIN_PATH+"/")
	Call<Collection<Patrocinador>> listPatrocinadores();
	
}
