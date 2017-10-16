angular.module('personneApp.controllers', ['angularModalService'])

	.controller('PersonneCtrl', function($scope, $location, ModalService, PersonnesService){
		
		
		$scope.stateList = [	{"id": 1, "name": "Msaken"},
		                    	{"id": 2, "name": "Tunis"},
		                    	{"id": 3, "name": "Sousse"},
		                    	{"id": 4, "name": "Bizerte"},
		                    ];

		$scope.showDeletePersonModal = function(userId, firstName) {
			$scope.userId = userId;
			$scope.firstName = firstName;
		}

		$scope.getPersonnes=function(){

			console.log("Controller: get all persons");

			PersonnesService.getPersonnes()
			    .then(
			        function (result) {
			            // promise was fullfilled (regardless of outcome)
			            // checks for information will be peformed here
			            
			        	$scope.personnes = result;
			        	$scope.displayMode = "list";

			        	console.log("$scope.personnes :" + JSON.stringify($scope.personnes, null, 1));
			        },
			        function (error) {
			            // handle errors here
			            console.log(error.statusText);
			        }
			    );

		};

		
		$scope.getPersonne=function(id){

			console.log("Controller: get person by id: "+id);

			$scope.displayMode = "edit";

			PersonnesService.getPersonne(id)
		    .then(
		        function (result) {
		            // promise was fullfilled (regardless of outcome)
		            // checks for information will be peformed here
		           
		        	$scope.personne = result;
		        	$scope.personCourant = result;

		        	console.log("$scope.personne :" + JSON.stringify($scope.personne, null, 1));

		        	//$location.path("/getById:"+id);
    				//$scope.$apply();
		        },
		        function (error) {
		            // handle errors here
		            console.log(error.statusText);
		        }
		    );
		};

		$scope.deletePerson=function(id){

			console.log("Controller: delete person id: "+id);

			PersonnesService.deletePerson(id)
		    .then(
		        function (result) {
		            // promise was fullfilled (regardless of outcome)
		            // checks for information will be peformed here
		        	$scope.personne = result;
		        	$scope.getPersonnes();
		        	$scope.cancel();
		        },
		        function (error) {
		            // handle errors here
		            console.log(error.statusText);
		        }
		    );
		};

		$scope.createPerson=function(projet){

			console.log("$scope.personne to create: " + JSON.stringify(projet, null, 1));

			PersonnesService.createPerson(projet)
				.then(function(newPersonId) {

					$scope.personCourant = {};
					$scope.getPersonnes();
				}, function(error) {
					console.log(error.statusText);
				});
		};

		$scope.updatePerson=function(projet){

			console.log("$scope.personne to update: " + JSON.stringify(projet, null, 1));

			PersonnesService.updatePerson(projet)
				.then(function(newPersonId) {

					$scope.personCourant = {};
					$scope.displayMode = "list";
					$scope.getPersonnes();
				}, function(error) {
					console.log(error.statusText);
				});
		};
		
		$scope.searchPersons = function(request){
			
			//init list
			$scope.personnes = {};

			console.log("search persons request : " + JSON.stringify(request, null, 1));

			PersonnesService.searchPersons(request)
				.then(function(result) {
					
					console.log("search persons result : " + JSON.stringify(result, null, 1));

					$scope.personnes = result.elements;
				}, function(error) {
					console.log(error.statusText);
				});
		};
		
		$scope.cancel = function() {
			$scope.personCourant = {};
			$scope.displayMode = "list";
			$scope.getPersonnes();
		}

		$scope.displayMode = "list";
		$scope.getPersonnes();

	})
	
	.controller('ModalController', function($scope, close) {
		 
		$scope.close = function(result) {
			 	close(result, 500); // close, but give 500ms for bootstrap to animate
		};
	})
	
	
	
	
	
	
	
	
	
	
	
	
	;