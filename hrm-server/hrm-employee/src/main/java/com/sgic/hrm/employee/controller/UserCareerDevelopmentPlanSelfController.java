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
import com.sgic.hrm.commons.dto.UserCareerDevelopmentPlanCompanySaveData;
import com.sgic.hrm.commons.dto.UserCareerDevelopmentPlanSelfData;
import com.sgic.hrm.commons.dto.UserCareerDevelopmentPlanSelfSaveData;
import com.sgic.hrm.commons.dto.mapper.UserCareerDevelopmentPlanCompanyDataMapper;
import com.sgic.hrm.commons.dto.mapper.UserCareerDevelopmentPlanSelfDataMapper;
import com.sgic.hrm.commons.entity.UserCareerDevelopmentPlanCompany;
import com.sgic.hrm.commons.entity.UserCareerDevelopmentPlanSelf;
import com.sgic.hrm.employee.service.UserCareerDevelopmentPlanSelfService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserCareerDevelopmentPlanSelfController {
  
  @Autowired
  UserCareerDevelopmentPlanSelfService userCareerDevelopmentPlanSelfService;
  
   
  @PostMapping("/usercareerdevelopmentplanself")
  public HttpStatus addCareerDevelopemntPlan(@RequestBody UserCareerDevelopmentPlanSelfData userCareerDevelopmentPlanSelfData) {
    boolean testadd=userCareerDevelopmentPlanSelfService.addCareerDevelopmentPlanSelf(UserCareerDevelopmentPlanSelfDataMapper.userCareerDevelopmentSelfDataMapper(userCareerDevelopmentPlanSelfData));
    if(testadd) {
      
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }
  
  @PostMapping("/usercareerdevelopmentplanselfsave")
  public HttpStatus postCDPCompany(@RequestBody  UserCareerDevelopmentPlanSelfSaveData userCareerDevelopmentPlanSelfSaveData) {

    boolean testadd=userCareerDevelopmentPlanSelfService.addCareerDevelopmentPlanSelf(UserCareerDevelopmentPlanSelfDataMapper.userCareerDevelopmentPlanSelfSaveDataMapper(userCareerDevelopmentPlanSelfSaveData));
    if(testadd) {
      
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }
  
  @GetMapping("/usercareerdevelopmentplanself")
  public ResponseEntity<List<UserCareerDevelopmentPlanSelf>> getCareerDevelopemntPlan() {
    List<UserCareerDevelopmentPlanSelf> userCareerDevelopmentPlanSelf = userCareerDevelopmentPlanSelfService.getCareerDevelopmentPlanSelf();
    return new ResponseEntity<>(userCareerDevelopmentPlanSelf, HttpStatus.OK);
    
  }
  
  @PutMapping("/usercareerdevelopmentplanself/{id}")
  public HttpStatus updateCareerDevelopemntPlan(@RequestBody UserCareerDevelopmentPlanSelfData userCareerDevelopmentPlanSelfData, @PathVariable Integer id) {
      boolean testedit=userCareerDevelopmentPlanSelfService.editCareerDevelopmentPlanSelf(UserCareerDevelopmentPlanSelfDataMapper.userCareerDevelopmentSelfDataMapper(userCareerDevelopmentPlanSelfData), id);
      if(testedit) {
          return HttpStatus.ACCEPTED;
      }
      return HttpStatus.BAD_REQUEST;
  }
  
  @PutMapping("/usercareerdevelopmentplanselfsave/{id}")
  public HttpStatus putCareerDevelopemntPlanSelf(@RequestBody UserCareerDevelopmentPlanSelfSaveData userCareerDevelopmentPlanSelfSaveData, @PathVariable Integer id) {
      boolean testedit=userCareerDevelopmentPlanSelfService.editCareerDevelopmentPlanSelf(UserCareerDevelopmentPlanSelfDataMapper.userCareerDevelopmentPlanSelfSaveDataMapper(userCareerDevelopmentPlanSelfSaveData), id);
      if(testedit) {
          return HttpStatus.ACCEPTED;
      }
      return HttpStatus.BAD_REQUEST;
  }
  
  
  
  @DeleteMapping("/usercareerdevelopmentplanself/{id}")
  public HttpStatus deleteCareerDevelopemntPlan(@PathVariable Integer id) {
      boolean testdelete=userCareerDevelopmentPlanSelfService.deleteCareerDevelopmentPlanSelf(id);
      if(testdelete) {
          return HttpStatus.OK;
      }
      return HttpStatus.BAD_REQUEST;
  }

  @GetMapping("/usercareerdevelopmentplanself/{id}")
  public List<UserCareerDevelopmentPlanSelf> getCareerDevelopemntPlanByUserId(@PathVariable int id){
    return userCareerDevelopmentPlanSelfService.getCareerDevelopmentPlanSelfByUserId(id);
  }
  

}
