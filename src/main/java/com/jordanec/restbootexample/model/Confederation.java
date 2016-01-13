package com.jordanec.restbootexample.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idConfederation", scope=Confederation.class)
@Entity
@Table(name = "Confederation", catalog = "FutbolDB_V3", uniqueConstraints = @UniqueConstraint(columnNames = "name") )
public class Confederation implements java.io.Serializable {
	private static final long serialVersionUID = 2854333559368929418L;
	private Integer idConfederation;
	private String name;
	private Integer totalCountries;
	private Set<Country> countries = new HashSet<Country>(0);

	public Confederation() {}

	public Confederation(Integer idConfederation, String name, Integer totalCountries, Set<Country> countries) {
		super();
		this.idConfederation = idConfederation;
		this.name = name;
		this.totalCountries = totalCountries;
		this.countries = countries;
	}

	public Confederation(String name) {
		this.name = name;
	}

	public Confederation(String name, Integer totalCountries, Set<Country> countries) {
		this.name = name;
		this.totalCountries = totalCountries;
		this.countries = countries;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idConfederation", unique = true, nullable = false)
	public Integer getIdConfederation() {
		return this.idConfederation;
	}

	public void setIdConfederation(Integer idConfederation) {
		this.idConfederation = idConfederation;
	}

	@Column(name = "name", unique = true, nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "totalCountries")
	public Integer getTotalCountries() {
		return this.totalCountries;
	}

	public void setTotalCountries(Integer totalCountries) {
		this.totalCountries = totalCountries;
	}
	
	@Override
	public String toString() {
		return " {\"idConfederation\":\"" + idConfederation + "\",\"name\":\"" + name + "\",\"totalCountries\":\""
				+ totalCountries + "\",\"countries\":\"" + countries + "\"}";
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "confederation")
	public Set<Country> getCountries() {
		return this.countries;
	}

	public void setCountries(Set<Country> countries) {
		this.countries = countries;
	}	
}
