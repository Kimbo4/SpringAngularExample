package com.websystique.springmvc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="film")
public class Film implements java.io.Serializable {
	
	@Id
	@Column(name="id_film")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFilm;
	@Column(name = "film_name")
	private String filmName;
	@Column(name="genre")
	private String genre;
	@ManyToMany(mappedBy = "films")
	@JsonIgnore
	private Set<Actor> actor = new HashSet<Actor>(0);
	
	public Integer getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(Integer idFilm) {
		this.idFilm = idFilm;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Set<Actor> getActor() {
		return actor;
	}
	public void setActor(Set<Actor> actor) {
		this.actor = actor;
	}
	
	
}
