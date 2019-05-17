/**
 * 
 */
package com.sgic.hrm.lms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.hrm.commons.dto.AcceptCancelRequestDto;
import com.sgic.hrm.commons.dto.CancelLeaveRequestData;
import com.sgic.hrm.commons.dto.RejectCancelRequestDto;
import com.sgic.hrm.commons.dto.mapper.CancelLeaveRequestDataToCancelLeaveRequest;
import com.sgic.hrm.commons.entity.mapper.CancelLeaveRequestToCancelLeaveRequestData;
import com.sgic.hrm.lms.service.CancelLeaveRequestService;

/**
 * @author Anushanth
 *
 */

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/cancel")
public class CancelLeaveRequestController {

  @Autowired
  CancelLeaveRequestService cancelLeaveRequestService;

  @GetMapping
  public List<CancelLeaveRequestData> getCancelLeaveRequest() {
    return CancelLeaveRequestToCancelLeaveRequestData
        .mapToCancelLeaveRequestData(cancelLeaveRequestService.getAllCancelRequest());
  }

  @GetMapping("/pending")
  public List<CancelLeaveRequestData> getPendingCancelLeaveRequest() {
    return CancelLeaveRequestToCancelLeaveRequestData
        .mapToCancelLeaveRequestData(cancelLeaveRequestService.getPendingCancelRequest());
  }

  @PostMapping
  public HttpStatus addCancelLeaveRequest(
      @RequestBody CancelLeaveRequestData cancelLeaveRequestData) {

    if (cancelLeaveRequestService.addCancelLeaveRequest(CancelLeaveRequestDataToCancelLeaveRequest
        .mapToCancelLeaveRequest(cancelLeaveRequestData))) {
      return HttpStatus.OK;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @PostMapping("/accept")
  public HttpStatus acceptCancelLeaveRequest(
      @RequestBody AcceptCancelRequestDto acceptCancelRequestDto) {

    if (cancelLeaveRequestService.acceptCancelLeaveRequest(acceptCancelRequestDto)) {
      return HttpStatus.OK;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @PostMapping("/reject")
  public HttpStatus rejectCancelLeaveRequest(
      @RequestBody RejectCancelRequestDto rejectCancelRequestDto) {

    if (cancelLeaveRequestService.rejectCancelLeaveRequest(rejectCancelRequestDto)) {
      return HttpStatus.OK;
    }
    return HttpStatus.BAD_REQUEST;
  }
}
