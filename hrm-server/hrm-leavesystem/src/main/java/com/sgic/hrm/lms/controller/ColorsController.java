package com.sgic.hrm.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.ColorsData;
import com.sgic.hrm.commons.entity.mapper.ColorsToColorsData;
import com.sgic.hrm.lms.service.ColorsService;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ColorsController {
	@Autowired
	ColorsService colorsService;
	
	@GetMapping("colors")
	public List<ColorsData> getAllColors() {
		return ColorsToColorsData.mapToColorsDataList(colorsService.getAllColors());
	}
}
