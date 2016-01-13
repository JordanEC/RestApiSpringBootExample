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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idCountry", scope=Country.class)
@Entity
@Table(name = "Country", catalog = "FutbolDB_V3", uniqueConstraints = { @UniqueConstraint(columnNames = "name"),
		@UniqueConstraint(columnNames = "positionRankingFifa") })
public class Country implements java.io.Serializable {
	private static final long serialVersionUID = 5025413079710980593L;
	private Integer idCountry;
	private Confederation confederation;
	private String name;
	private int positionRankingFifa;
	private Set<Team> teams = new HashSet<Team>(0);
	private Set<Player> players = new HashSet<Player>(0);

	public Country() {}

	public Country(Confederation confederation, String name, int positionRankingFifa) {
		this.confederation = confederation;
		this.name = name;
		this.positionRankingFifa = positionRankingFifa;
	}
	
	public Country(Integer idCountry, Confederation confederation, String name, int positionRankingFifa, Set<Team> teams,
			Set<Player> players) {
		super();
		this.idCountry = idCountry;
		this.confederation = confederation;
		this.name = name;
		this.positionRankingFifa = positionRankingFifa;
		this.teams = teams;
		this.players = players;
	}

	public Country(int idCountry, Confederation confederation, String name, int positionRankingFifa) {
		this.idCountry = idCountry;
		this.confederation = confederation;
		this.name = name;
		this.positionRankingFifa = positionRankingFifa;
	}

	public Country(Confederation confederation, String name, int positionRankingFifa, Set<Team> teams,
			Set<Player> players) {
		this.confederation = confederation;
		this.name = name;
		this.positionRankingFifa = positionRankingFifa;
		this.teams = teams;
		this.players = players;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idCountry", unique = true, nullable = false)
	public Integer getIdCountry() {
		return this.idCountry;
	}

	public void setIdCountry(Integer idCountry) {
		this.idCountry = idCountry;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idConfederation", nullable = false)
	public Confederation getConfederation() {
		return this.confederation;
	}

	public void setConfederation(Confederation confederation) {
		this.confederation = confederation;
	}

	@Column(name = "name", unique = true, nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "positionRankingFifa", unique = true, nullable = false)
	public int getPositionRankingFifa() {
		return this.positionRankingFifa;
	}

	public void setPositionRankingFifa(int positionRankingFifa) {
		this.positionRankingFifa = positionRankingFifa;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<Player> getPlayers() {
		return this.players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return " {\"idCountry\":\"" + idCountry + "\",\"confederation\":\"" + confederation + "\",\"name\":\"" + name
				+ "\",\"positionRankingFifa\":\"" + positionRankingFifa + "\",\"teams\":\"" + teams
				+ "\",\"players\":\"" + players + "\"}";
	}
}