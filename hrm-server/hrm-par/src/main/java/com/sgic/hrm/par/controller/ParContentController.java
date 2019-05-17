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

import com.sgic.hrm.commons.entity.par.ParContent;
import com.sgic.hrm.par.service.ParContentService;



@RestController
@CrossOrigin
public class ParContentController {
	@Autowired
	private ParContentService parContentService;
	
	@GetMapping("/parcontent")
	public List<ParContent> ViewParContent() {
		return parContentService.getParContent();
	}

	@PostMapping("/parcontent")
	public void createParContent(@RequestBody ParContent parContent) {
		parContentService.createParContent(parContent);
	}

	@PutMapping("/parcontent/{id}")
	public void updateParContent(@RequestBody ParContent parContent, @PathVariable Integer id) {
		parContentService.updateParContent(parContent, id);
	}

	@DeleteMapping("/parcontent/{id}")
	public void deleteParContent(@PathVariable Integer id) {
		parContentService.deleteParContent(id);
	}
	
}