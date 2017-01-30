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


@RestController
public class EmployeeController {

	 @Autowired
	 EmployeeService dataServices;
	
	 /*angular modeule*/
	    
	    
	    //using simple response enttity get all employee from angular */
	    
	    
	    @CrossOrigin
	    @ApiOperation(value = "Gets all the Employees", notes = "Retrieves all Employees details", response = Employee.class, responseContainer = "List")
	    @RequestMapping(value = "/employee", method = RequestMethod.GET)
	    public ResponseEntity<List<Employee>> listAllEmployees() {
	        List<Employee> emp = dataServices.getEmployees();
	        if(emp.isEmpty()){
	            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
	    }
	    
	    //
	    
	    /*add employee from angular*/
	    
	    @CrossOrigin
	    @ApiOperation(value = "Add new employee", notes = "Add new employee to employee list", response = Employee.class)
	    @RequestMapping(value = "/employee", method = RequestMethod.POST,consumes = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces = "application/json")
	    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating User " + employee.getName());
	  
	      
	  
	        dataServices.addEmployee(employee);
	  
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	  
	    
	    /*update user from angular */
	    
	    
	    @CrossOrigin
	    @ApiOperation(value = "update employee", notes = "update employee records", response = Employee.class)
	    @RequestMapping(value ="/employee/{id}", method = RequestMethod.PUT,consumes = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces = "application/json")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
	        System.out.println("Update Employee " + employee.getName());
	        
	        Employee emp;
	    	try {
	    		emp = dataServices.updatePartialEmployee(id, employee);
	    		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	    	} catch (Exception e) {
	    		
	    		e.printStackTrace();
	    	}
	    	return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	    
	    
	    }
	    
	    
	    /* delete a user from angular*/
	    
	    

	    @CrossOrigin
	    @ApiOperation(value = "delete single employee", notes = "delete employee by id", response = Employee.class)
	    @RequestMapping(value ="/employee/{id}", method = RequestMethod.GET)
	    public ResponseEntity<Employee> deleteEmployeeby(@PathVariable("id") Integer id) {

	    	try {
	    		dataServices.deleteEmployeeById(id);
	    	
	    		return new ResponseEntity<Employee>(HttpStatus.OK);
	    	} catch (Exception e) {
	    		
	    		e.printStackTrace();
	    	}
	    	return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	    
	    
	    }
	    
	    
	 
	 
}
