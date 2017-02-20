package com.websystique.springmvc.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "attore")
public class Actor implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idATTORE")
	private Integer actor_id;
	@Column(name = "NOMEATTORE", nullable = false)
	private String first_name;
	@Column(name = "COGNOMEATTORE", nullable = false)
	private String last_name;
	@Column(name = "LASTUPDATE", nullable = true)
	private Timestamp last_update;
	
	@Transient 
	private List<Film> film;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "attore_film", joinColumns = @JoinColumn(name = "idATTORE"), inverseJoinColumns = @JoinColumn(name = "idFILM"))
	@JsonIgnore
	private Set<Film> films = new HashSet<Film>(0);

	public Integer getActor_id() {
		return actor_id;
	}

	public void setActor_id(Integer actor_id) {
		this.actor_id = actor_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}

	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	public List<Film> getFilm() {
		return film;
	}

	public void setFilm(List<Film> film) {
		this.film = film;
	}

}
