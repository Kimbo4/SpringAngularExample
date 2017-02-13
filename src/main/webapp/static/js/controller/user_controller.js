'use strict';

angular.module('myApp').controller('ActorController', ['$scope', 'ActorService', '$location',function($scope, ActorService, $location) {
    var self = this;
    
    self.film={idFilm:null, filmName:'', genre:'' };
    var film=[]
    self.actor={actor_id:null, first_name:'',last_name:'', film };
    self.actors=[];


    
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.details=details;
    self.reset = reset;
    self.goEdit = goEdit;
    self.fetchAllActors = fetchAllActors;
    
    var idDet = $location.search();
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

    function updateActor(actor, actor_id){
    	ActorService.updateActor(actor, actor_id)
            .then(
            fetchAllActors,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }

    function deleteActor(actor_id){
    	ActorService.deleteActor(actor_id)
            .then(
            fetchAllActors,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }

    function submit() {
        if(self.actor.actor_id===null){
            console.log('Saving New User', self.actor);
            createActor(self.actor);
        }else{
            updateActor(self.actor, self.actor.actor_id);
            console.log('User updated with id ', self.actor.actor_id);
        }
        reset();
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
    	console.log('ho chiamato il metodo del dettaglio');
    }
    
    function remove(actor_id){
        console.log('id to be deleted', actor_id);
        if(self.actor.actor_id === actor_id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteActor(actor_id);
    }


    function reset(){
        self.actor={actor_id:null,first_name:'',last_name:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
