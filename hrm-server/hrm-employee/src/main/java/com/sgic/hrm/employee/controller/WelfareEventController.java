/**
 * 
 */
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

import com.sgic.hrm.commons.dto.WelfareEventDto;
import com.sgic.hrm.commons.dto.mapper.WelfareEventDtoToWelfareEvent;
import com.sgic.hrm.commons.entity.WelfareEvent;
import com.sgic.hrm.commons.entity.mapper.WelfareEventToWelfareEventDto;
import com.sgic.hrm.employee.service.WelfareEventService;

/**
 * @author
 *
 */
@CrossOrigin(origins = "http://localhost:4200",maxAge=3600)
@RestController
public class WelfareEventController {
	@Autowired
	private WelfareEventService welfareEventService;

	@PostMapping("/welfareEvent")
	public HttpStatus createWelfareEvent(@RequestBody WelfareEventDto welfareEventDto) {
		WelfareEvent welfareEvent = WelfareEventDtoToWelfareEvent.WelfareEventDtoToWelfareEvent(welfareEventDto);
		if (welfareEventService.addWelfareEvent(welfareEvent)) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/welfareEvent")
	public ResponseEntity<List<WelfareEventDto>> getWelfareEvent() {
		List<WelfareEvent> welfareEventList = welfareEventService.getAllWelfareEvent();
		return new ResponseEntity<>(WelfareEventToWelfareEventDto.WelfareEventToWelfareEventDto(welfareEventList),
				HttpStatus.OK);
	}

	@GetMapping("/welfareEvent/{id}")
	public ResponseEntity<WelfareEventDto> getOneWelfareEvent(@PathVariable(name = "id") Integer id) {
		WelfareEvent welfareEvent = welfareEventService.getOneWelfareEvent(id);
		return new ResponseEntity<>(WelfareEventToWelfareEventDto.WelfareEventToWelfareEventDto(welfareEvent),
				HttpStatus.OK);
	}

	@PutMapping("/welfareEvent/{id}")
	public HttpStatus updateWelfareEvent(@PathVariable(name = "id") Integer id,
			@RequestBody WelfareEventDto welfareEventDto) {
		WelfareEvent welfareEvent = WelfareEventDtoToWelfareEvent.WelfareEventDtoToWelfareEvent(welfareEventDto);
		if (welfareEventService.updateWelfareEvent(id, welfareEvent)) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@DeleteMapping("/welfareEvent/{id}")
	public HttpStatus deleteWelfareEvent(@PathVariable(name = "id") Integer id) {
		if (welfareEventService.deleteWelfareEvent(id)) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}

}
