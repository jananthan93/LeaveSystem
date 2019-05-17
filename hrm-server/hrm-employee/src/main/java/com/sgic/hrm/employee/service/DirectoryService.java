package com.sgic.hrm.employee.service;

import java.sql.Date;
import java.util.List;

import com.sgic.hrm.commons.dto.DirectoryDto;
import com.sgic.hrm.commons.entity.Appointment;
import com.sgic.hrm.commons.entity.User;

public interface DirectoryService {

	List<Appointment> getUserByAppoinmentDate(Date date);
	List<Appointment> getUserByDesignationName(String designation);
	List<Appointment> getUserByFullName(String name);
	
	List<Appointment> getUserByDesignationNameAndName(String designation, String name);
	List<Appointment> getUserByDesignationNameAndAppointmentDate(String designation,Date date);
	List<Appointment> getUserByAllThreeFeilds(String name,Date date,String designation);
	List<Appointment> getUserByAppoinmentDateAndName(Date date, String name);	
}
