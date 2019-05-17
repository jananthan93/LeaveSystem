package com.sgic.hrm.lms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.hrm.commons.dto.RejectLeaveRequestData;
import com.sgic.hrm.commons.entity.mapper.RejectLeaveRequestToRejectLeaveRequestData;
import com.sgic.hrm.lms.service.RejectLeaveRequestService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/reject")
@RestController
public class RejectLeaveRequestController {

  @Autowired
  RejectLeaveRequestService rejectLeaveRequestService;

  @GetMapping
  public List<RejectLeaveRequestData> getAllRejectedLeaveRequests() {
    return RejectLeaveRequestToRejectLeaveRequestData
        .mapToRejectLeaveRequestDataList(rejectLeaveRequestService.getAllRejectLeaveRequest());
  }
}
