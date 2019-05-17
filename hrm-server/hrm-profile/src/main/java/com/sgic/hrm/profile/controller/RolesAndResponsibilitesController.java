//package com.sgic.hrm.profile.controller;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sgic.hrm.commons.dto.mapper.profile.RolesAndResponsibilitesDtoToRolesAndResponsibilites;
//import com.sgic.hrm.commons.dto.profile.RolesAndResponsibilityDto;
//import com.sgic.hrm.commons.dto.profile.RolesAndResponsibilitySaveDto;
//import com.sgic.hrm.commons.entity.RolesAndResponsibilites;
//import com.sgic.hrm.commons.entity.mapper.profile.RolesAndResponsibilityMapper;
//import com.sgic.hrm.profile.service.JobService;
//import com.sgic.hrm.profile.service.KeyActivityService;
//import com.sgic.hrm.profile.service.LocationService;
//import com.sgic.hrm.profile.service.RolesAndResponsibilitiesService;
//import com.sgic.hrm.profile.service.UserService;
//
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
//
//@RestController
//public class RolesAndResponsibilitesController {
//
//  @Autowired
//  private RolesAndResponsibilitiesService responsibilitiesService;
//  @Autowired
//  private JobService jobService;
//  @Autowired
//  private LocationService locationService;
//  @Autowired
//  private KeyActivityService keyActivityService;
//  @Autowired
//  private UserService userService;
//
//  @PostMapping("/rolesandresponsibilities")
//  public HttpStatus addRolesAndResponsibilities(
//      @RequestBody RolesAndResponsibilitySaveDto rolesAndResponsibilitySaveDto) {
//    RolesAndResponsibilites rolesAndResponsibilites =
//        RolesAndResponsibilitesDtoToRolesAndResponsibilites.map(rolesAndResponsibilitySaveDto);
//    if (responsibilitiesService.addRolesAndResponsibilites(rolesAndResponsibilites,
//        jobService.findByJobId(rolesAndResponsibilitySaveDto.getJob()),
//        userService.findByUserId(rolesAndResponsibilitySaveDto.getUser()),
//        keyActivityService.findByActivityId(rolesAndResponsibilitySaveDto.getKeyActivity()),
//        locationService.findByLocationId(rolesAndResponsibilitySaveDto.getLocation()))) {
//      return HttpStatus.CREATED;
//    }
//    return HttpStatus.BAD_REQUEST;
//  }
//
//  @PutMapping("/rolesandresponsibilities/edit/{id}")
//  public HttpStatus modifyRolesAndResponsibilities(
//      @RequestBody RolesAndResponsibilitySaveDto rolesAndResponsibilitySaveDto,
//      @PathVariable Integer id) {
//    if (responsibilitiesService.editRolesAndResponsibilites(
//        RolesAndResponsibilitesDtoToRolesAndResponsibilites.map(rolesAndResponsibilitySaveDto),
//        userService.findByUserId(rolesAndResponsibilitySaveDto.getUser()),
//        jobService.findByJobId(rolesAndResponsibilitySaveDto.getJob()),
//        locationService.findByLocationId(rolesAndResponsibilitySaveDto.getLocation()),
//        keyActivityService.findByActivityId(rolesAndResponsibilitySaveDto.getKeyActivity()), id)) {
//      return HttpStatus.CREATED;
//    }
//    return HttpStatus.BAD_REQUEST;
//  }
//
//  @GetMapping("/rolesandresponsibilities")
//  public ResponseEntity<List<RolesAndResponsibilityDto>> getRolesAndResponsibilities() {
//    List<RolesAndResponsibilityDto> rolesAndResponsibilityDtoList =
//        RolesAndResponsibilityMapper.mapRolesAndResponsibilityListToRolesAndResponsibilityDtoList(
//            responsibilitiesService.getRolesAndResponsibilites());
//
//    return new ResponseEntity<>(rolesAndResponsibilityDtoList, HttpStatus.OK);
//  }
//
//  @GetMapping("/rolesandresponsibilities/{uid}")
//  public ResponseEntity<List<RolesAndResponsibilityDto>> findRolesAndResponsibilitesByUserId(
//      @PathVariable("uid") Integer id) {
//    List<RolesAndResponsibilityDto> rolesAndResponsibilityDtoList =
//        RolesAndResponsibilityMapper.mapRolesAndResponsibilityListToRolesAndResponsibilityDtoList(
//            responsibilitiesService.getRolesAndResponsibilitesByUserId(id));
//    return new ResponseEntity<>(rolesAndResponsibilityDtoList, HttpStatus.OK);
//  }
//
//
//
//  @DeleteMapping("/rolesandresponsibilities/{id}")
//  public HttpStatus deleteRolesAndResponsibilities(@PathVariable Integer id) {
//    boolean test = responsibilitiesService.deleteRolesAndResponsibilites(id);
//    if (test) {
//      return HttpStatus.CREATED;
//    }
//    return HttpStatus.BAD_REQUEST;
//  }
//}
