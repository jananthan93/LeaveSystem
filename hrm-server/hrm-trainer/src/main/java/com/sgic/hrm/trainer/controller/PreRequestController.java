//code done by jayapriya
package com.sgic.hrm.trainer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.trainer.dto.PreRequestData;
import com.sgic.hrm.commons.trainer.dto.mapper.PreRequestDataToPreRequest;
import com.sgic.hrm.commons.trainer.entity.mapper.PreRequestToPreRequestData;
import com.sgic.hrm.trainer.service.PreRequestService;

@RestController
public class PreRequestController {
	@Autowired PreRequestService preRequestService;
	
	@PostMapping("preRequest")
	public HttpStatus addPreRequest(@RequestBody PreRequestData preRequestData) {
		if(preRequestService.addPreRequest(PreRequestDataToPreRequest.mapToPreRequest(preRequestData))) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@PutMapping("preRequest/{id}")
	public HttpStatus editPreRequest(@PathVariable Integer id,@RequestBody PreRequestData preRequestData) {
		if(preRequestService.editPreRequest(id, PreRequestDataToPreRequest.mapToPreRequest(preRequestData))) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@DeleteMapping("preRequest/{id}")
	public HttpStatus deletePreRequest(@PathVariable Integer id) {
		if(preRequestService.deletePreRequest(id)) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@GetMapping("preRequest")
	public  List<PreRequestData> getAllPreRequest(){
		return PreRequestToPreRequestData.mapToPreRequestDataList(preRequestService.getAllPreRequest());
		
	}
	
	@GetMapping("preRequest/{id}")
	public  PreRequestData getPreRequestById(@PathVariable Integer id){
		return PreRequestToPreRequestData.mapToPreRequestData(preRequestService.getPreRequestById(id));
		
	}
	
	

}
