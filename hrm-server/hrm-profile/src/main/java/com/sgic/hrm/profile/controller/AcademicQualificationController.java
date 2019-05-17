
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
import com.sgic.hrm.commons.dto.mapper.profile.AcademicQualificationDTOToAcademicQualification;
import com.sgic.hrm.commons.dto.profile.AcademicQualificationDto;
import com.sgic.hrm.commons.dto.profile.AcademicQualificationSaveDto;
import com.sgic.hrm.commons.entity.mapper.profile.AcademicQualificationMapper;
import com.sgic.hrm.profile.service.AcademicQualificationService;
import com.sgic.hrm.profile.service.ExamTypeService;
import com.sgic.hrm.profile.service.UserService;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class AcademicQualificationController {
  @Autowired
  private AcademicQualificationService academicQualificationService;
  @Autowired
  private UserService userService;
  @Autowired
  private ExamTypeService examTypeService;

  @PostMapping("/academicQualification")
  public HttpStatus addAcademicQualification(
      @Valid @RequestBody AcademicQualificationSaveDto academicQualificationSaveDto) {
    if (academicQualificationService.addAcademicQualification(
        AcademicQualificationDTOToAcademicQualification.map(academicQualificationSaveDto),
        examTypeService.findByExamTypeId(academicQualificationSaveDto.getExamType()),
        userService.findByUserId(academicQualificationSaveDto.getUser()))) {
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @GetMapping("/academicQualification")
  public ResponseEntity<List<AcademicQualificationDto>> getAcademicQualification() {
    return new ResponseEntity<>(
        AcademicQualificationMapper.mapAcademicQualificationListToAcademicQualificationDtoList(
            academicQualificationService.getAllAcademicQualification()),
        HttpStatus.OK);

  }

  @GetMapping("/academicQualification/{uid}")
  public ResponseEntity<List<AcademicQualificationDto>> findAcademicQualificationByUserId(
      @PathVariable("uid") Integer id) {
    return new ResponseEntity<>(
        AcademicQualificationMapper.mapAcademicQualificationListToAcademicQualificationDtoList(
            academicQualificationService.getAcademicQualificationByUserId(id)),
        HttpStatus.OK);
  }


  @PutMapping("/academicQualification/edit/{id}")
  public HttpStatus editAcademicQualification(@PathVariable Integer id,
      @Valid @RequestBody AcademicQualificationSaveDto academicQualificationSaveDto) {
    if (academicQualificationService.editAcademicQualification(
        AcademicQualificationDTOToAcademicQualification.map(academicQualificationSaveDto),
        examTypeService.findByExamTypeId(academicQualificationSaveDto.getExamType()),
        userService.findByUserId(academicQualificationSaveDto.getUser()), id)) {
      return HttpStatus.ACCEPTED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @DeleteMapping("/academicQualification/{id}")
  public HttpStatus deleteAcademicQualification(@PathVariable Integer id) {
    if (academicQualificationService.deleteAcademicQualification(id)) {
      return HttpStatus.ACCEPTED;
    }
    return HttpStatus.BAD_REQUEST;
  }
}


