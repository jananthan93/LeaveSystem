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
import com.sgic.hrm.commons.dto.SelfServiceTypeDto;
import com.sgic.hrm.commons.dto.mapper.SelfServiceTypeDtoMapper;
import com.sgic.hrm.commons.entity.mapper.SelfServiceTypeMapper;
import com.sgic.hrm.employee.service.SelfServiceTypeService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3200)
@RestController
public class SelfServiceTypeController {
	@Autowired
	private SelfServiceTypeService selfServiceTypeService;

	@GetMapping("/selfservicetype")
	public ResponseEntity<List<SelfServiceTypeDto>> viewSelfServiceType() {
		List<SelfServiceTypeDto> selfServiceTypeDto = SelfServiceTypeMapper.mapSelfServiceTypeListToSelfServiceTypeDtoList(selfServiceTypeService.viewSelfServiceType());
		return new ResponseEntity<>(selfServiceTypeDto, HttpStatus.OK);
	}

	@PostMapping("/selfservicetype")
	public HttpStatus addSelfServiceType(@RequestBody SelfServiceTypeDto selfServiceTypeDto) {
		boolean test = selfServiceTypeService.addSelfServiceType(SelfServiceTypeDtoMapper.mapSelfServiceTypeDtoToSelfServiceType(selfServiceTypeDto));
		if (test) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PutMapping("/selfservicetype/{id}")
	public HttpStatus modifySelfServiceType(@PathVariable Integer id, @RequestBody SelfServiceTypeDto selfServiceTypeDto) {
		boolean test = selfServiceTypeService.editSelfServiceType(SelfServiceTypeDtoMapper.mapSelfServiceTypeDtoToSelfServiceType(selfServiceTypeDto), id);
		if (test) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@DeleteMapping("/selfservicetype/{id}")
	public HttpStatus meleteSelfServiceType(@PathVariable Integer id) {
	  boolean selfServiceType = selfServiceTypeService.deleteSelfServiceType(id);
	  if(selfServiceType) {
	    return HttpStatus.OK;
	  }
    return HttpStatus.BAD_REQUEST;	  
	}
}
