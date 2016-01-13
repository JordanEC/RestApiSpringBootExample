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

public interface PlayerApi {
	public static final String MAIN_PATH = "/"+Constants.API_VERSION+"/"+Constants.PLAYERS_PATH+"/";
	
	@POST(MAIN_PATH+Constants.CREATE_FUNCTION)
	Call<Status> createPlayer(@Body Player player);
	
	@GET(MAIN_PATH+"{idPlayer}")
	Call<Player> readPlayer(@Path("idPlayer") int idPlayer);
	
	@GET(MAIN_PATH+Constants.NAME_VARIABLE+"={"+Constants.NAME_VARIABLE+"}")
	Call<Player> findByName(@Path(Constants.NAME_VARIABLE) String name);
	
	@PUT(MAIN_PATH+"{idPlayer}/"+Constants.UPDATE_FUNCTION)
	Call<Status> updatePlayer(@Body Player player, @Path("idPlayer") int idPlayer);
	
	@DELETE(MAIN_PATH+"{idPlayer}/"+Constants.DELETE_FUNCTION)
	Call<Status> deletePlayer(@Path("idPlayer") int idPlayer);
	
	@GET(MAIN_PATH)
	Call<Collection<Player>> listPlayers();
	
	@GET(MAIN_PATH+"{idPlayer}/"+Constants.PLAYER_PATH)
	Call<Team> readPlayerTeam(@Path("idPlayer") int idPlayer);
	
	@GET(MAIN_PATH+"{idPlayer}/"+Constants.COUNTRY_PATH)
	Call<Country> readPlayerCountry(@Path("idPlayer") int idPlayer);
	
	@GET(MAIN_PATH+"{idPlayer}/"+Constants.SPONSOR_PATH)
	Call<Sponsor> readPlayerSponsor(@Path("idPlayer") int idPlayer);
	
	
	
	
}
