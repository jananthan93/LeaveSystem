package com.sgic.hrm.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.hrm.commons.dto.RequestExperienceLetterDto;
import com.sgic.hrm.commons.dto.RequestExperienceLetterGetDto;
import com.sgic.hrm.commons.dto.mapper.RequestExperienceLetterDtoMapper;
import com.sgic.hrm.commons.entity.RequestExperienceLetter;
import com.sgic.hrm.commons.entity.mapper.RequestExperienceLetterMapper;
import com.sgic.hrm.employee.service.RequestExperienceLetterService;

@RestController
@RequestMapping("/requestexpletter")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3200)
public class RequestExperienceLetterController {

  @Autowired
  private RequestExperienceLetterService requestExperienceLetterService;

  @GetMapping
  public List<RequestExperienceLetterGetDto> viewAllExperienceLetterRequest() {
    return RequestExperienceLetterMapper.mapRequestExperienceLetterList(
        requestExperienceLetterService.getAllExperienceLetterRequest());
  }

  @PostMapping
  public ResponseEntity<String> saveExperienceLetterRequest(
      @RequestBody RequestExperienceLetterDto requestExperienceLetterDto) {
    if (requestExperienceLetterService.addExperienceLetterRequest(
        RequestExperienceLetterDtoMapper.mapRequestExperienceLetter(requestExperienceLetterDto))) {
      return new ResponseEntity<>("Experience Letter Request Success", HttpStatus.CREATED);
    }
    return new ResponseEntity<>("Experience Letter Request Failed", HttpStatus.BAD_REQUEST);
  }
  
  @PutMapping("/{id}")
  public boolean editExperienceLetterRequest(@RequestBody RequestExperienceLetter requestExperienceLetter, @PathVariable Integer id) {
     return requestExperienceLetterService.updateExperienceLetterRequest(requestExperienceLetter, id);
  }

}
