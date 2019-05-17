package com.sgic.hrm.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.ResizableData;
import com.sgic.hrm.commons.dto.mapper.ResizableDataToResizable;
import com.sgic.hrm.commons.entity.mapper.ResizableToResizableData;
import com.sgic.hrm.lms.service.ResizableService;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ResizableController {
	@Autowired
	ResizableService resizableService;
	
	@GetMapping("resizable")
	public List<ResizableData> getAllResizable() {
		return ResizableToResizableData.mapToResizableList(resizableService.getAllResizable());
	}
	
	@PostMapping("/resizable")
	public HttpStatus addResizable(@RequestBody ResizableData resizableData) {
		if (resizableService.addResizable(ResizableDataToResizable.mapToResizable(resizableData))) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}
}
