package com.edw.services;

import java.util.Collection;
import java.util.List;

import com.edw.spring4swagger.bean.Employee;
import com.edw.spring4swagger.bean.EmployeeList;



public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	
	public Employee getEmployeeById(Integer id);

	public List<Employee> getEmployees();

	public boolean deleteEmployeeById(Integer id)throws  Exception;

	public Employee updatePartialEmployee(Integer id, Employee employee)throws Exception;
}
