package com.websystique.springmvc.controller;
 
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springmvc.model.Actor;
import com.websystique.springmvc.model.Film;
import com.websystique.springmvc.service.ActorService;
import com.websystique.springmvc.service.FilmService;
 
@RestController
public class HelloWorldRestController {
 
    
    @Autowired
    ActorService actorService;
    
    @Autowired
    FilmService filmService;
    
    //-------------------Retrieve film--------------------------------------------------------
    
    @RequestMapping(value = "/film/", method = RequestMethod.GET)
    public ResponseEntity<List<Film>> getFilms(   UriComponentsBuilder ucBuilder)  {
        
//        if (acto.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
    	
    	
      	List<Film> film=filmService.findAllFilm();       
    	if(film.isEmpty()){
            return new ResponseEntity<List<Film>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Film>>(film, HttpStatus.OK);
   
      }
 
 
    //-------------------Add a new Actor--------------------------------------------------------
    
    @RequestMapping(value = "/actor/", method = RequestMethod.POST)
    public ResponseEntity<Void> createActor(@RequestBody Actor actor,    UriComponentsBuilder ucBuilder)  {
        
//        if (acto.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
    	
    	Actor actorCriteria = new Actor();
    	actorCriteria.setFirst_name(actor.getFirst_name());
    	actorCriteria.setLast_name(actor.getLast_name());
    	actorCriteria.setLast_update(new Timestamp(System.currentTimeMillis()));
        actorService.saveActor(actorCriteria);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/actor/{id}").buildAndExpand(actorCriteria.getActor_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
    
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/actor/", method = RequestMethod.GET)
    public ResponseEntity<List<Actor>> listAllUsers() {
       	List<Actor> actor=actorService.findAllActors();
        
    	if(actor.isEmpty()){
            return new ResponseEntity<List<Actor>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
    	
    	//Film prova = filmService.findById(actor.get(0).getFilms().iterator().next().getIdFilm());
    	
        return new ResponseEntity<List<Actor>>(actor, HttpStatus.OK);
    }

    //-------------------Search actor----------------------------------------------7----------
    
    @RequestMapping(value = "/findActor/", method = RequestMethod.POST)
    public ResponseEntity<List<Actor>> listUsers(@RequestBody Actor actor) {
       	List<Actor> actorList=actorService.findActors(actor);
        
    	if(actorList.isEmpty()){
            return new ResponseEntity<List<Actor>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Actor>>(actorList, HttpStatus.OK);
    }

    //-------------------Retrieve Single User--------------------------------------------------------
    
    @RequestMapping(value = "/actor/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Actor> getActor(@PathVariable("id") int id) {
    	
        Actor actor = actorService.findBySsn(id);
        
        if (actor == null) {
            System.out.println("Actor with id " + id + " not found");
            return new ResponseEntity<Actor>(HttpStatus.NOT_FOUND);
        }
        if(actor.getFilms()!=null);
        Set<Film> setFilm = actor.getFilms(); 
        List<Film> films = Arrays.asList(setFilm.toArray(new Film[0])); 
        actor.setFilm(films); 
        return new ResponseEntity<Actor>(actor, HttpStatus.OK);
    }
     
    //------------------- Update actor --------------------------------------------------------
     
    @RequestMapping(value = "/actor/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Actor> updateActor(@PathVariable("id") Integer id, @RequestBody Actor actor) {
        System.out.println("Updating User " + id);
         Actor currentActor = actorService.findBySsn(id);
         
        if (currentActor==null) {
            System.out.println("Actor with id " + id + " not found");
            return new ResponseEntity<Actor>(HttpStatus.NOT_FOUND);
        }
        
        
       Set<Film> film = new HashSet<Film>();
        
        Film films = new Film();
        films.setFilmName("lo squalo");
        films.setGenre("horror");
        films.setIdFilm(1);
        film.add(films);
        
        currentActor.setFirst_name(actor.getFirst_name());
        currentActor.setLast_name(actor.getLast_name());
        currentActor.setLast_update(new Timestamp(System.currentTimeMillis()));
        actorService.updateActor(currentActor);
        return new ResponseEntity<Actor>(currentActor, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/actor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Actor> deleteActor(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
        
//        Actor actor = actorService.findById(id);
//        if (user == null) {
//            System.out.println("Unable to delete. User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
 
        actorService.deleteActorBySsn(id);
        return new ResponseEntity<Actor>(HttpStatus.NO_CONTENT);
    }

}