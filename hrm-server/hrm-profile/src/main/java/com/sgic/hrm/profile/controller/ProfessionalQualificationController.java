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
import com.sgic.hrm.commons.dto.mapper.profile.ProfessionalQualificationDtoToProfessionalQualification;
import com.sgic.hrm.commons.dto.profile.ProfessionalQualificationDto;
import com.sgic.hrm.commons.dto.profile.ProfessionalQualificationSaveDto;
import com.sgic.hrm.commons.entity.mapper.profile.ProfessionalQualificationMapper;
import com.sgic.hrm.profile.service.ProfessionalQualificationService;
import com.sgic.hrm.profile.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ProfessionalQualificationController {

  @Autowired
  private ProfessionalQualificationService professionalQualificationService;

  @Autowired
  private UserService userService;

  @PostMapping("/professionalQualification")
  public HttpStatus addProfessionalQualification(
      @Valid @RequestBody ProfessionalQualificationSaveDto professionalQualificationSaveDto) {
    if (professionalQualificationService.addProfessionalQualification(
        ProfessionalQualificationDtoToProfessionalQualification
            .map(professionalQualificationSaveDto),
        userService.findByUserId(professionalQualificationSaveDto.getUser()))) {
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @PutMapping("/professionalQualification/edit/{id}")
  public HttpStatus modifyProfessionalQualification(@PathVariable Integer id,
      @RequestBody ProfessionalQualificationSaveDto professionalQualificationSaveDto) {
    if (professionalQualificationService.editProfessionalQualification(
        ProfessionalQualificationDtoToProfessionalQualification
            .map(professionalQualificationSaveDto),
        userService.findByUserId(professionalQualificationSaveDto.getUser()), id)) {
      return HttpStatus.ACCEPTED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @GetMapping("/professionalQualification")
  public ResponseEntity<List<ProfessionalQualificationDto>> getProfessionalQualification() {
    return new ResponseEntity<>(
        ProfessionalQualificationMapper
            .mapProfessionalQualificationListToProfessionalQualificationDtoList(
                professionalQualificationService.getAllProfessionalQualifications()),
        HttpStatus.OK);
  }

  @GetMapping("/professionalQualification/{uid}")
  public ResponseEntity<List<ProfessionalQualificationDto>> findProfessionalQualificationByUserId(
      @PathVariable("uid") Integer id) {
    return new ResponseEntity<>(
        ProfessionalQualificationMapper
            .mapProfessionalQualificationListToProfessionalQualificationDtoList(
                professionalQualificationService.getProfessionalQualificationByUserId(id)),
        HttpStatus.OK);
  }

  @DeleteMapping("/professionalQualification/{id}")
  public HttpStatus deleteProfessionalQualification(@PathVariable Integer id) {
    if (professionalQualificationService.deleteProfessionalQualification(id)) {
      return HttpStatus.ACCEPTED;
    }
    return HttpStatus.BAD_REQUEST;
  }

}
