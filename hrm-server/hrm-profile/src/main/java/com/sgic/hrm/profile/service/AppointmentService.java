package com.sgic.hrm.profile.service;

import java.util.List;
import com.sgic.hrm.commons.entity.Appointment;
import com.sgic.hrm.commons.entity.AppointmentType;
import com.sgic.hrm.commons.entity.Department;
import com.sgic.hrm.commons.entity.Designation;
import com.sgic.hrm.commons.entity.User;


public interface AppointmentService {
  boolean addAppointment(Appointment appointment, AppointmentType appointmentType, User userObj,
      Department department, Designation designation);

  List<Appointment> getAppointment();
}
