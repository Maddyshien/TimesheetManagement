package com.edw.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.edw.spring4swagger.bean.Employee;
import com.edw.spring4swagger.bean.Project;

public class ProjectDaoImpl implements ProjectDao {

	
	@Autowired
	 SessionFactory sessionFactory;

	 Session session = null;
	 Transaction tx = null;
	@Override
	public Project addProject(Project project) throws Exception {
		session = sessionFactory.openSession();
		  tx = session.beginTransaction();
		  session.save(project);
		  tx.commit();
		  session.close();
		  
		  System.out.println(" project added successfully");
		return project;
	}
	
	
	
	
	public List<Project> getProjects() {
		session = sessionFactory.openSession();
		  tx = session.beginTransaction();
		  List<Project> projectList = session.createCriteria(Project.class).list();
		  
		  
		  tx.commit();
		  session.close();
		  System.out.println(" all project details");
		  
		  return projectList;
	}




	@Override
	public Project updatePartialProject(Integer id, Project project) throws Exception {
		
     try{
			
			
			session = sessionFactory.openSession();
			 Project db_proj = (Project) session.load(Project.class,
					    new Integer(id));
			
			Transaction tx3 = session.beginTransaction();
			tx3.commit();
			
			Transaction tx4 = session.beginTransaction();
			
			db_proj.setProj_id(project.getProj_id());
			
			db_proj.setProj_name(project.getProj_name());
			
			db_proj.setProj_desc(project.getProj_desc());
			
			db_proj.setCreated_by(project.getCreated_by());
			
			db_proj.setNo_of_developer(project.getNo_of_developer());
			
			db_proj.setStart_date(project.getStart_date());
			
			db_proj.setEnd_date(project.getEnd_date());
			
			db_proj.setStatus(project.getStatus());
			
			
			session.saveOrUpdate(db_proj);
			
			System.out.println("UPdated project successfully");
			
			tx4.commit();
			
			
			
			return project;
		}
		catch (Exception e) {
			
		}
		
		return null;
	}




	@Override
	public boolean deleteProjectById(Integer id) throws Exception {

		session = sessionFactory.openSession();
		  Object o = session.load(Project.class, id);
		  tx = session.getTransaction();
		  session.beginTransaction();
		  session.delete(o);
		  tx.commit();
		  System.out.println(" project deleted successfully");
		  return true;
	}

	
	
	
	
	
	
	
}
