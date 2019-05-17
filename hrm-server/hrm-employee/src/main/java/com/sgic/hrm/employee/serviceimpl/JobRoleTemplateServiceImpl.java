package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.JobRoleTemplate;
import com.sgic.hrm.commons.repository.JobRoleTemplateRepository;
import com.sgic.hrm.employee.service.JobRoleTemplateService;


@Service
public class JobRoleTemplateServiceImpl implements JobRoleTemplateService{
	@Autowired
	private JobRoleTemplateRepository jobRoleTemplateRepository;

	
	@Override
	public boolean addJobRoleTemplate(JobRoleTemplate jobRoleTemplate) {
		jobRoleTemplateRepository.save(jobRoleTemplate);
		return true;
	}

	@Override
	public List<JobRoleTemplate> getAllJobRoleTemplate() {
		return jobRoleTemplateRepository.findAll();
	}

	@Override
	public boolean editJobRoleTemplate(JobRoleTemplate jobRoleTemplate, Integer id) {
		boolean success = false;
		if (jobRoleTemplateRepository.getOne(id) != null) {
			jobRoleTemplate.setId(id);
			jobRoleTemplateRepository.save(jobRoleTemplate);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public boolean deleteJobRoleTemplate(Integer id) {
		JobRoleTemplate jobRoleTemplate = jobRoleTemplateRepository.getOne(id);
		if (jobRoleTemplate.getId() == (id)) {
			jobRoleTemplateRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
