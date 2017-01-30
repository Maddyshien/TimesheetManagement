package com.edw.spring4swagger.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "emplist")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class EmpList {

	
	
	
	java.util.ArrayList<Employee> emp;

	public java.util.ArrayList<Employee> getEmp() {
		return emp;
	}

	public void setEmp(java.util.ArrayList<Employee> emp) {
		this.emp = emp;
	}


	
	
	 
	 
	
	
	 
	
}
