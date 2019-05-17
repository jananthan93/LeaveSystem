package com.sgic.hrm.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.WelfareTypeDto;
import com.sgic.hrm.commons.dto.mapper.WelfareTypeDtoToWelfareType;
import com.sgic.hrm.commons.entity.WelfareType;
import com.sgic.hrm.commons.entity.mapper.WelfareTypeToWelfareTypeDto;
import com.sgic.hrm.employee.service.WelfareTypeService;

@RestController
public class WelfareTypeController {
	@Autowired
	private WelfareTypeService welfareTypeService;

	@PostMapping("/welfaretype")
	public ResponseEntity<String> createWelfareType(@RequestBody WelfareTypeDto welfareTypeDto) {
		WelfareType welfareType = WelfareTypeDtoToWelfareType.WelfareTypeDtoToWelfareType(welfareTypeDto);
		if (welfareTypeService.addWelfareType(welfareType)) {
			return new ResponseEntity<>("welfareType added succesfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("welfareType adding failed", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/welfaretype")
	public ResponseEntity<List<WelfareTypeDto>> getAllWelfareType() {
	  List<WelfareType> welfareList = welfareTypeService.getAllWelfareType();
	  return new ResponseEntity<>(WelfareTypeToWelfareTypeDto.WelfareTypeToWelfareTypeDto(welfareList), HttpStatus.OK);
	}
	 @GetMapping("/welfaretype/{id}")
	  public ResponseEntity<WelfareTypeDto> getOneWelfareType(@PathVariable(name = "id") Integer id) {
		 WelfareType welfareType = welfareTypeService.getOneWelfareType(id);
	    return new ResponseEntity<>(WelfareTypeToWelfareTypeDto.WelfareTypeToWelfareTypeDto(welfareType), HttpStatus.OK);
	  }
	 
	 @PutMapping("/welfaretype/{id}")
	  public ResponseEntity<String> updateWelfareType(@PathVariable(name = "id") Integer id,
	      @RequestBody WelfareTypeDto welfareTypeDto) {
		 WelfareType welfareType = WelfareTypeDtoToWelfareType.WelfareTypeDtoToWelfareType(welfareTypeDto);
	    if (welfareTypeService.updateWelfareType(id, welfareType)) {
	      return new ResponseEntity<>("welfareType updated succesfully", HttpStatus.OK);
	    }
	    return new ResponseEntity<>("welfareType update failed", HttpStatus.BAD_REQUEST);
	  }
	 @DeleteMapping("/welfaretype/{id}")
	  public ResponseEntity<String> deleteWelfareType(@PathVariable(name = "id") Integer id) {
	    if (welfareTypeService.deleteWelfareType(id)) {
	      return new ResponseEntity<>("welfareType deleted succesfully", HttpStatus.OK);
	    }
	    return new ResponseEntity<>("failed to delete the welfareType", HttpStatus.BAD_REQUEST);
	  }
 
}