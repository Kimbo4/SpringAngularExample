'use strict';

angular.module('myApp').controller('ActorController', ['$scope', 'ActorService', '$location', '$ngBootbox', function($scope, ActorService, $location, $ngBootbox) {
   
	var self = this;
	var film=null;
	var actor=null;
	
    self.film={idFilm:null, titolo:'', genere:'' };
    self.actor={actor_id:null, first_name:'',last_name:''};
    self.genere={idGenere:null,genere:''}
    self.generes=[];
    self.actors=[];
    film=self.film;
    actor=self.actor;
	var attorefilm=null;
 

    self.bootbox=bootbox;
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.details=details;
    self.reset = reset;
    self.goEdit = goEdit;
    self.fetchAllActors = fetchAllActors;
    self.inserisciFilmm = inserisciFilm;
    
    var idDet = $location.search();
   	var horror = 0;
   	var commedia = 0;
   	var azione = 0;
    
    $scope.chart = null;
    
    $scope.showGraph = function() {
    	
 
    	
    	ActorService.findAllFilm().then(
    			
       		 function(response){
       			 

       	    	
       			 for(var i = 0; i<response.length;i++){
       				 
       				if (response[i].genre.genere === 'Horror'){
       					horror++;
       				}
      				if (response[i].genre.genere === 'Fantasy'){
       					commedia++;
       				}
      				if (response[i].genre.genere === 'Azione'){
       					azione++;
       				}
       			 }
       	        $scope.chart = c3.generate({
                    bindto: '#chart',
                    
                    data: {
                      columns: [
                        ['Fantasy', commedia],
                        ['Horror', horror],
                        ['Azione', azione]
                      ],
                      type: 'bar'
                    }
                   
                }); 
    		 },
    		 
    		 function(responseError){
    			 bootbox.alert("Nessun risultato trovato");
    		 }
    	
    	);
    	

        console.log(commedia); 

        
    }
    
	function bootbox(){
    	$ngBootbox.alert("<embed src='webResources/newFilm.jsp'/>").then(function(result) {
            console.log('Alert closed');
        });
    }
    
    function inserisciFilm(titolo,genere){
    	self.film.filmName=titolo;
    }
   function goEdit(id) {
        $location.path('edit/').search({param:id});
        
    };
    
    function fetchAllActors(){
        if(self.actor.first_name==='' && self.actor.last_name==='' ){
            console.log('Ricerca di tutti gli attori');
             ActorService.fetchAllActors().
             then(
            		 
            		 function(response){
            			 self.actors=response;
            		 },
            		 function(responseError){
            			 bootbox.alert("Nessun risultato trovato");
            		 }
             )
        }else{
        	 ActorService.findActor(self.actor).
             then(
            		 
            		 function(response){
            			 
            			 self.actors=response;
            		 }
            		 
             
             );
        }
        reset();
    }

    function createActor(actor){
    	ActorService.createActor(actor)
            .then(fetchAllActors,
            		
            		
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }

    function updateActor(actor, actor_id, film,genere){
    	attorefilm={actor,film,genere};
    	ActorService.updateActor(attorefilm,actor_id)
            .then(
            fetchAllActors,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    	 $scope.showGraph();
    }

    function deleteActor(actor_id){
    	ActorService.deleteActor(actor_id)
            .then(
            fetchAllActors,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    	 $scope.showGraph();
    }

    function submit() {
        if(self.actor.actor_id===null){
            console.log('Saving New User', self.actor);
            createActor(self.actor);
        }else{
        	
            updateActor(self.actor, self.actor.actor_id, self.film, self.genere);
            console.log('User updated with id ', self.actor.actor_id);
        }
    }

    function edit(id){
        console.log('id to be edited', id);
        goEdit(id);
        for(var i = 0; i < self.actors.length; i++){
            if(self.actors[i].actor_id === id) {
                self.actor = angular.copy(self.actors[i]);
                break;
            }
        }
    }
    function details(){
    	
    	ActorService.details(idDet)
        .then(
        		function(response){
        			
        			self.actor=response;
        		}
            );
   	ActorService.findAllGenere().then(
    			
    			function(response){
    				self.generes=response;
    			}
    	);
    	
    	console.log('ho chiamato il metodo del dettaglio');
    }
    
    function remove(actor_id){
        console.log('id to be deleted', actor_id);
        if(self.actor.actor_id === actor_id) {// clean form if the user to be
												// deleted is shown there.
            reset();
        }
        deleteActor(actor_id);
    }


    function reset(){
        self.actor={actor_id:null,first_name:'',last_name:''};
        $scope.myForm.$setPristine(); // reset Form
    }

}]);
