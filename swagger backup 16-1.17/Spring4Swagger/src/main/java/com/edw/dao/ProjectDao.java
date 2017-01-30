package com.edw.dao;

import java.util.List;

import com.edw.spring4swagger.bean.Employee;
import com.edw.spring4swagger.bean.Project;

public interface ProjectDao {

	
	public Project addProject(Project project)throws Exception;
	
	public List<Project> getProjects();
	
	public Project updatePartialProject(Integer id, Project project)throws Exception;

	public boolean deleteProjectById(Integer id)throws Exception;

	
}
