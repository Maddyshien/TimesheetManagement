<html>
  <head>  
    <title>TimeSheet Management App</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
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

      <div class="generic-container" ng-controller="UserController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Employee page</span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      
                  <input type="hidden" ng-model="ctrl.user.id" />



                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="name">Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.name" id="name" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.name.$error.required">This is a required field</span>
                                      <span ng-show="myForm.nname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.name.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="address">Address</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.address" id="address" class="form-control input-sm" placeholder="Enter your Address. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="email">Email</label>
                              <div class="col-md-7">
                                  <input type="email" ng-model="ctrl.user.email" id="email" class="email form-control input-sm" placeholder="Enter your Email" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>



                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="skill">Skill</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.skill" id="skill" class="form-control input-sm" placeholder="Enter your Skill. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>




                    <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="role">Role</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.role" id="role" class="form-control input-sm" placeholder="Enter your Role. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>




                   <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="salary">Salary</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.salary" id="salary" class="form-control input-sm" placeholder="Enter your Salary. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>

                   

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>


                 <div class="row">




              <input ng-model="date2" datetime-picker date-format="yyyy-MM-dd" date-only />
                         </div>


                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Users </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID</th>
                              <th>Name</th>
                              <th>Address</th>
                              <th>Email</th>

                              <th>Skill</th>
                              <th>Role</th>
                              <th>Salary</th>



                              <th width="100"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.users">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.name"></span></td>
                              <td><span ng-bind="u.address"></span></td>
                              <td><span ng-bind="u.email"></span></td>
                               
                              <td><span ng-bind="u.skill"></span></td>
                               <td><span ng-bind="u.role"></span></td>
                                <td><span ng-bind="u.salary"></span></td>



                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
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