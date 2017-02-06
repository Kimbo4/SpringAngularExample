package com.websystique.springmvc.dao;


import java.util.List;

import com.websystique.springmvc.model.Actor;
 
public interface ActorDao {
 
    void saveActor(Actor actor);
     
    List<Actor> findAllActors();
     
    void deleteActorBySsn(long ssn);
     
    Actor findBySsn(Integer ssn);
     
    void updateActor(Actor actor);
    
    List <Actor> findActors(Actor actor);

}