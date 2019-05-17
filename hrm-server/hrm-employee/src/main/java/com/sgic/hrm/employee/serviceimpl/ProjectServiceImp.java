package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.Project;
import com.sgic.hrm.commons.repository.ProjectRepository;
import com.sgic.hrm.employee.service.ProjectService;

@Service
public class ProjectServiceImp implements ProjectService{
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public List<Project> getProjects() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

}
