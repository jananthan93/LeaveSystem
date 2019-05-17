package com.sgic.hrm.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.ResponseDto;
import com.sgic.hrm.commons.dto.mapper.ResponseDtoMapper;
import com.sgic.hrm.commons.entity.Response;
import com.sgic.hrm.employee.service.ResponseService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3200)
@RestController
public class ResponseController {
	@Autowired
	private ResponseService responseService;

	@GetMapping("/response")
	public ResponseEntity<List<Response>> viewResponse() {
		List<Response> response = responseService.viewResponse();
		ResponseEntity<List<Response>> responses = new ResponseEntity<>(response, HttpStatus.OK);
		return responses;
	}

	@PostMapping("/response")
	public HttpStatus addResponse(@RequestBody ResponseDto responseDto) {
		boolean test = responseService.addResponse(ResponseDtoMapper.mapResponseDtoJsonToResponseJson(responseDto));
		if (test) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/responses/{username}")
	public List<Response> viewComplainByUserResponse(@PathVariable String username) {
		return responseService.getSpecificUser(username);
	}
}
