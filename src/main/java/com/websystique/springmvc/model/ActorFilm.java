package com.websystique.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="attore_film")
public class ActorFilm {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idattore_film")
	private Integer idAttoreFilm;
    @Column(name="IDATTORE")
    private Actor idAttore;
    @Column(name="IDFILM")
    private Film idFilm;

	public Integer getIdAttoreFilm() {
		return idAttoreFilm;
	}

	public void setIdAttoreFilm(Integer idAttoreFilm) {
		this.idAttoreFilm = idAttoreFilm;
	}

	public Actor getIdAttore() {
		return idAttore;
	}

	public void setIdAttore(Actor idAttore) {
		this.idAttore = idAttore;
	}

	public Film getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(Film idFilm) {
		this.idFilm = idFilm;
	}
    
    
}