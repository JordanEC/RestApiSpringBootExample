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

public interface EstadioApi {
	public static final String MAIN_PATH = "/v2/estadios";
	public static final String CREATE = "/create"; 
	public static final String UPDATE = "/update"; 
	public static final String DELETE = "/delete";
	public static final String FIND_BY_NAME = "/nombre=";
	//public static final String C = "";
	//public static final String C = "";
	//public static final String C = "";
	
	@POST(MAIN_PATH+CREATE)
	Call<Status> createEstadio(@Body Estadio estadio);
	
	@GET(MAIN_PATH+"/{idEstadio}")
	Call<Estadio> readEstadio(@Path("idEstadio") int idEstadio);
	
	@GET(MAIN_PATH+FIND_BY_NAME+"{nombre}")
	Call<Estadio> findByNombre(@Path("nombre") String nombre);
	
	@PUT(MAIN_PATH+"/{idEstadio}"+UPDATE)
	Call<Status> updateEstadio(@Body Estadio estadio, @Path("idEstadio") int idEstadio);
	
	@DELETE(MAIN_PATH+"/{idEstadio}"+DELETE)
	Call<Status> deleteEstadio(@Path("idEstadio") int idEstadio);
	
	@GET(MAIN_PATH+"/")
	Call<Collection<Estadio>> listEstadios();
	
}
