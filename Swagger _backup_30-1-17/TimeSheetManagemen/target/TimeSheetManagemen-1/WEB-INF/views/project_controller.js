

App.controller('ProjectController', ['$scope', 'Project', function($scope, Project) {
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
          
              project.$delete(function(){
                console.log('Deleting project with id ', identity);
                self.fetchAllProjects();
              });
           });
          };

          self.fetchAllProjectss();

          self.submit = function() {
              if(self.project.id==null){
                  console.log('Saving New Project', self.project);    
                  self.createproject();
              }else{
            console.log('Upddating project with id ', self.project.id);
                  self.updateProject();
                  console.log('Project updated with id ', self.project.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.projects.length; i++){
                  if(self.projectss[i].id === id) {
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
                   self.fetchAllProjectss();
              }
             
          };

          
          self.reset = function(){
              self.project= new Project();
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
