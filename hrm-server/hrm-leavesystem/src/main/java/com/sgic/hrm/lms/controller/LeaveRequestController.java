package com.sgic.hrm.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.AcceptLeaveDto;
import com.sgic.hrm.commons.dto.LeaveRequestData;
import com.sgic.hrm.commons.dto.RejectLeaveDto;
import com.sgic.hrm.commons.dto.mapper.LeaveRequestDataToLeaveRequest;
import com.sgic.hrm.commons.entity.mapper.LeaveRequestToLeaveRequestData;
import com.sgic.hrm.commons.enums.Status;
import com.sgic.hrm.lms.service.LeaveRequestService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/leaverequest")
public class LeaveRequestController {

  @Autowired
  LeaveRequestService leaveRequestService;

  @GetMapping
  public ResponseEntity<List<LeaveRequestData>> getAllLeaveRequest() {
    return new ResponseEntity<>(LeaveRequestToLeaveRequestData
        .mapLeaveRequestDataList(leaveRequestService.getAllLeaveRequest()), HttpStatus.OK);
  }

  @PostMapping("/{userName}")
  public HttpStatus addLeaveRequest(@RequestBody LeaveRequestData leaveRequestData,
      @PathVariable(name = "userName") String userName) {

    if (leaveRequestService.addLeaveRequest(
        LeaveRequestDataToLeaveRequest.mapToLeaveRequest(leaveRequestData), userName)) {
      return HttpStatus.OK;
    }
    return HttpStatus.BAD_REQUEST;
  }
  
  @GetMapping("/{userName}")
  public ResponseEntity<List<LeaveRequestData>> getAllLeaveRequestByUserName(
      @PathVariable(name = "userName") String userName) {
    return new ResponseEntity<>(LeaveRequestToLeaveRequestData
        .mapLeaveRequestDataList(leaveRequestService.getLeaveRequestByUserName(userName)), HttpStatus.OK);
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<List<LeaveRequestData>> getAllLeaveRequestByUser(
      @PathVariable("id") Integer id) {
    return new ResponseEntity<>(LeaveRequestToLeaveRequestData
        .mapLeaveRequestDataList(leaveRequestService.getLeaveRequestByUser(id)), HttpStatus.OK);
  }

  @GetMapping("/pending/{userName}")
  public ResponseEntity<List<LeaveRequestData>> getPendingLeaveRequest(@PathVariable("userName") String userName) {
	  return new ResponseEntity<>(LeaveRequestToLeaveRequestData
	        .mapLeaveRequestDataList(leaveRequestService.getLeaveRequestByUserNot(userName)), HttpStatus.OK);
  }
  
  

  @DeleteMapping("/{id}")
  public HttpStatus deleteLeaveRequest(@PathVariable("id") Integer id) {
    if (leaveRequestService.deleteLeaveRequest(id)) {
      return HttpStatus.OK;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @Transactional
  @PostMapping("/accept")
  public HttpStatus acceptLeaveRequest(@RequestBody AcceptLeaveDto acceptLeaveDto) {

    if (leaveRequestService.acceptLeaveRequest(acceptLeaveDto)) {
      return HttpStatus.OK;
    }
    return HttpStatus.BAD_REQUEST;
  }


  @PostMapping("/reject")
  public HttpStatus rejectLeaveRequest(@RequestBody RejectLeaveDto rejectLeaveDto) {

    if (leaveRequestService.rejectLeaveRequest(rejectLeaveDto)) {
      return HttpStatus.OK;
    }
    return HttpStatus.BAD_REQUEST;
  }
}
