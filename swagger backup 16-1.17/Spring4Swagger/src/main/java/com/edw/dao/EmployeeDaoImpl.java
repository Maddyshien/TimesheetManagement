package com.edw.dao;


import com.edw.spring4swagger.bean.Employee;
import com.edw.spring4swagger.bean.EmployeeList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	 SessionFactory sessionFactory;

	 Session session = null;
	 Transaction tx = null;
	 
	 
	public Employee addEmployee(Employee employee) throws Exception {
		session = sessionFactory.openSession();
		  tx = session.beginTransaction();
		  session.save(employee);
		  tx.commit();
		  session.close();
		  
		  System.out.println("Employee added successfully");
		return employee;

		
	}


	@Override
	public Employee getEmployeeById(Integer id) throws Exception {
		 session = sessionFactory.openSession();
		 
		  Employee employee = (Employee) session.load(Employee.class,
		    new Integer(id));
		  tx = session.getTransaction();
		  
		  session.beginTransaction();
		  
		  tx.commit();
		  System.out.println("get employee detail successfully");
		  System.out.println("data of "+employee.getName());
		  return employee;
		
	}


	@SuppressWarnings("unchecked")
	
	public List<Employee> getEmployees() {
		
		  session = sessionFactory.openSession();
		  tx = session.beginTransaction();
		  List<Employee> employeeList = session.createCriteria(Employee.class).list();
		  
		  
		  tx.commit();
		  session.close();
		  System.out.println(" all emloyee details");
		  
		  return employeeList;
		 }


	@Override
	public boolean deleteEmployeeById(Integer id) throws Exception {
		
		session = sessionFactory.openSession();
		  Object o = session.load(Employee.class, id);
		  tx = session.getTransaction();
		  session.beginTransaction();
		  session.delete(o);
		  tx.commit();
		  System.out.println("deleted  successfully");
		  return true;
	}


	@Override
	public Employee updatePartialEmployee(Integer id, Employee employee) throws Exception {
		
		
		try{
			
			
			session = sessionFactory.openSession();
			 Employee db_empl = (Employee) session.load(Employee.class,
					    new Integer(id));
			
			Transaction tx3 = session.beginTransaction();
			tx3.commit();
			
			
			Transaction tx4 = session.beginTransaction();
			
			db_empl.setAddress(employee.getAddress());
			
			db_empl.setName(employee.getName());
			
			db_empl.setEmail(employee.getEmail());
			
			db_empl.setRole(employee.getRole());
			
			db_empl.setSkill(employee.getSkill());
			
			db_empl.setSalary(employee.getSalary());
			
			
			session.saveOrUpdate(db_empl);
			
			System.out.println("UPdated successfully");
			
			tx4.commit();
			
			
			
			return employee;
		}
		catch (Exception e) {
			
		}
		
		return null;
	}
	
	
	
}
