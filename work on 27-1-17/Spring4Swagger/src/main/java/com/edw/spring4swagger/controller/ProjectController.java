package com.edw.spring4swagger.controller;




import com.edw.services.EmployeeService;
import com.edw.services.ProjectService;
import com.edw.spring4swagger.bean.Employee;
import com.edw.spring4swagger.bean.EmployeeList;
import com.edw.spring4swagger.bean.Project;
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
public class ProjectController {

	@Autowired
	 ProjectService dataServicesProject;
	
	/*to add new project  */
	
	 @CrossOrigin
	    @ApiOperation(value = "Add new project", notes = "Add new project to employee list", response = Project.class)
	    @RequestMapping(value = "/project", method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	    public ResponseEntity<Void> createProject(@RequestBody Project project,    UriComponentsBuilder ucBuilder) {
	        
	   
	        dataServicesProject.addProject(project);
	  
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/project/{id}").buildAndExpand(project.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	
	
	 /*get project list */
	 
	 @CrossOrigin
	    @ApiOperation(value = "Gets all the Projects", notes = "Retrieves all project details", response = Project.class, responseContainer = "List")
	    @RequestMapping(value = "/project", method = RequestMethod.GET)
	    public ResponseEntity<List<Project>> listAllProjects() {
	        List<Project> proj = dataServicesProject.getProjects();
	        if(proj.isEmpty()){
	            return new ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Project>>(proj, HttpStatus.OK);
	    }
	    
	/*update project detail */
	
	 @CrossOrigin
	    @ApiOperation(value = "update project", notes = "update project details", response = Project.class)
	    @RequestMapping(value ="/project/{id}", method = RequestMethod.PUT,consumes = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces = "application/json")
	    public ResponseEntity<Project> updateProject(@PathVariable("id") Integer id, @RequestBody Project project) {
	        System.out.println("Update Employee " + project.getProj_name());
	        
	       Project proj;
	    	try {
	    		proj = dataServicesProject.updatePartialProject(id, project);
	    		return new ResponseEntity<Project>(proj, HttpStatus.OK);
	    	} catch (Exception e) {
	    		
	    		e.printStackTrace();
	    	}
	    	return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
	    
	    
	    }
	    
	/*delete project detail */
	
	   @CrossOrigin
	    @ApiOperation(value = "delete single project ", notes = "delete project by id", response = Project.class)
	    @RequestMapping(value ="/project/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<String> deleteProjectby(@PathVariable("id") Integer id) {

		       
		   
	    	try {
	    		dataServicesProject.deleteEmployeeById(id);
	    	
	    		return new ResponseEntity<String>("project deleted succesfully ",HttpStatus.OK);
	    	} catch (Exception e) {
	    		
	    		e.printStackTrace();
	    	}
	    	return new ResponseEntity<String>("project wass not found",HttpStatus.NO_CONTENT);
	    
	    
	    }
	 
	 
	 
	 
	 
	
	
}
