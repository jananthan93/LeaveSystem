package com.sgic.hrm.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.entity.Project;
import com.sgic.hrm.employee.service.ProjectService;

@RestController
public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/project")
	public List<Project> getProjects(){
		return projectService.getProjects();
	}
}
