package com.jordanec.restbootexample.client;

import java.util.Collection;

import com.jordanec.restbootexample.model.*;
import com.jordanec.restbootexample.util.Constants;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.DELETE;

public interface StadiumApi {
	public static final String MAIN_PATH = "/"+Constants.API_VERSION+"/"+Constants.STADIUMS_PATH;
	
	@POST(MAIN_PATH)
	Call<Status> createStadium(@Body Stadium stadium);
	
	@GET(MAIN_PATH+"/{idStadium}")
	Call<Stadium> readStadium(@Path("idStadium") int idStadium);
	
	@GET(MAIN_PATH+"/"+Constants.NAME_VARIABLE+"={"+Constants.NAME_VARIABLE+"}")
	Call<Stadium> findByName(@Path(Constants.NAME_VARIABLE) String name);
	
	@PUT(MAIN_PATH+"/{idStadium}")
	Call<Status> updateStadium(@Body Stadium stadium, @Path("idStadium") int idStadium);
	
	@DELETE(MAIN_PATH+"/{idStadium}")
	Call<Status> deleteStadium(@Path("idStadium") int idStadium);
	
	@GET(MAIN_PATH)
	Call<Collection<Stadium>> listStadiums();
	
	@GET(MAIN_PATH+"/{idStadium}/"+Constants.TEAMS_PATH)
	Call<Collection<Team>> readStadiumTeams(@Path("idStadium") int idStadium);
	
	
}
