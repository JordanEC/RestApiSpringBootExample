package com.jordanec.restbootexample.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idTeam", scope=Team.class)
@Entity
@Table(name = "Team", catalog = "FutbolDB_V3")

public class Team implements java.io.Serializable {
	private static final long serialVersionUID = -8766290831934018801L;
	private Integer idTeam;
	private Country country;
	private String name;
	private int championships;
	private Set<Sponsor> sponsors = new HashSet<Sponsor>(0);
	private Set<Stadium> stadiums = new HashSet<Stadium>(0);
	private Set<Player> players = new HashSet<Player>(0);

	public Team() {}

	public Team(Country country, String name, int championships) {
		this.country = country;
		this.name = name;
		this.championships = championships;
	}

	public Team(Integer idTeam, Country country, String name, int championships, Set<Sponsor> sponsors,
			Set<Stadium> stadiums, Set<Player> players) {
		super();
		this.idTeam = idTeam;
		this.country = country;
		this.name = name;
		this.championships = championships;
		this.sponsors = sponsors;
		this.stadiums = stadiums;
		this.players = players;
	}

	public Team(Country country, String name, int championships, Set<Sponsor> sponsors, Set<Stadium> stadiums,
			Set<Player> players) {
		this.country = country;
		this.name = name;
		this.championships = championships;
		this.sponsors = sponsors;
		this.stadiums = stadiums;
		this.players = players;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idTeam", unique = true, nullable = false)
	public Integer getIdTeam() {
		return this.idTeam;
	}

	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCountry", nullable = false)
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "championships", nullable = false)
	public int getChampionships() {
		return this.championships;
	}

	public void setChampionships(int championships) {
		this.championships = championships;
	}

	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Team_Sponsor", catalog = "FutbolDB_V3", joinColumns = {
			@JoinColumn(name = "idTeam", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idSponsor", nullable = false, updatable = false) })
	public Set<Sponsor> getSponsors() {
		return this.sponsors;
	}

	public void setSponsors(Set<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Team_Stadium", catalog = "FutbolDB_V3", joinColumns = {
			@JoinColumn(name = "idTeam", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idStadium", nullable = false, updatable = false) })
	public Set<Stadium> getStadiums() {
		return this.stadiums;
	}

	public void setStadiums(Set<Stadium> stadiums) {
		this.stadiums = stadiums;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
	public Set<Player> getPlayers() {
		return this.players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return " {\"idTeam\":\"" + idTeam + "\",\"country\":\"" + country + "\",\"name\":\"" + name
				+ "\",\"championships\":\"" + championships + "\",\"sponsors\":\"" + sponsors
				+ "\",\"stadiums\":\"" + stadiums + "\",\"players\":\"" + players + "\"}";
	}
}
