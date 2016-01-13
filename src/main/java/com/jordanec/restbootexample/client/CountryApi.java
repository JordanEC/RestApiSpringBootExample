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

public interface CountryApi {
	public static final String MAIN_PATH = "/"+Constants.API_VERSION+"/"+Constants.COUNTRIES_PATH+"/";
	
	@POST(MAIN_PATH+Constants.CREATE_FUNCTION)
	Call<Status> createCountry(@Body Country country);
	
	@GET(MAIN_PATH+"/{idCountry}")
	Call<Country> readCountry(@Path("idCountry") int idCountry);
	
	@GET(MAIN_PATH+Constants.NAME_VARIABLE+"={name}")
	Call<Country> findByName(@Path("name") String name);
	
	@PUT(MAIN_PATH+"{idCountry}/"+Constants.UPDATE_FUNCTION)
	Call<Status> updateCountry(@Body Country country, @Path("idCountry") int idCountry);
	
	@DELETE(MAIN_PATH+"{idCountry}/"+Constants.DELETE_FUNCTION)
	Call<Status> deleteCountry(@Path("idCountry") int idCountry);
	
	@GET(MAIN_PATH)
	Call<Collection<Country>> listCountries();
	
	@GET(MAIN_PATH+"{idCountry}/"+Constants.TEAMS_PATH)
	Call<Collection<Team>> readCountryTeams(@Path("idCountry") int idCountry);
	
	@GET(MAIN_PATH+"{idCountry}/"+Constants.PLAYERS_PATH)
	Call<Collection<Player>> readCountryPlayers(@Path("idCountry") int idCountry);
	
	@GET(MAIN_PATH+"{idCountry}/"+Constants.CONFEDERATION_PATH)
	Call<Confederation> readCountryConfederation(@Path("idCountry") int idCountry);
	
	
	
}
