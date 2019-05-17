package com.sgic.hrm.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.hrm.commons.entity.RejectExperienceLetterRequest;
import com.sgic.hrm.employee.service.RejectExperienceLetterRequestService;

@RestController
@RequestMapping("/reject-request")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3200)
public class RejectExperienceLetterRequestController {

  @Autowired
  private RejectExperienceLetterRequestService rejectExperienceLetterRequestService;
  
  @GetMapping
  public List<RejectExperienceLetterRequest> getRejectExperienceLetterRequest(){
      return rejectExperienceLetterRequestService.getRejectExperienceLetterRequest();
  } 

  @PostMapping
  public void postRejectExperienceLetterRequest(@RequestBody RejectExperienceLetterRequest rejectExperienceLetterRequest) {
    rejectExperienceLetterRequestService.createRejectExperienceLetterRequest(rejectExperienceLetterRequest);
  }

  @PutMapping("/{id}")
  public void editRejectExperienceLetterRequest(@RequestBody RejectExperienceLetterRequest rejectExperienceLetterRequest, @PathVariable Integer id) {
    rejectExperienceLetterRequestService.updateRejectExperienceLetterRequest(rejectExperienceLetterRequest, id);
  }
  
}
