package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Actor;

public interface ActorService {
    void saveActor(Actor actor);
    
    List <Actor> findAllActors();
    
    List <Actor> findActors(Actor actor);
     
    void deleteActorBySsn(long id);
     
    Actor findBySsn(Integer ssn);
     
    void updateActor(Actor actor);
    
	public List<Actor> exist(Actor actor);
}
