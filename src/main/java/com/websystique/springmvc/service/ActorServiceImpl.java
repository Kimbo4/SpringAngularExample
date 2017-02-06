package com.websystique.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.dao.ActorDao;
import com.websystique.springmvc.model.Actor;


/*
 * l'annotation @Transactional svolgerà ogni singola transazione singolarmente, e committa all'uscita di ogni metodo
 * se si verifica qualche problema durante la transazione farà un rollback riportando il messaggio di errore
 * 
 */
@Service("actorService")
@Transactional
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorDao dao;
	
	@Override
	public void saveActor(Actor actor) {
		dao.saveActor(actor);
	}

	@Override
	public List<Actor> findAllActors() {
		return dao.findAllActors();
	}

	@Override
	public void deleteActorBySsn(long ssn) {
		dao.deleteActorBySsn(ssn);
	}

	@Override
	public Actor findBySsn(Integer ssn) {
		return dao.findBySsn(ssn);
	}

	@Override
	public void updateActor(Actor actor) {
		dao.updateActor(actor);		
	}
	
	@Override
	public List <Actor> findActors(Actor actor){
		return dao.findActors(actor);
	}


}
