package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Film;

public interface FilmDao {
    void saveFilm(Film film);
    
    List <Film> findAllFilm();
    
    List <Film> findFilm(Film film);
     
    void deleteFilm(int id);
     
    Film findById(Integer id);
     
    void updateFilm(Film film);
}
