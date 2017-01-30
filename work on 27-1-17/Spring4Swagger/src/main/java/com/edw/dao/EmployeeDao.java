package com.edw.dao;

import java.util.Collection;
import java.util.List;


import com.edw.spring4swagger.bean.Employee;
import com.edw.spring4swagger.bean.EmployeeList;

public interface EmployeeDao {

	public Employee addEmployee(Employee employee) throws Exception;
	
	public Employee getEmployeeById(Integer id)throws Exception;

	List<Employee> getEmployees();

	public boolean deleteEmployeeById(Integer id)throws Exception;

	public Employee updatePartialEmployee(Integer id, Employee employee)throws Exception ;
	
}
