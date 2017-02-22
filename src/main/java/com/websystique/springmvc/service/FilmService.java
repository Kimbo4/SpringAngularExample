package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Film;
import com.websystique.springmvc.model.Genere;

public interface FilmService {
	
    void saveFilm(Film film);
    
    List <Film> findAllFilm();
    
    List <Film> findFilm(Film film);
     
    void deleteFilm(int id);
     
    Film findById(Integer id);
     
    void updateFilm(Film film);
    
	public List<Genere> findAllGenere();

}
