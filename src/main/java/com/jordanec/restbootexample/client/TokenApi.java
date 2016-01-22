package com.jordanec.restbootexample.client;

import java.util.LinkedHashMap;

import com.jordanec.restbootexample.util.Constants;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.POST;

public interface TokenApi {
	
	@POST(Constants.GET_TOKEN_PATH)
	Call<LinkedHashMap<String, String>> requestToken();
	
}
