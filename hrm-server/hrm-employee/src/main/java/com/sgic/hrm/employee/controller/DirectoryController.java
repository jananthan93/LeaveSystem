//package com.sgic.hrm.employee.controller;
//
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sgic.hrm.commons.dto.DirectoryDto;
//import com.sgic.hrm.commons.dto.DirectorySearchDto;
//import com.sgic.hrm.commons.dto.mapper.EntityToDirectoryDto;
//import com.sgic.hrm.commons.entity.Appointment;
//import com.sgic.hrm.employee.service.DirectoryService;
//import com.sgic.hrm.profile.service.AppointmentService;
//
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
//@RestController
//public class DirectoryController {
//
//	@Autowired
//	private AppointmentService appointmentService;
//
//	@Autowired
//	private DirectoryService directoryService;
//
//	@GetMapping("/directory")
//	public List<DirectoryDto> getAllUserDetails() {
//		List<DirectoryDto> userDtoList = new ArrayList<>();
//		for (Appointment apt : appointmentService.getAppointment()) {
//			DirectoryDto userDto = EntityToDirectoryDto.entityToUserDtoMapping(apt);
//			userDtoList.add(userDto);
//		}
//		return userDtoList;
//	}
//
//	@PostMapping("/directory")
//	public List<DirectoryDto> getUsersByFullName(@RequestBody DirectorySearchDto directorySearchDto) {
//
//		String name = directorySearchDto.getFullName();
//		String designation = directorySearchDto.getDesignation();
//		Date date = directorySearchDto.getAppointmentDate();
//
//		List<DirectoryDto> userDtoList = new ArrayList<>();
//		List<Appointment> appointments = new ArrayList<>();
//
//		if (name == null && designation == null && date == null) {
//			appointments =  appointmentService.getAppointment();
//		} else if (name != null && designation == null && date == null) {
//			appointments = directoryService.getUserByFullName(name);
//		} else if (name == null && designation != null && date == null) {
//			appointments = directoryService.getUserByDesignationName(designation);
//		} else if (name == null && designation == null && date != null) {
//			appointments = directoryService.getUserByAppoinmentDate(date);
//		} else if (name != null && designation != null && date == null) {
//			appointments = directoryService.getUserByDesignationNameAndName(designation, name);
//		} else if (name != null && designation == null && date != null) {
//			appointments = directoryService.getUserByAppoinmentDateAndName(date, name);
//		} else if (name == null && designation != null && date != null) {
//			appointments = directoryService.getUserByDesignationNameAndAppointmentDate(designation, date);
//		} else if (name != null && designation != null && date != null) {
//			appointments = directoryService.getUserByAllThreeFeilds(name, date, designation);
//		}
//
//		for (Appointment apnmnt : appointments) {
//			DirectoryDto userDto = EntityToDirectoryDto.entityToUserDtoMapping(apnmnt);
//			userDtoList.add(userDto);
//		}
//		
//		return  userDtoList;
//
//	}
//
//}
