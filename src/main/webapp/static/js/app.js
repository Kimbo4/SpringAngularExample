'use strict';

var App = angular.module('myApp',["ngRoute"])

App.config(function($routeProvider) {
    $routeProvider
    .when('/ricerca', {
        templateUrl : 'webResources/ricerca.jsp'
    })    
    .when('/edit/', {
        templateUrl : 'webResources/edit.jsp',
        controller : 'ActorController as ctrl'
    })
    .when('/new', {
        templateUrl : 'webResources/new.jsp'
    })

});


