package com.sgic.hrm.employee.controller;

import java.util.List;
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
import com.sgic.hrm.commons.dto.SelfServiceDto;
import com.sgic.hrm.commons.dto.SelfServiceSaveDto;
import com.sgic.hrm.commons.dto.mapper.SelfServiceDtoMapper;
import com.sgic.hrm.commons.entity.SelfService;
import com.sgic.hrm.commons.entity.mapper.SelfServiceMapper;
import com.sgic.hrm.employee.service.SelfServiceService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3200)
@RestController
public class SelfServiceController {
  @Autowired
  private SelfServiceService selfServiceService;

  @GetMapping("/selfservice")
  public ResponseEntity<List<SelfServiceDto>> viewSelfService() {
    List<SelfServiceDto> selfServiceDtoList = SelfServiceMapper
        .mapSelfServiceListToSelfServiceDtoList(selfServiceService.viewSelfService());
    return new ResponseEntity<>(selfServiceDtoList, HttpStatus.OK);
  }

  @GetMapping("/selfservice/{id}")
  public ResponseEntity<List<SelfServiceDto>> viewSelfServiceByUser(@PathVariable Integer id) {
    List<SelfServiceDto> selfServiceDtoList = SelfServiceMapper
        .mapSelfServiceListToSelfServiceDtoList(selfServiceService.findByUserId(id));
    return new ResponseEntity<>(selfServiceDtoList, HttpStatus.OK);
  }

  @GetMapping("/selfservice/status/{status}")
  public ResponseEntity<List<SelfServiceDto>> viewSelfServiceByUser(@PathVariable String status) {
    List<SelfServiceDto> selfServiceDtoList = SelfServiceMapper
        .mapSelfServiceListToSelfServiceDtoList(selfServiceService.findByStatusNot(status));
    return new ResponseEntity<>(selfServiceDtoList, HttpStatus.OK);
  }

  @PostMapping("/selfservice")
  public HttpStatus addSelfService(@RequestBody SelfServiceSaveDto selfServiceSaveDto) {
    selfServiceSaveDto.setStatus("Pending");
    boolean test = selfServiceService.addSelfService(
        SelfServiceDtoMapper.mapSelfServiceSaveDtoToSelfService(selfServiceSaveDto));
    if (test) {
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @PutMapping("/selfservice/{id}")
  public HttpStatus modifySelfService(@PathVariable Integer id,
      @RequestBody SelfServiceDto selfServiceDto) {
    boolean test = selfServiceService.editSelfService(SelfServiceDtoMapper.mapSelfServiceDtoToSelfService(selfServiceDto), id);
    if (test) {
      return HttpStatus.ACCEPTED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @DeleteMapping("/selfservice/{id}")
  public HttpStatus deleteSelfService(@PathVariable Integer id) {
    boolean selfService = selfServiceService.deleteSelfService(id);
    if (selfService) {
      return HttpStatus.OK;
    }
    return HttpStatus.BAD_REQUEST;
  }
  @GetMapping("/selfservices/{username}")
  public List<SelfService> viewComplainByUser(@PathVariable String username)
  {
	  return selfServiceService.getSpecificUser(username);
  }

}
