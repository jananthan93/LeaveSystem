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
import com.sgic.hrm.commons.dto.mapper.profile.ProfessionalMembershipDtoToProfessionalMembership;
import com.sgic.hrm.commons.dto.profile.ProfessionalMembershipDto;
import com.sgic.hrm.commons.dto.profile.ProfessionalMembershipSaveDto;
import com.sgic.hrm.commons.entity.mapper.profile.ProfessionalMembershipMapper;
import com.sgic.hrm.profile.service.ProfessionalMembershipService;
import com.sgic.hrm.profile.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ProfessionalMembershipController {
  @Autowired
  private ProfessionalMembershipService professionalMembershipService;

  @Autowired
  private UserService userService;

  @PostMapping("/professionalMembership")
  public HttpStatus addProfessionalMembership(
      @Valid @RequestBody ProfessionalMembershipSaveDto professionalMembershipSaveDto) {
    if (professionalMembershipService.addProfessionalMembership(
        ProfessionalMembershipDtoToProfessionalMembership.map(professionalMembershipSaveDto),
        userService.findByUserId(professionalMembershipSaveDto.getUser()))) {
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }


  @GetMapping("/professionalMembership")
  public ResponseEntity<List<ProfessionalMembershipDto>> getProfessionalMembership() {
    return new ResponseEntity<>(
        ProfessionalMembershipMapper.mapProfessionalMembershipListToProfessionalMembershipDtoList(
            professionalMembershipService.getAllProfessionalMembership()),
        HttpStatus.OK);

  }

  @PutMapping("/professionalMembership/edit/{id}")
  public HttpStatus modifyProfessionalMembership(@PathVariable Integer id,
      @RequestBody ProfessionalMembershipSaveDto professionalMembershipSaveDto) {
    if (professionalMembershipService.editProfessionalMembership(
        ProfessionalMembershipDtoToProfessionalMembership.map(professionalMembershipSaveDto),
        userService.findByUserId(professionalMembershipSaveDto.getUser()), id)) {
      return HttpStatus.ACCEPTED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @DeleteMapping("/professionalMembership/{id}")
  public HttpStatus deleteProfessionalMembership(@PathVariable Integer id) {
    boolean test = professionalMembershipService.deleteProfessionalMembership(id);
    if (test) {
      return HttpStatus.ACCEPTED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @GetMapping("/professionalMembership/{uid}")
  public ResponseEntity<List<ProfessionalMembershipDto>> findProfessionalMembershipByUserId(
      @PathVariable("uid") Integer id) {
    return new ResponseEntity<>(
        ProfessionalMembershipMapper.mapProfessionalMembershipListToProfessionalMembershipDtoList(
            professionalMembershipService.getProfessionalMembershipByUserId(id)),
        HttpStatus.OK);
  }
}
