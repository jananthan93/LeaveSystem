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

import com.sgic.hrm.commons.dto.DistrictData;
import com.sgic.hrm.commons.dto.mapper.DistrictDataMapper;
import com.sgic.hrm.commons.entity.District;
import com.sgic.hrm.employee.service.DistrictService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
public class DistrictController {
	
	@Autowired
	private DistrictService districtService;

	
	@PostMapping("/district")
	public HttpStatus createDistrict( @RequestBody DistrictData districtData) {
		boolean test = districtService.addDistrict(DistrictDataMapper.districtDataMapper(districtData));
		if (test) {
			return HttpStatus.CREATED;

		}

		return HttpStatus.BAD_REQUEST;
	}
	@GetMapping("/district")
	public ResponseEntity<List<District>> getDistrict() {
		List<District> district = districtService.getAllDistrict();
		ResponseEntity<List<District>> response = new ResponseEntity<>(district, HttpStatus.OK);
		return response;
	}
	

	@GetMapping("/district/{id}")
	public District getOneById(@PathVariable("id") Integer id) {
		return districtService.getById(id);
	}
	
	

	@PutMapping("/district/{id}")
	public ResponseEntity<String> updateDistrict(@PathVariable(name="id") Integer id,@RequestBody DistrictData districtData){
		District district=DistrictDataMapper.districtDataMapper(districtData);
		if(districtService.editDistrict(district, id))
		{
			return new ResponseEntity<>("updated",HttpStatus.OK);
		}
		return new ResponseEntity<>("upadte failed", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/district/{id}")
	public HttpStatus deleteDistrict(@PathVariable("id") Integer id) {
		boolean test = districtService.deleteDistrict(id);
		HttpStatus status;
		if (test) {
			return HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return status;
	}


}
