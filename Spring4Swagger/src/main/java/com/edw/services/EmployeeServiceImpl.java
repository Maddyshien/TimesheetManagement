package com.edw.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edw.dao.EmployeeDao;
import com.edw.spring4swagger.bean.EmpList;
import com.edw.spring4swagger.bean.Employee;
import com.edw.spring4swagger.bean.EmployeeList;



public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	 EmployeeDao employeedao;

	@Override
	public Employee addEmployee(Employee employee) {
		
		try {
			employeedao.addEmployee(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
		
		
		
		
	}

	public Employee getEmployeeById(Integer id) {
		

		Employee emp;
		try {
			emp = employeedao.getEmployeeById(id);
			return emp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println("to add new employee service");
		
		
		return null;
	
	}


	public List<Employee> getEmployees() {
		
		List<Employee> employeeList=  employeedao.getEmployees();
		
		return employeeList;
	}

	@Override
	public boolean deleteEmployeeById(Integer id) throws Exception {
		
		
		
		return employeedao.deleteEmployeeById(id);
	}

	@Override
	public Employee updatePartialEmployee(Integer id, Employee employee) throws Exception {
		
		Employee emp;
		try
		{
		emp=employeedao.updatePartialEmployee(id,employee);
		return emp;
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null; 
	}

	
	
	
}
