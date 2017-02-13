package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Actor;
import com.websystique.springmvc.model.Film;

@Repository("filmDao")
public class FilmDaoImpl extends AbstractDao implements FilmDao {

	@Override
	public void saveFilm(Film film) {
		persist(film);
	}

	@Override
	public List<Film> findAllFilm() {
		Criteria criteria = getSession().createCriteria(Film.class);
		return criteria.list();
	}

	@Override
	public List<Film> findFilm(Film film) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFilm(int id) {
		Query query = getSession().createSQLQuery("delete from Film where if_film = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@Override
	public Film findById(Integer id) {
		Criteria criteria = getSession().createCriteria(Film.class);
		criteria.add(Restrictions.eq("id_film", id));
		return (Film) criteria.uniqueResult();	
	}

	@Override
	public void updateFilm(Film film) {
		getSession().update(film);	
	}



}
