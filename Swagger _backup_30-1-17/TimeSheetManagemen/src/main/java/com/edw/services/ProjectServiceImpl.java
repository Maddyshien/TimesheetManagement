package com.edw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edw.dao.ProjectDao;
import com.edw.spring4swagger.bean.Employee;
import com.edw.spring4swagger.bean.Project;

public class ProjectServiceImpl implements ProjectService {

	
	@Autowired 
	ProjectDao projectdao;
	
	@Override
	public Project addProject(Project project) {
		try {
			projectdao.addProject(project);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return project;
		
	}

	@Override
	public List<Project> getProjects() {
      List<Project> projectlist=  projectdao.getProjects();
		
		return projectlist;
	}

	@Override
	public Project updatePartialProject(Integer id, Project project) throws Exception {
		Project proj;
		try
		{
		proj=projectdao.updatePartialProject(id,project);
		return proj;
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null; 
	}

	@Override
	public boolean deleteEmployeeById(Integer id) throws Exception {
		
		return projectdao.deleteProjectById(id);
	}

}
