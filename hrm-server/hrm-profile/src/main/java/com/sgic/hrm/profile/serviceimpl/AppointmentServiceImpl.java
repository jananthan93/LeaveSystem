package com.sgic.hrm.profile.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.Appointment;
import com.sgic.hrm.commons.entity.AppointmentType;
import com.sgic.hrm.commons.entity.Department;
import com.sgic.hrm.commons.entity.Designation;
import com.sgic.hrm.commons.entity.User;
import com.sgic.hrm.commons.repository.AppointmentRepository;
import com.sgic.hrm.profile.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
  @Autowired
  private AppointmentRepository appointmentRepository;


  @Override
  public boolean addAppointment(Appointment appointment, AppointmentType appointmentType, User user,
      Department department, Designation designation) {
    appointment.setUser(user);
    appointment.setAppointmentTypeId(appointmentType);
    appointment.setDesignationId(designation);
    appointment.setDepartmentId(department);
    appointmentRepository.save(appointment);
    return true;
  }

  @Override
  public List<Appointment> getAppointment() {
    return appointmentRepository.findAll();
  }

}
