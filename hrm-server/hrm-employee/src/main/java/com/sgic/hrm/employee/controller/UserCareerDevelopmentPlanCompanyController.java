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
import com.sgic.hrm.commons.dto.UserCareerDevelopmentPlanCompanyData;
import com.sgic.hrm.commons.dto.UserCareerDevelopmentPlanCompanySaveData;
import com.sgic.hrm.commons.dto.mapper.UserCareerDevelopmentPlanCompanyDataMapper;
import com.sgic.hrm.commons.entity.UserCareerDevelopmentPlanCompany;
import com.sgic.hrm.employee.service.UserCareerDevelopmentPlanCompanyService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserCareerDevelopmentPlanCompanyController {
  
  @Autowired
  UserCareerDevelopmentPlanCompanyService userCareerDevelopmentPlanCompanyService;
  
  @PostMapping("/usercareerdevelopmentplancompany")
  public HttpStatus addUserCareerDevelopmentPlanCompany(@RequestBody UserCareerDevelopmentPlanCompanyData userCareerDevelopmentPlanCompanyData) {
      boolean testadd=userCareerDevelopmentPlanCompanyService.addUserCareerDevelopmentPlanCompany(UserCareerDevelopmentPlanCompanyDataMapper.userCareerDevelopmentPlanCompanyDataMapper(userCareerDevelopmentPlanCompanyData));
      if(testadd) {
        
        return HttpStatus.CREATED;
      }
      return HttpStatus.BAD_REQUEST;
    }
  
  @PostMapping("/usercareerdevelopmentplancompanysave")
  public HttpStatus postCDPCompany(@RequestBody  UserCareerDevelopmentPlanCompanySaveData userCareerDevelopmentPlanCompanySaveData) {

    boolean testadd=userCareerDevelopmentPlanCompanyService.addUserCareerDevelopmentPlanCompany(UserCareerDevelopmentPlanCompanyDataMapper.userCareerDevelopmentPlanCompanySaveDataMapper(userCareerDevelopmentPlanCompanySaveData));
    if(testadd) {
      
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }
  
  @GetMapping("/usercareerdevelopmentplancompany")
  public ResponseEntity<List<UserCareerDevelopmentPlanCompany>> getCareerDevelopemntPlan() {
    List<UserCareerDevelopmentPlanCompany> careerDevelopmentPlanCompany = userCareerDevelopmentPlanCompanyService.getUserCareerDevelopmentPlanCompany();
    return new ResponseEntity<>(careerDevelopmentPlanCompany, HttpStatus.OK);  
  }
  
  @PutMapping("/usercareerdevelopmentplancompany/{id}")
  public HttpStatus updateCareerDevelopemntPlanCompany(@RequestBody UserCareerDevelopmentPlanCompanyData userCareerDevelopmentPlanCompanyData, @PathVariable Integer id) {
      boolean testedit=userCareerDevelopmentPlanCompanyService.editCareerDevelopmentPlanCompany(UserCareerDevelopmentPlanCompanyDataMapper.userCareerDevelopmentPlanCompanyDataMapper(userCareerDevelopmentPlanCompanyData), id);
      if(testedit) {
          return HttpStatus.ACCEPTED;
      }
      return HttpStatus.BAD_REQUEST;
  }
  
  @PutMapping("/usercareerdevelopmentplancompanysave/{id}")
  public HttpStatus putCareerDevelopemntPlanCompany(@RequestBody UserCareerDevelopmentPlanCompanySaveData userCareerDevelopmentPlanCompanySaveData, @PathVariable Integer id) {
      boolean testedit=userCareerDevelopmentPlanCompanyService.editCareerDevelopmentPlanCompany(UserCareerDevelopmentPlanCompanyDataMapper.userCareerDevelopmentPlanCompanySaveDataMapper(userCareerDevelopmentPlanCompanySaveData), id);
      if(testedit) {
          return HttpStatus.ACCEPTED;
      }
      return HttpStatus.BAD_REQUEST;
  }
  
  
  @DeleteMapping("/usercareerdevelopmentplancompany/{id}")
  public HttpStatus deleteCareerDevelopemntPlan(@PathVariable Integer id) {
      boolean testdelete=userCareerDevelopmentPlanCompanyService.deleteUserCareerDevelopmentPlanCompany(id);
      if(testdelete) {
          return HttpStatus.OK;
      }
      return HttpStatus.BAD_REQUEST;
  }
  
//  @GetMapping("/usercareerdevelopmentplancompany/{id}")
//  public UserCareerDevelopmentPlanCompany getCareerDevelopemntPlanById(@PathVariable int id){
//    return userCareerDevelopmentPlanCompanyService.getUserCareerDevelopmentPlanCompanyById(id);
//  }
  
  @GetMapping("/usercareerdevelopmentplancompany/{id}")
  public List<UserCareerDevelopmentPlanCompany> getCareerDevelopemntPlanByUserId(@PathVariable int id){
    return userCareerDevelopmentPlanCompanyService.getUserCareerDevelopmentPlanByUserId(id);
  }
  
  
}
