package com.sgic.hrm.profile.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.hrm.commons.dto.mapper.profile.AppointmentDtoToAppointment;
import com.sgic.hrm.commons.dto.profile.AppointmentDto;
import com.sgic.hrm.commons.dto.profile.AppointmentSaveDto;
import com.sgic.hrm.commons.entity.mapper.profile.AppointmentMapper;
import com.sgic.hrm.profile.service.AppointmentService;
import com.sgic.hrm.profile.service.AppointmentTypeService;
import com.sgic.hrm.profile.service.DepartmentService;
import com.sgic.hrm.profile.service.DesignationService;
import com.sgic.hrm.profile.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class AppointmentController {
  @Autowired
  private AppointmentService appointmentService;
  @Autowired
  private UserService userService;
  @Autowired
  private AppointmentTypeService appointmentTypeService;
  @Autowired
  private DepartmentService departmentService;
  @Autowired
  private DesignationService designationService;

  @PostMapping("/appointment")
  public HttpStatus AddAppointment(@RequestBody AppointmentSaveDto appointmentSaveDto) {
    // addAppointment(appointment, appointmentTypeObj, userObj, departmentObj, designationObj)
    if (appointmentService.addAppointment(AppointmentDtoToAppointment.map(appointmentSaveDto),
        appointmentTypeService.findByAppointmentTypeId(appointmentSaveDto.getAppointmentType()),
        userService.findByUserId(appointmentSaveDto.getUser()),
        departmentService.findByDepartmentId(appointmentSaveDto.getDepartment()),
        designationService.findByDesignationId(appointmentSaveDto.getDesignation()))) {
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @GetMapping("/appointment")
  public ResponseEntity<List<AppointmentDto>> GetAppointment() {
    return new ResponseEntity<>(AppointmentMapper.mapAppointmentListToAppointmentDtoList(
        appointmentService.getAppointment()), HttpStatus.OK);
  }

}
