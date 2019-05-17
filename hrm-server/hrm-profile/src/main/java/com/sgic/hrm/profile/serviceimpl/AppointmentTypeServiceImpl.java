package com.sgic.hrm.profile.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.AppointmentType;
import com.sgic.hrm.commons.repository.AppointmentTypeRepository;
import com.sgic.hrm.profile.service.AppointmentTypeService;


@Service
public class AppointmentTypeServiceImpl implements AppointmentTypeService {
  @Autowired
  private AppointmentTypeRepository appointmentTypeRepository;

  @Override
  public boolean addAppointmentType(AppointmentType appointmentType) {
    appointmentTypeRepository.save(appointmentType);
    return true;
  }

  @Override
  public List<AppointmentType> getAppointmentType() {
    return appointmentTypeRepository.findAll();
  }

  @Override
  public AppointmentType findByAppointmentTypeId(Integer id) {
    return appointmentTypeRepository.findAppointmentTypeById(id);
  }

  @Override
  public boolean editAppointmentType(AppointmentType appointmentType, Integer id) {
    boolean editSucess = false;
    if (appointmentTypeRepository.getOne(id) != null) {
      appointmentType.setId(id);
      appointmentTypeRepository.save(appointmentType);
      editSucess = true;
    }
    return editSucess;
  }

  @Override
  public boolean deleteAppointmentType(Integer id) {
    AppointmentType appointmentType = appointmentTypeRepository.getOne(id);
    if (appointmentType.getId() == id) {
      appointmentTypeRepository.deleteById(id);
      return true;
    }
    return false;
  }


}
