package com.jordanec.restbootexample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import org.springframework.test.context.web.WebAppConfiguration;
import com.jordanec.restbootexample.client.*;
import com.jordanec.restbootexample.model.*;
import com.jordanec.restbootexample.util.Constants;

import retrofit.Call;
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
		testConfederation();
		//testCountry();
		// testTeam();
		// testStadium();
		// testSponsor();
		// testPlayer();

		/*
		 * call.enqueue(new Callback<Collection<Confederation>>() {
		 * 
		 * @Override public void
		 * onResponse(retrofit.Response<Collection<Confederation>> response,
		 * Retrofit retrofit) { if(response.isSuccess()) {
		 * Collection<Confederation> confe = response.body();
		 * System.out.println(confe); } else {
		 * System.out.println("response.code()="+response.code());
		 * System.out.println("response.errorBody()="+response.errorBody()); }
		 * 
		 * }
		 * 
		 * @Override public void onFailure(Throwable t) {
		 * System.out.println(t.getMessage());
		 * 
		 * } });
		 */

	}

	private void testConfederation() {
		assertTrue(confederationTest.doAllTests());
		/*assertTrue(confederationCreateTest());
		assertNotNull(confederationReadTest(1)); // idConfederation
		assertTrue(confederationUpdateTest(7));
		assertTrue(confederationFindByNameTest("Antártida_Updated"));
		assertTrue(confederationListTest());
		assertTrue(confederationDeleteTest(7));*/
	}

	private void testCountry() {
		assertTrue(countryTest.doAllTests());
		//assertTrue(countryCreateTest());
		//assertNotNull(countryReadTest(1)); // idCountry
		// assertTrue(countryFindByNameTest());
		// assertTrue(countryUpdateTest());
		// assertTrue(countryListTest());
		// assertTrue(countryDeleteTest());
	}

	public void testTeam() {
		// assertTrue(teamCreateTest());
		assertNotNull(teamReadTest(1)); // idTeam
		// assertTrue(countryFindByNameTest());
		// assertTrue(countryUpdateTest());
		// assertTrue(teamListTest());
		// assertTrue(countryDeleteTest());
	}

	public void testStadium() {
		// assertTrue(stadiumCreateTest());
		assertNotNull(stadiumReadTest(1)); // idStadium
		// assertTrue(stadiumFindByNameTest());
		// assertTrue(stadiumUpdateTest());
		// assertTrue(stadiumListTest());
		// assertTrue(stadiumDeleteTest());
	}

	public void testSponsor() {
		// assertTrue(sponsorCreateTest());
		assertNotNull(sponsorReadTest(1)); // idConfederation
		// assertTrue(sponsorFindByNameTest());
		// assertTrue(sponsorUpdateTest());
		// assertTrue(sponsorListTest());
		// assertTrue(sponsorDeleteTest());
	}

	public void testPlayer() {
		// assertTrue(playerCreateTest());
		assertNotNull(playerReadTest(1)); // idPlayer
		// assertTrue(playerFindByNameTest());
		// assertTrue(playerUpdateTest());
		// assertTrue(playerListTest());
		// assertTrue(playerDeleteTest());
	}

	private Confederation confederationReadTest(int idConfederation) {
		Call<Confederation> call = confederationApi.readConfederation(idConfederation);

		try {
			retrofit.Response<Confederation> response = call.execute();
			if (response.isSuccess()) {
				Confederation confederation = response.body();
				System.out.println("idConfederation: " + confederation.getIdConfederation() + " name:"
						+ confederation.getName());
				return confederation;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private boolean confederationCreateTest() {
		Confederation confederation = new Confederation("Antártida_Created"); // id
																				// 7

		Call<Status> call = confederationApi.createConfederation(confederation);

		try {
			retrofit.Response<Status> response = call.execute();
			if (response.isSuccess()) {
				Status status = response.body();
				System.out.println(
						"status.getCode()=" + status.getCode() + "\nstatus.getMessage()=" + status.getMessage());
				return true;
			}
			System.out.println("response.message()=" + response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean confederationUpdateTest(int idConfederation) {
		Confederation confederation = confederationReadTest(idConfederation);
		confederation.setName("Antártida_Updated");

		Call<Status> call = confederationApi.updateConfederation(confederation, idConfederation);

		try {
			retrofit.Response<Status> response = call.execute();
			if (response.isSuccess()) {
				Status status = response.body();
				System.out.println(
						"status.getCode()=" + status.getCode() + "\nstatus.getMessage()=" + status.getMessage());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean confederationDeleteTest(int idConfederation) {
		Call<Status> call = confederationApi.deleteConfederation(7);

		try {
			retrofit.Response<Status> response = call.execute();
			if (response.isSuccess()) {
				Status status = response.body();
				System.out.println(
						"status.getCode()=" + status.getCode() + "\nstatus.getMessage()=" + status.getMessage());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean confederationListTest() {
		Call<Collection<Confederation>> call = confederationApi.listConfederations();

		try {
			retrofit.Response<Collection<Confederation>> response = call.execute();
			if (response.isSuccess()) {
				Collection<Confederation> confederations = response.body();
				Iterator<Confederation> iterator = confederations.iterator();
				Confederation confederation;
				while (iterator.hasNext()) {
					confederation = iterator.next();
					System.out.println("idConfederation" + confederation.getIdConfederation() + " name:"
							+ confederation.getName());
				}

				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean confederationFindByNameTest(String name) {
		Call<Confederation> call = confederationApi.findByName(name);

		try {
			retrofit.Response<Confederation> response = call.execute();
			if (response.isSuccess()) {
				Confederation confederation = response.body();
				System.out.println("idConfederation: " + confederation.getIdConfederation() + " name:"
						+ confederation.getName());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	
	private Country countryReadTest(int idCountry) {
		Call<Country> call = countryApi.readCountry(idCountry);

		try {
			retrofit.Response<Country> response = call.execute();
			if (response.isSuccess()) {
				Country country = response.body();
				System.out.println("idCountry:" + country.getIdCountry() + " name:" + country.getName());
				return country;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private boolean countryDeleteTest() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean countryListTest() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean countryUpdateTest() {
		Country country = countryReadTest(1);
		country.setName(country.getName() + "_Updated");
		country.setConfederation(confederationReadTest(5));

		Call<Status> call = countryApi.updateCountry(country, country.getIdCountry());

		try {
			retrofit.Response<Status> response = call.execute();
			if (response.isSuccess()) {
				Status status = response.body();
				System.out.println(
						"status.getCode()=" + status.getCode() + "\nstatus.getMessage()=" + status.getMessage());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean countryFindByNameTest() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean countryCreateTest() {
		Confederation confederation = confederationReadTest(1);
		Country country = new Country(confederation, "Panamá", 76);

		Call<Status> call = countryApi.createCountry(country);

		try {
			retrofit.Response<Status> response = call.execute();
			if (response.isSuccess()) {
				Status status = response.body();
				System.out.println(
						"status.getCode()=" + status.getCode() + "\nstatus.getMessage()=" + status.getMessage());
				return true;
			}
			System.out.println("response.message()=" + response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	private boolean teamCreateTest() {
		Country country = countryReadTest(1); // idCountry

		Stadium stadium1 = stadiumReadTest(1);
		Stadium stadium2 = stadiumReadTest(2);
		Set<Stadium> stadiums = new HashSet<>();
		stadiums.add(stadium1);
		stadiums.add(stadium2);

		Sponsor sponsor = sponsorReadTest(1);
		Set<Sponsor> sponsors = new HashSet<>();
		sponsors.add(sponsor);

		Team team = new Team(country, "Cartago", 3);

		team.setStadiums(stadiums);
		team.setSponsors(sponsors);

		Call<Status> call = teamApi.createTeam(team);

		try {
			retrofit.Response<Status> response = call.execute();
			if (response.isSuccess()) {
				Status status = response.body();
				System.out.println(
						"status.getCode()=" + status.getCode() + "\nstatus.getMessage()=" + status.getMessage());
				return true;
			}
			System.out.println("response.message()=" + response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	
	private Team teamReadTest(int idTeam) {
		Call<Team> call = teamApi.readTeam(idTeam);

		try {
			retrofit.Response<Team> response = call.execute();
			if (response.isSuccess()) {
				Team team = response.body();
				System.out.println("idTeam:" + team.getIdTeam() + " name:" + team.getName());
				return team;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private boolean teamListTest() {
		Call<Collection<Team>> call = teamApi.listTeams();

		try {
			retrofit.Response<Collection<Team>> response = call.execute();
			if (response.isSuccess()) {
				Collection<Team> teams = response.body();
				// System.out.println(teams);
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean teamUpdateTest() {
		Team team = teamReadTest(1);
		team.setName(team.getName() + "_Update");
		team.setCountry(countryReadTest(10));

		Call<Status> call = teamApi.updateTeam(team, team.getIdTeam());

		try {
			retrofit.Response<Status> response = call.execute();
			if (response.isSuccess()) {
				Status status = response.body();
				System.out.println(
						"status.getCode()=" + status.getCode() + "\nstatus.getMessage()=" + status.getMessage());
				return true;
			}
			System.out.println(response.message());
			return false;

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private Player playerReadTest(int idPlayer) {
		Call<Player> call = playerApi.readPlayer(idPlayer);
		try {
			retrofit.Response<Player> response = call.execute();
			if (response.isSuccess()) {
				Player player = response.body();
				System.out.println("idPlayer:" + player.getIdPlayer() + " name:" + player.getName());
				return player;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private Stadium stadiumReadTest(int idStadium) {
		Call<Stadium> call = stadiumApi.readStadium(idStadium);

		try {
			retrofit.Response<Stadium> response = call.execute();
			if (response.isSuccess()) {
				Stadium stadium = response.body();
				System.out.println("idStadium: " + stadium.getIdStadium() + " name:" + stadium.getName());
				return stadium;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private Sponsor sponsorReadTest(int idSponsor) {
		Call<Sponsor> call = sponsorApi.readSponsor(idSponsor);

		try {
			retrofit.Response<Sponsor> response = call.execute();
			if (response.isSuccess()) {
				Sponsor sponsor = response.body();
				System.out.println(
						"idSponsor:" + sponsor.getIdSponsor() + " name:" + sponsor.getName());
				return sponsor;
			}
			System.out.println(response.message());
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
