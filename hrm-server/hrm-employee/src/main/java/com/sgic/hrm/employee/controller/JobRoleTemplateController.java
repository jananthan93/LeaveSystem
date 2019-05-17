package com.sgic.hrm.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.JobRoleTemplateData;
import com.sgic.hrm.commons.dto.mapper.JobRoleTemplateDataMapper;
import com.sgic.hrm.commons.entity.JobRoleTemplate;
import com.sgic.hrm.employee.service.JobRoleTemplateService;



@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class JobRoleTemplateController {
	@Autowired
	private JobRoleTemplateService jobRoleTemplateService;
	
	@PostMapping("/jobRoleTemplate")
	public HttpStatus createJobRoleTemplate( @RequestBody JobRoleTemplateData jobRoleTemplateData) {
		boolean test = jobRoleTemplateService.addJobRoleTemplate(JobRoleTemplateDataMapper.jobRoleTemplateDataMapper(jobRoleTemplateData));
		if (test) {
			return HttpStatus.CREATED;

		}

		return HttpStatus.BAD_REQUEST;
	}
	
	@GetMapping("/jobRoleTemplate")
	public ResponseEntity<List<JobRoleTemplate>> getJobRoleTemplate() {
		List<JobRoleTemplate> jobRoleTemplate = jobRoleTemplateService.getAllJobRoleTemplate();
		ResponseEntity<List<JobRoleTemplate>> response = new ResponseEntity<>(jobRoleTemplate, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/jobRoleTemplate/{id}")
	public ResponseEntity<String> updateJobRoleTemplate(@PathVariable(name="id") Integer id,@RequestBody JobRoleTemplateData jobRoleTemplateData){
		JobRoleTemplate jobRoleTemplate=JobRoleTemplateDataMapper.jobRoleTemplateDataMapper(jobRoleTemplateData);
		if(jobRoleTemplateService.editJobRoleTemplate(jobRoleTemplate, id))
		{
			return new ResponseEntity<>("updated",HttpStatus.OK);
		}
		return new ResponseEntity<>("upadte failed", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/jobRoleTemplate/{id}")
	public HttpStatus deleteJobRoleTemplate(@PathVariable("id") Integer id) {
		boolean test = jobRoleTemplateService.deleteJobRoleTemplate(id);
		HttpStatus status;
		if (test) {
			return HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return status;
	}
}
