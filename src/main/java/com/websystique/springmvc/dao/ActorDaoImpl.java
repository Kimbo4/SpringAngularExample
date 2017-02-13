package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
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
		
		return (List<Actor>) criteria.list();
	}

	public void deleteActorBySsn(long ssn) {
		Query query = getSession().createSQLQuery("delete from Actor where actor_id = :ssn");
		query.setLong("ssn", ssn);
		query.executeUpdate();
	}

	public Actor findBySsn(Integer ssn) {
		Criteria criteria = getSession().createCriteria(Actor.class);
		criteria.add(Restrictions.eq("actor_id", ssn));
		return (Actor) criteria.uniqueResult();
	}

	public void updateActor(Actor actor) {
		getSession().update(actor);
	}

	public List<Actor> findActors(Actor actor) {
		List<Actor> results = null;
		// Criteria criteria = getSession().createCriteria(Actor.class);
		Criteria criteria = getSession().createCriteria(Actor.class);
		if (actor.getFirst_name() != "") {
			criteria.add(Restrictions.like("first_name", "%"+actor.getFirst_name()+"%",MatchMode.ANYWHERE));
		}
		
		if (actor.getLast_name() != "") {
			criteria.add(Restrictions.like("last_name", "%"+actor.getLast_name()+"%",MatchMode.ANYWHERE));
		}
		results = (List<Actor>) criteria.list();
		return results;
	}

}
