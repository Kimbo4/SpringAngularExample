package com.websystique.springmvc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonUnwrapped;


@Entity
@Table(name="film")
public class Film implements java.io.Serializable {
	
	@Id
	@Column(name="idFILM")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFilm;
	@Column(name = "TITOLOFILM")
	private String filmName;
	@ManyToOne
	@JoinColumn(name="GENEREFILM")
	private Genere genre;
	
	
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
	public Genere getGenre() {
		return genre;
	}
	public void setGenre(Genere genre) {
		this.genre = genre;
	}
	
}
