'use strict';

App.controller('UserController', ['$scope', 'User', function($scope, User) {
          var self = this;
          self.user= new User();
          
          self.users=[];
              
          self.fetchAllUsers = function(){
        	  self.users = User.query();
          };
           
          self.createUser = function(){
        	  self.user.$save(function(){
        		  self.fetchAllUsers();
        	  });
          };
		  
          self.updateUser = function(){
        	  self.user.$update(function(){
    			  self.fetchAllUsers();
    		  });
          };


         self.deleteUser = function(identity){
        	 var user = User.get({id:identity}, function() {
          
        		  user.$delete(function(){
        			  console.log('Deleting user with id ', identity);
        			  self.fetchAllUsers();
        		  });
        	 });
          };

          self.fetchAllUsers();

          self.submit = function() {
              if(self.user.id==null){
                  console.log('Saving New User', self.user);    
                  self.createUser();
              }else{
    			  console.log('Upddating user with id ', self.user.id);
                  self.updateUser();
                  console.log('User updated with id ', self.user.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.users.length; i++){
                  if(self.users[i].id === id) {
                     self.user = angular.copy(self.users[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
             self.deleteUser(id);

              console.log('id to be deleted', id);

              if(self.user.id === id) {//If it is the one shown on screen, reset screen
                 self.reset();
                   self.fetchAllUsers();
              }
             
          };

          
          self.reset = function(){
              self.user= new User();
              $scope.myForm.$setPristine(); //reset Form
          };

      }])



.controller('ProjectController', ['$scope', 'Project', function($scope, Project) {

         var self = this;
          self.project= new Project();

          self.projects=[];
         
         self.fetchAllProjects = function(){
            self.projects = Project.query();
          };
         
         
       self.createProject = function(){
            self.project.$save(function(){
              self.fetchAllProjects();
            });
          };
      

      self.updateProject = function(){
            self.project.$update(function(){
            self.fetchAllProjects();
          });
          };


 self.deleteProject = function(identity){
           var project = Project.get({id:identity}, function() {
          
              user.$delete(function(){
                console.log('Deleting user with id ', identity);
                self.fetchAllProjects();
              });
           });
          };

          self.fetchAllProjects();



     self.submit = function() {
              if(self.project.id==null){
                  console.log('Saving New User', self.project);    
                  self.createProject();
              }else{
            console.log('Upddating user with id ', self.project.id);
                  self.updateProject();
                  console.log('User updated with id ', self.project.id);
              }
              self.reset();
          };


       self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.projects.length; i++){
                  if(self.projects[i].id === id) {
                     self.project = angular.copy(self.projects[i]);
                     break;
                  }
              }
          };



     self.remove = function(id){
             self.deleteProject(id);

              console.log('id to be deleted', id);

              if(self.project.id === id) {//If it is the one shown on screen, reset screen
                 self.reset();
                   self.fetchAllProjects();
              }
             
          };


      self.reset = function(){
              self.project= new Project();
              $scope.ptForm.$setPristine(); //reset Form
          };




}]);



