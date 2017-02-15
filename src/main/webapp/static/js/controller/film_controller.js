angular.module('myApp').controller('FilmController', ['$scope', '$location', '$ngBootbox', function($scope,$location, $ngBootbox) {
	this.bootbox=bootbox; 
	
	
	function bootbox(){
	    	$ngBootbox.alert("<embed src='webResources/newFilm.jsp'/>").then(function(result) {
	            console.log('Alert closed');
	        });
	    }

}]);
