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

import com.sgic.hrm.commons.dto.RequestPromotionData;
import com.sgic.hrm.commons.dto.RequestPromotionSaveData;
import com.sgic.hrm.commons.dto.mapper.RequestPromotionDataMapper;
import com.sgic.hrm.commons.entity.RequestPromotion;
import com.sgic.hrm.commons.entity.mapper.RequestPromotionMapper;
import com.sgic.hrm.employee.service.RequestPromotionService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class RequestPromotionController {
	@Autowired
	private RequestPromotionService requestPromotionService;
	
	@GetMapping("/requestpromotion")
	public ResponseEntity<List<RequestPromotionData>> getAllRequestPromotions() {
		return new ResponseEntity<>(RequestPromotionMapper.mapToRequestPromotionDataList
				(requestPromotionService.getAllRequestPromotion()), HttpStatus.OK);
	}
	
	

	@PostMapping("/requestpromotion")
	public ResponseEntity<String> addRequestPromotion(@RequestBody RequestPromotionData requestPromotionData) {
		if(requestPromotionService.addRequestPromotion(RequestPromotionDataMapper.mapToRequestPromotion(requestPromotionData))) {
			return new ResponseEntity<>("Success",HttpStatus.OK);
		}
		return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/requestpromotionsave")
	public HttpStatus postRequestPromotion(@RequestBody RequestPromotionSaveData requestPromotionSaveData) {

		boolean test = requestPromotionService.addRequestPromotion(
				RequestPromotionDataMapper.mapRequestPromotionSaveDataToRequestPromotion(requestPromotionSaveData));
		if (test) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@PutMapping("/requestpromotion/{id}")
	public ResponseEntity<String> updateRequestPromotion(@PathVariable(name="id") Integer id, @RequestBody RequestPromotionData requestPromotionData) {
		boolean reqPro = requestPromotionService.updateRequestPromotion(RequestPromotionDataMapper.mapToRequestPromotion(requestPromotionData),id);
		
		if (reqPro) {
			return new ResponseEntity<>("Update Successfully",HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("Update failed",HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/requestpromotion/{id}")
	public ResponseEntity<String> deleteRequestPromotion(@PathVariable("id") Integer id) {
		boolean reqPro = requestPromotionService.deleteRequstPromotion(id);
		if (reqPro) {
			return new ResponseEntity<>("Deleted" ,HttpStatus.OK);
		}
		return new ResponseEntity<>("Deleted" ,HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/requestpromotion/{id}")
	public List<RequestPromotion> getAllRequestPromotionsByUserId(@PathVariable int id) {
		return requestPromotionService.getPromotionByUserId(id);
	}
	
}