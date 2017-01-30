'use strict';

App.factory('User', ['$resource', function ($resource) {
	//$resource() function returns an object of resource class
    return $resource(
    		'http://localhost:8080/Spring4Swagger/employee/:id',
  
    		{id: '@id'},
            {
                update: {
                      method: 'PUT' // To send the HTTP Put request when calling this custom update method.
                }
                 
            }

            
    );
}]


)
.factory('Project', ['$resource', function ($resource) {
    //$resource() function returns an object of resource class
    return $resource(
            'http://localhost:8080/Spring4Swagger/project/:id',
  
            {id: '@id'},
            {
                update: {
                      method: 'PUT' // To send the HTTP Put request when calling this custom update method.
                }
                 
            }

            
    );
}]);




