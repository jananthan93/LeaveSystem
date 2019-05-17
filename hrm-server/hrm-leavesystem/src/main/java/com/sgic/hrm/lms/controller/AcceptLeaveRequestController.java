package com.sgic.hrm.lms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.hrm.commons.dto.AcceptLeaveRequestData;
import com.sgic.hrm.commons.entity.mapper.AcceptLeaveRequestToAcceptLeaveRequestData;
import com.sgic.hrm.lms.service.AcceptLeaveRequestService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/accept")
public class AcceptLeaveRequestController {

  @Autowired
  AcceptLeaveRequestService acceptLeaveRequestService;

  @GetMapping
  public List<AcceptLeaveRequestData> getAllAcceptRequest() {
    return AcceptLeaveRequestToAcceptLeaveRequestData
        .mapToAcceptLeaveRequestData(acceptLeaveRequestService.getAllAcceptLeaveRequests());
  }
}
