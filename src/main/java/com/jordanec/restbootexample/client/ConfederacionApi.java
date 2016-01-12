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

public interface ConfederacionApi {
	public static final String MAIN_PATH = "/v2/confederaciones";
	public static final String CREATE = "/create"; 
	public static final String UPDATE = "/update"; 
	public static final String DELETE = "/delete";
	public static final String FIND_BY_NAME = "/nombre=";
	//public static final String C = "";
	//public static final String C = "";
	//public static final String C = "";
	
	@POST(MAIN_PATH+CREATE)
	Call<Status> createConfederacion(@Body Confederacion confederacion);
	
	@GET(MAIN_PATH+"/{idConfederacion}")
	Call<Confederacion> readConfederacion(@Path("idConfederacion") int idConfederacion);
	
	@GET(MAIN_PATH+FIND_BY_NAME+"{nombre}")
	Call<Confederacion> findByNombre(@Path("nombre") String nombre);
	
	@PUT(MAIN_PATH+"/{idConfederacion}"+UPDATE)
	Call<Status> updateConfederacion(@Body Confederacion confederacion, @Path("idConfederacion") int idConfederacion);
	
	@DELETE(MAIN_PATH+"/{idConfederacion}"+DELETE)
	Call<Status> deleteConfederacion(@Path("idConfederacion") int idConfederacion);
	
	@GET(MAIN_PATH+"/")
	Call<Collection<Confederacion>> listConfederaciones();
	
	@GET(MAIN_PATH+"/{idConfederacion}/paises")
	Call<Collection<Pais>> readConfederacionPaises(@Path("idConfederacion") int idConfederacion);
	
}
