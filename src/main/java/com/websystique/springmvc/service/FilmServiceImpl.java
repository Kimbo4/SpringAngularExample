package com.websystique.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.dao.FilmDao;
import com.websystique.springmvc.model.Film;
import com.websystique.springmvc.model.Genere;


@Service("filmService")
@Transactional
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmDao filmDao;
	
	@Override
	public void saveFilm(Film film) {
		filmDao.saveFilm(film);
	}

	@Override
	public List<Film> findAllFilm() {
		
		return filmDao.findAllFilm();
	}

	@Override
	public List<Film> findFilm(Film film) {
		return filmDao.findFilm(film);
	}

	@Override
	public void deleteFilm(int id) {
		filmDao.deleteFilm(id);
	}

	@Override
	public Film findById(Integer id) {
		return filmDao.findById(id);
	}

	@Override
	public void updateFilm(Film film) {
		filmDao.updateFilm(film);
	}

	@Override
	public List<Genere> findAllGenere() {
		return filmDao.findAllGenere();
	}

}
