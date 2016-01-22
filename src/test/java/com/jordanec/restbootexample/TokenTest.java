package com.jordanec.restbootexample;

import java.io.IOException;
import java.util.LinkedHashMap;

import com.jordanec.restbootexample.client.ServiceGenerator;
import com.jordanec.restbootexample.client.TokenApi;

import retrofit.Call;

public class TokenTest {
	private TokenApi tokenApi;
	private static TokenTest tokenTest;
	private static final String CLIENT_ID = "client";
	private static final String CLIENT_SECRET = "client-secret";
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "admin";
	private static final String SCOPE = "write";		//"read" or "write"(read+write)
	private LinkedHashMap<String, String> tokens;

	protected TokenTest() {
	}

	public static TokenTest getInstance() {
		if (tokenTest == null) {
			tokenTest = new TokenTest();
			tokenTest.createTokenApi();
		}

		return tokenTest;
	}

	public TokenApi getTokenApi() {
		return tokenTest.tokenApi;
	}

	public void setTokenApi(TokenApi tokenApi) {
		tokenTest.tokenApi = tokenApi;
	}

	private void createTokenApi() {
		setTokenApi(ServiceGenerator.createService(TokenApi.class, CLIENT_ID, CLIENT_SECRET, USERNAME, PASSWORD, SCOPE));
		Call<LinkedHashMap<String, String>> call = getTokenApi().requestToken();

		try {
			retrofit.Response<LinkedHashMap<String, String>> response = call.execute();
			if (response.isSuccess())
				setTokens(response.body());

			System.out.println("response.message() = " + response.message());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public LinkedHashMap<String, String> getTokens() {
		return tokenTest.tokens;
	}

	public void setTokens(LinkedHashMap<String, String> tokens) {
		tokenTest.tokens = tokens;
	}
}