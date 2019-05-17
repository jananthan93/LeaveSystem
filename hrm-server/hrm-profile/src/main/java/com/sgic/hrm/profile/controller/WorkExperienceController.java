package com.sgic.hrm.profile.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.hrm.commons.dto.mapper.profile.WorkExperienceDTOToWorkExperience;
import com.sgic.hrm.commons.dto.profile.WorkExperienceDto;
import com.sgic.hrm.commons.dto.profile.WorkExperienceSaveDto;
import com.sgic.hrm.commons.entity.mapper.profile.WorkExperienceMapper;
import com.sgic.hrm.profile.service.UserService;
import com.sgic.hrm.profile.service.WorkExperienceService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class WorkExperienceController {
  @Autowired
  private WorkExperienceService workExperienceService;

  @Autowired
  private UserService userService;

  @PostMapping("/workexperience")
  public HttpStatus addWorkExperience(
      @Valid @RequestBody WorkExperienceSaveDto workExperienceSaveDto) {
    if (workExperienceService.addWorkExperience(
        WorkExperienceDTOToWorkExperience.map(workExperienceSaveDto),
        userService.findByUserId(workExperienceSaveDto.getUser()))) {
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @PutMapping("/workexperience/edit/{id}")
  public HttpStatus modifyworkexperience(@PathVariable Integer id,
      @RequestBody WorkExperienceSaveDto workExperienceSaveDto) {
    if (workExperienceService.editWorkExperience(
        WorkExperienceDTOToWorkExperience.map(workExperienceSaveDto),
        userService.findByUserId(workExperienceSaveDto.getUser()), id)) {
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @GetMapping("/workexperience")
  public ResponseEntity<List<WorkExperienceDto>> getWorkExperience() {
    return new ResponseEntity<>(WorkExperienceMapper.mapWorkExperienceListToWorkExperienceDtoList(
        workExperienceService.getAllWorkExperience()), HttpStatus.OK);
  }

  @GetMapping("/workexperience/{uid}")
  public ResponseEntity<List<WorkExperienceDto>> getworkExperiencesByUserId(
      @PathVariable("uid") Integer id) {
    return new ResponseEntity<>(WorkExperienceMapper.mapWorkExperienceListToWorkExperienceDtoList(
        workExperienceService.getWorkExperienceByUserId(id)), HttpStatus.OK);
  }

  @DeleteMapping("/workexperience/{id}")
  public HttpStatus deleteWorkexperience(@PathVariable Integer id) {
    if (workExperienceService.deleteWorkExperience(id)) {
      return HttpStatus.ACCEPTED;
    }
    return HttpStatus.BAD_REQUEST;
  }

}
