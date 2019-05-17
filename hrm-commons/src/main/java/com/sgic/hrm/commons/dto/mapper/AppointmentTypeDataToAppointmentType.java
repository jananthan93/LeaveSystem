package com.sgic.hrm.commons.dto.mapper;

import com.sgic.hrm.commons.dto.AppointmentTypeData;
import com.sgic.hrm.commons.entity.AppointmentType;

public class AppointmentTypeDataToAppointmentType {

  public static AppointmentType mapToAppointmentType(AppointmentTypeData appointmentTypeData) {
    AppointmentType appointmentType = new AppointmentType();
    
    if (appointmentTypeData != null) {
      appointmentType.setId(appointmentTypeData.getId());
      appointmentType.setAppointmentTypeName(appointmentTypeData.getAppointmentType());
      
    }
    return appointmentType;
  }
}
