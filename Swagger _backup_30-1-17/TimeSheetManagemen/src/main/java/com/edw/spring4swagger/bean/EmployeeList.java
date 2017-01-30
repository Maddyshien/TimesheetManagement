package com.edw.spring4swagger.bean;

import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;





@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class EmployeeList {

	
	 private List<Employee> employees;

	 
	 
	 public EmployeeList() {
		 employees= new ArrayList<Employee>();
		    }


	 
	
	 public EmployeeList(List<Employee> items) {
			this.employees = items;
		    }


	 @XmlElement
	    public List<Employee> getEmployee() {
		return employees;
	    }
	 
	 


	
	 
	
}
