<html>
  <head>  
    <title>TimeSheet Management App</title>  
    <style>
      .projectname.ng-valid {
          background-color: lightgreen;
      }
      .projectname.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .projectname.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link rel="stylesheet" href="app.css">
     <link rel="stylesheet" href="angularjs-datetime-picker.css" />
  </head>
  <body ng-app="myApp" class="ng-cloak">

      <div class="generic-container" ng-controller="ProjectController as ptCtrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Project page</span></div>
              <div class="formcontainer">
                  <form ng-submit="ptCtrl.submit()" name="ptForm" class="form-horizontal">
                      
                  <input type="hidden" ng-model="ptCtrl.project.id" />



                  <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="proj_id">Project ID</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ptCtrl.project.proj_id" id="proj_id" class="projectname form-control input-sm" placeholder="Enter your project id" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="ptForm.$dirty">
                                      <span ng-show="ptForm.name.$error.required">This is a required field</span>
                                      <span ng-show="ptForm.nname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="ptForm.name.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>




                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="proj_name">Project Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ptCtrl.project.proj_name" id="proj_name" class="projectname form-control input-sm" placeholder="Enter your project name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="ptForm.$dirty">
                                      <span ng-show="ptForm.name.$error.required">This is a required field</span>
                                      <span ng-show="ptForm.nname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="ptForm.name.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="proj_desc">Project Description</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ptCtrl.project.proj_desc" id="proj_desc" class="form-control input-sm" placeholder="Enter project description. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="created_by">Created_By</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ptCtrl.project.created_by" id="created_by" class="form-control input-sm" placeholder="Enter project creator. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>


                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="no_of_developer">Number of developer</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ptCtrl.project.no_of_developer" id="no_of_developer" class="form-control input-sm" placeholder="Enter number of developers. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>



                    <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="start_date">Start_Date</label>
                              <div class="col-md-7">
                                   <input ng-model="ptCtrl.project.start_date" datetime-picker date-format="yyyy-MM-dd" date-only id="start_date" class="form-control input-sm" placeholder="Enter your start date. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>


                  <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="end_date">End_Date</label>
                              <div class="col-md-7">
                                   <input ng-model="ptCtrl.project.end_date" datetime-picker date-format="yyyy-MM-dd" date-only id="end_date" class="form-control input-sm" placeholder="Enter your end date. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>


                  <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="status">Status</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ptCtrl.project.status" id="status" class="form-control input-sm" placeholder="Enter status. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>
                   

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ptCtrl.project.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="ptForm.$invalid">
                              <button type="button" ng-click="ptCtrl.reset()" class="btn btn-warning btn-sm" ng-disabled="ptForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Projects </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>Project ID</th>
                              <th>Project Name</th>
                              <th>Description</th>
                              <th>Created by</th>

                              <th>Count Developers</th>
                              <th>Start Date</th>
                             
                               <th>End Date</th>
                                <th>Status</th>

                              <th width="100"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ptCtrl.projects">
                              <td><span ng-bind="u.proj_id"></span></td>
                              <td><span ng-bind="u.proj_name"></span></td>
                              <td><span ng-bind="u.proj_desc"></span></td>
                              <td><span ng-bind="u.created_by"></span></td>
                               
                              <td><span ng-bind="u.no_of_developer"></span></td>
                               <td><span ng-bind="u.start_date"></span></td>
                                <td><span ng-bind="u.end_date"></span></td>
                                <td><span ng-bind="u.status"></span></td>


                              <td>
                              <button type="button" ng-click="ptCtrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ptCtrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
 





     
      <script src="angular.js"></script>
      <script src="angular-resource.js"></script>

      <script src="app.js"></script>
      <script src="user_service.js"></script>  
      <script src="user_controller.js"></script>
      <script src="angularjs-datetime-picker.js"></script>
  </body>
</html>
