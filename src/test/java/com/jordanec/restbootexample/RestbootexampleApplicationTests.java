package com.jordanec.restbootexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;

import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestbootexampleApplication.class)
@WebAppConfiguration
public class RestbootexampleApplicationTests {
	ConfederationTest confederationTest;
	CountryTest countryTest;
	/*
	TeamTest teamTest;
	PlayerTest playerTest;
	StadiumTest stadiumTest;
	SponsorTest sponsorTest;
	*/
	TokenTest tokenTest;

	@Before
	public void setUp() {
		tokenTest  = TokenTest.getInstance();
		confederationTest = ConfederationTest.getInstance(tokenTest.getTokens());
		countryTest = CountryTest.getInstance(tokenTest.getTokens());
		/*
		teamTest = TeamTest.getInstance(tokenTest.getTokens());
		playerTest = PlayerTest.getInstance(tokenTest.getTokens());
		stadiumTest = StadiumTest.getInstance(tokenTest.getTokens());
		sponsorTest = SponsorTest.getInstance(tokenTest.getTokens());
		*/
	}

	@Test
	public void contextLoads() {
		assertTrue(confederationTest.doAllTests());
		assertTrue(countryTest.doAllTests());
		/*
		assertTrue(teamTest.doAllTests());
		assertTrue(playerTest.doAllTests());
		assertTrue(stadiumTest.doAllTests());
		assertTrue(sponsorTest.doAllTests());
		*/
	}

}
