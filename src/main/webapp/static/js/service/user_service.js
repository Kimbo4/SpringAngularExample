'use strict';

angular.module('myApp').factory('ActorService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8000/Spring4MVCAngularJSExample/actor/';   
    
    var factory = {
            fetchAllActors: fetchAllActors,
            createActor: createActor,
            updateActor:updateActor,
            deleteActor:deleteActor,
            details:details,
            findActor:findActor
        };

    return factory;

    function findActor(actor){
        var deferred = $q.defer();
        $http.post('http://localhost:8000/Spring4MVCAngularJSExample/findActor/',actor)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;   	
    }
    
    function fetchAllActors() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createActor(actor) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, actor)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    function details(idDet){
    	var deferred = $q.defer();
    	$http.get('http://localhost:8000/Spring4MVCAngularJSExample/actor/'+idDet.param)
    	.then(
    	function(response){
    		deferred.resolve(response.data);
    	},
    	function(errResponse){
    		console.error('si è verificato un errore');
    		deferred.reject(errResponse);
    	}
    	);
    	return deferred.promise;
    }

    function updateActor(actor, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, actor)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating actor');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteActor(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Actor');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
