package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Actor;

@Repository("actorDao")
public class ActorDaoImpl extends AbstractDao implements ActorDao {

	public void saveActor(Actor actor) {
		persist(actor);
	}

	@SuppressWarnings("unchecked")
	public List<Actor> findAllActors() {
		Criteria criteria = getSession().createCriteria(Actor.class);

		// criteria.setFetchMode("films", FetchMode.SELECT);
		// Other restrictions here as required.

		// Query query = getSession().createSQLQuery("select * from attore");
		
		
		return (List<Actor>) criteria.list();
	}
	
	public List<Actor> exist(Actor actor){
		List<Actor> results = null;
		Criteria criteria = getSession().createCriteria(Actor.class);
		criteria.add(Restrictions.eq("first_name", actor.getFirst_name()));
		criteria.add(Restrictions.eq("last_name", actor.getLast_name()));
		results = (List<Actor>) criteria.list();
		return results;
	}
	
	public void deleteActorBySsn(long ssn) {
		Query query = getSession().createSQLQuery("delete from attore where idATTORE = :ssn");
		query.setLong("ssn", ssn);
		query.executeUpdate();
	}

	public Actor findBySsn(Integer ssn) {
		Criteria criteria = getSession().createCriteria(Actor.class);
		criteria.add(Restrictions.eq("actor_id", ssn));
		criteria.setFetchMode("films", FetchMode.JOIN);
		return (Actor) criteria.uniqueResult();
	}

	public void updateActor(Actor actor) {
		getSession().saveOrUpdate(actor);
	}

	public List<Actor> findActors(Actor actor) {
		List<Actor> results = null;
		// Criteria criteria = getSession().createCriteria(Actor.class);
		Criteria criteria = getSession().createCriteria(Actor.class);

		if (actor.getFirst_name() != "") {
			criteria.add(Restrictions.like("first_name", "%" + actor.getFirst_name() + "%", MatchMode.ANYWHERE));
		}

		if (actor.getLast_name() != "") {
			criteria.add(Restrictions.like("last_name", "%" + actor.getLast_name() + "%", MatchMode.ANYWHERE));
		}

		results = (List<Actor>) criteria.list();

		return results;
	}

}
