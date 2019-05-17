package com.sgic.hrm.lms.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.hrm.commons.dto.HolidayCalendarData;
import com.sgic.hrm.commons.dto.mapper.HolidayCalendarDataToHolidayCalendar;
import com.sgic.hrm.commons.entity.HolidayCalendar;
import com.sgic.hrm.commons.entity.mapper.HolidayCalendarToHolidayCalendarData;
import com.sgic.hrm.lms.service.HolidayCalendarService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/holidaycalendar")
public class HolidayCalendarController {

	@Autowired
	HolidayCalendarService holidayCalendarService;

	@PostMapping
	public HttpStatus createHoliday(@RequestBody HolidayCalendarData holidayCalendarData) {
	  	  
		if (holidayCalendarService.createHoliday(
				HolidayCalendarDataToHolidayCalendar.mapToHolidayCalendar(holidayCalendarData), holidayCalendarData.getPostedBy())) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping
	public ResponseEntity<List<HolidayCalendarData>> viewAllHoliday() {
		List<HolidayCalendar> holidayCalendarList = holidayCalendarService.viewAllHoliday();
		return new ResponseEntity<>(
				HolidayCalendarToHolidayCalendarData.mapToHolidayCalendarDataList(holidayCalendarList), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public HttpStatus updateHoliday(@PathVariable(name = "id") Integer id,
			@RequestBody HolidayCalendarData holidayCalendarData) {
		if (holidayCalendarService.updateHoliday(id,
				HolidayCalendarDataToHolidayCalendar.mapToHolidayCalendar(holidayCalendarData), holidayCalendarData.getPostedBy())) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteHoliday(@PathVariable(name="id")Integer id){
		if (holidayCalendarService.deleteholiday(id)){
			return  HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}

	
}
