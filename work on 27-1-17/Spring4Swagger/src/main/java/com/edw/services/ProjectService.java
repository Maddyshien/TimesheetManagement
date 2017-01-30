package com.edw.services;

import java.util.List;

import com.edw.spring4swagger.bean.Employee;
import com.edw.spring4swagger.bean.Project;

public interface ProjectService {

	public Project addProject(Project project);
	
	public List<Project> getProjects();
	
	public Project updatePartialProject(Integer id, Project project)throws Exception;

	public boolean deleteEmployeeById(Integer id)throws Exception;
}
