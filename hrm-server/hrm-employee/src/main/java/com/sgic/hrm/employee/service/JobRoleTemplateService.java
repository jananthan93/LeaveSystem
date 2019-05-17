package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.JobRoleTemplate;



public interface JobRoleTemplateService {
	 boolean addJobRoleTemplate(JobRoleTemplate jobRoleTemplate);
	  
	   List<JobRoleTemplate> getAllJobRoleTemplate();
	   
	   boolean editJobRoleTemplate(JobRoleTemplate jobRoleTemplate, Integer id);
	   
	   boolean deleteJobRoleTemplate(Integer id);
}
