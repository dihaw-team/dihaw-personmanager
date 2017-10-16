angular.module('personneApp', [
	'ngAnimate', 
	'ngRoute',
	'ngResource',
	
	'ui.bootstrap',
	'ui.select2',
	'ngGrid',
//	'xeditable',
	
	'config',
	'personneApp.services', 
	'personneApp.controllers'
	])

	.config(function ($routeProvider) {
		$routeProvider
			.when('/', {templateUrl: 'partials/home.html',
					controller: 'PersonneCtrl'})
			.when('/test', {templateUrl: 'partials/test.html',
					controller: 'PersonneCtrl'})
			.when("/about", {
     				templateUrl: "partials/about.html" })
			.otherwise({redirectTo : '/'})
	});







