'use strict';

var App = angular.module('myApp',["ngRoute","ngBootbox"]);

App.config(function($routeProvider) {
    $routeProvider
    .when('/ricerca', {
        templateUrl : 'webResources/ricerca.jsp'
    })    
    .when('/edit/', {
        templateUrl : 'webResources/edit.jsp',
    })
    .when('/new', {
        templateUrl : 'webResources/new.jsp'
    })

});


