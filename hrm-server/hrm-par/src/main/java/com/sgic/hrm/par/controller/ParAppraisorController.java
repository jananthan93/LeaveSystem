package com.sgic.hrm.par.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.entity.par.ParAppraisor;
import com.sgic.hrm.par.service.ParAppraisorService;

@RestController
@CrossOrigin
public class ParAppraisorController {
	@Autowired
	private ParAppraisorService parAppraisorService;

	@GetMapping("/parappraisor")
	public List<ParAppraisor> ViewParAppraisor() {
		return parAppraisorService.getParAppraisor();
	}

	@PostMapping("/parappraisor")
	public void createParAppraisor(@RequestBody ParAppraisor parAppraisor) {
		parAppraisorService.createParAppraisor(parAppraisor);
	}

	@PutMapping("/parappraisor/{id}")
	public void updateParAppraisor(@RequestBody ParAppraisor parAppraisor, @PathVariable Integer id) {
		parAppraisorService.updateParAppraisor(parAppraisor, id);
	}

	@DeleteMapping("/parappraisor/{id}")
	public void deleteParAppraisor(@PathVariable Integer id) {
		parAppraisorService.deleteParAppraisor(id);
	}

}