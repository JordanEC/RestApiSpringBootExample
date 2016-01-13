package com.jordanec.restbootexample.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idStadium", scope=Stadium.class)
@Entity
@Table(name = "Stadium", catalog = "FutbolDB_V3")
public class Stadium implements java.io.Serializable {
	private static final long serialVersionUID = -4935744021736402736L;
	private Integer idStadium;
	private String name;
	private Integer capacity;
	private Set<Team> teams = new HashSet<Team>(0);

	public Stadium() {}

	public Stadium(Integer idStadium, String name, Integer capacity, Set<Team> teams) {
		super();
		this.idStadium = idStadium;
		this.name = name;
		this.capacity = capacity;
		this.teams = teams;
	}

	public Stadium(String name, Integer capacity, Set<Team> teams) {
		this.name = name;
		this.capacity = capacity;
		this.teams = teams;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idStadium", unique = true, nullable = false)
	public Integer getIdStadium() {
		return this.idStadium;
	}

	public void setIdStadium(Integer idStadium) {
		this.idStadium = idStadium;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "capacity")
	public Integer getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "stadiums")
	public Set<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	@Override
	public String toString() {
		return " {\"idStadium\":\"" + idStadium + "\",\"name\":\"" + name + "\",\"capacity\":\"" + capacity
				+ "\",\"teams\":\"" + teams + "\"}";
	}
}
