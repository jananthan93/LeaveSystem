package com.sgic.hrm.commons.entity.mapper;

import com.sgic.hrm.commons.dto.AppointmentTypeData;
import com.sgic.hrm.commons.entity.AppointmentType;

public class AppointmentTypeToAppointTypeData {

  public static AppointmentTypeData mapToAppointmentTypeData(AppointmentType appointmentType) {
    AppointmentTypeData appointmentTypeData= new AppointmentTypeData();
    
    if (appointmentType != null ) {
      appointmentTypeData.setId(appointmentType.getId());
      appointmentTypeData.setAppointmentType(appointmentType.getAppointmentType());
    }
    return appointmentTypeData;
  }
}
