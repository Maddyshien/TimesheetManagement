package com.edw.spring4swagger.controller;

import com.edw.services.EmployeeService;

import com.edw.spring4swagger.bean.Employee;
import com.edw.spring4swagger.bean.EmployeeList;
import com.edw.spring4swagger.bean.Test;



import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



/**
 * 
 *
 * 

 *
 */
@RestController
public class TestController {

	 @Autowired
	 EmployeeService dataServices;
	 
	  @Autowired
	    private MessageSource messageSource;
	
	
	
	  
	  

		 @CrossOrigin
		    @ApiOperation(value = "Testing Page")
		    @RequestMapping(value = "/test", method = RequestMethod.POST)
		    public Test test(@RequestParam String name, @RequestParam(required = false) String address) {
		        Test test = new Test();
		        test.setAddress(address);
		        test.setName(name);
		        return test;
		    }
	  
	  
	  
	  

    /*add employee*/
    
    @ApiOperation(value = "To add new Employee",notes="Method for add new employee",response=Employee.class)
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST,consumes = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces = "application/json")
    public @ResponseBody
   Employee employee(@RequestBody Employee employee) {
       
       dataServices.addEmployee(employee);
        
		return employee;
     
    }
    
    /*get employee by id*/
    
    @ApiOperation(value = "To getEmployee By Id",notes="Method for get employee Details by Id",response = Employee.class)
    @RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET,produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE })
   
    @ResponseBody 
    public Employee getEmployee(@PathVariable Integer id) {
    
     Employee employee = dataServices.getEmployeeById(id);
      
   
     return employee;
    }
    
    /*get employee all employee details*/
    @ApiOperation(value = "Gets all the Employees", notes = "Retrieves all Employees details", response = Employee.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE
	    }, value = "employees")
    @ResponseBody
    public EmployeeList getEmployees() {
    	
    	
    	 
    	
    	
		return new EmployeeList(new ArrayList<Employee>(dataServices.getEmployees()));
    	
   
	
    }
    
    /*delete employee detail by id*/
    @ApiOperation(value = "To delete Employee By Id",notes="Method for delete employee Details by Id",response = Employee.class)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET,produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE })
   
    @ResponseBody 
    public String deleteEmployee(@PathVariable Integer id) {
    
    	try{
     dataServices.deleteEmployeeById(id);
         
     return "employee detail deletded ";
     
    	}
    	catch (Exception e) {
			System.out.println(e);
		}
   
     return "employee detail not fetched";
    }
    
    
    /*update partial record*/
    
    @ApiOperation(value = "Updates a Employee partially based on Employee id", notes = "Partially updates a employee", response = Employee.class)
    @RequestMapping(method = RequestMethod.PATCH, consumes = { MediaType.APPLICATION_XML_VALUE,
	    MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
		    MediaType.APPLICATION_JSON_VALUE }, value = "employee/{id}")
    public @ResponseBody Employee updatePartialCustomer(@PathVariable("id") Integer id,
	    @RequestBody Employee employee) {
	Employee emp;
	try {
		emp = dataServices.updatePartialEmployee(id, employee);
		return emp;
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return null;
    }
    
    
    /*  using ResponseEntity get all employee*/
    
    @ApiOperation(value = "Gets all the Employees", notes = "Retrieves all Employees details", response = Employee.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE
    }, value = "employeeList")
    public ResponseEntity<EmployeeList> handleUserRequest (RequestEntity<String> requestEntity) {
    	
    	 MultiValueMap<String, String> headers = new HttpHeaders();
         headers.put("Cache-Control", Arrays.asList("max-age=3600"));
    	
         System.out.println("request headers " + requestEntity.getHeaders());
         
         ResponseEntity<EmployeeList> responseEntity = new ResponseEntity<EmployeeList>(new EmployeeList(new ArrayList<Employee>(dataServices.getEmployees())),
                 headers,
                 HttpStatus.OK);
         
         
     return responseEntity;
    }
    
    
    
    
    
    
}
