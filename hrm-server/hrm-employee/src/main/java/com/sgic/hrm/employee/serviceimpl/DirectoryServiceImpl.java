package com.sgic.hrm.employee.serviceimpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.Appointment;
import com.sgic.hrm.commons.entity.User;
import com.sgic.hrm.commons.repository.AppointmentRepository;
import com.sgic.hrm.commons.repository.UserRepository;
import com.sgic.hrm.employee.service.DirectoryService;

@Service
public class DirectoryServiceImpl implements DirectoryService {

	@Autowired
	private AppointmentRepository appointmentRepository;


	@Override
	public List<Appointment> getUserByDesignationName(String designation) {
		List<Appointment> apppointmentList = appointmentRepository.findAllUsersByDesignation(designation);
		return apppointmentList;
	}

	@Override
	public List<Appointment> getUserByFullName(String name) {
		List<Appointment> apppointmentList = appointmentRepository.findAllUsersByName(name);
		return apppointmentList;
	}

	@Override
	public List<Appointment> getUserByAppoinmentDateAndName(Date date, String name) {
		List<Appointment> apppointmentList = appointmentRepository.findAllUsersByAppointmentDatenAndName(date, name);
		return apppointmentList;
	}

	@Override
	public List<Appointment> getUserByDesignationNameAndName(String designation, String name) {
		List<Appointment> apppointmentList = appointmentRepository.findAllUsersByDesignationAndName(designation, name);
		return apppointmentList;
	}

	@Override
	public List<Appointment> getUserByDesignationNameAndAppointmentDate(String designation, Date date) {
		List<Appointment> apppointmentList = appointmentRepository.findAllUsersByDesignationAndAppointmentDate(designation , date);
		return apppointmentList;
	}

	@Override
	public List<Appointment> getUserByAllThreeFeilds(String name, Date date, String designation) {
		List<Appointment> apppointmentList = appointmentRepository.findAllUsersByAppointmentDatenAndNameAndDesignation(date, name, designation);
		return apppointmentList;
	}

	@Override
	public List<Appointment> getUserByAppoinmentDate(Date date) {
		List<Appointment> apppointmentList = appointmentRepository.findUsersByAppointmentDate(date);
		return apppointmentList;
	}

}
