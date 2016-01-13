package com.jordanec.restbootexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;
import org.springframework.test.context.web.WebAppConfiguration;
import com.jordanec.restbootexample.client.*;
import com.jordanec.restbootexample.util.Constants;
import retrofit.Retrofit;
import retrofit.JacksonConverterFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestbootexampleApplication.class)
@WebAppConfiguration
public class RestbootexampleApplicationTests {
	ConfederationApi confederationApi;
	ConfederationTest confederationTest;
	CountryTest countryTest;
	CountryApi countryApi;
	TeamApi teamApi;
	PlayerApi playerApi;
	StadiumApi stadiumApi;
	SponsorApi sponsorApi;
	Retrofit retrofit;

	@Before
	public void setUp() {
		retrofit = new Retrofit.Builder().baseUrl(Constants.HOSTNAME)
				.addConverterFactory(JacksonConverterFactory.create()).build();
		
		confederationApi = retrofit.create(ConfederationApi.class);
		confederationTest = ConfederationTest.getInstance(confederationApi);
		
		countryApi = retrofit.create(CountryApi.class);
		countryTest = CountryTest.getInstance(countryApi);
		
		teamApi = retrofit.create(TeamApi.class);
		
		
		playerApi = retrofit.create(PlayerApi.class);
		
		
		stadiumApi = retrofit.create(StadiumApi.class);
		
		
		sponsorApi = retrofit.create(SponsorApi.class);
		
	}

	@Test
	public void contextLoads() {
		assertTrue(confederationTest.doAllTests());
		assertTrue(countryTest.doAllTests());
	}

}
