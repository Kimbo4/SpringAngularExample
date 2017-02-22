package com.websystique.springmvc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genere")
public class Genere {
	
	@Id
	@GeneratedValue
	@Column(name="idgenere")
	private Integer idGenere;
	@Column(name="genere")
	private String genere;
//	@OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
//	private List<Film> films;
	
	public Integer getIdGenere() {
		return idGenere;
	}
	public void setIdGenere(Integer idGenere) {
		this.idGenere = idGenere;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
//	public List<Film> getFilms() {
//		return films;
//	}
//	public void setFilms(List<Film> films) {
//		this.films = films;
//	}
	
}
