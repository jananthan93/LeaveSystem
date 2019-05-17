package com.sgic.hrm.profile.controller;

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
import com.sgic.hrm.commons.dto.DepartmentData;
import com.sgic.hrm.commons.dto.mapper.DepartmentDataMapper;
import com.sgic.hrm.commons.entity.Department;
import com.sgic.hrm.profile.service.DepartmentService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class DepartmentController {
  @Autowired
  private DepartmentService departmentService;

  @PostMapping("/department")
  public HttpStatus AddDepartment(@RequestBody DepartmentData departmentData) {
    if (departmentService
        .addDepartment(DepartmentDataMapper.departmentDataMapper(departmentData))) {
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }


  @GetMapping("/department")
  public ResponseEntity<List<Department>> GetDepartment() {
    return new ResponseEntity<>( departmentService.getDepartment(), HttpStatus.OK);

  }

  @PutMapping("/department/{id}")
  public ResponseEntity<String> updateDepartment(@PathVariable(name = "id") Integer id,
      @RequestBody DepartmentData departmentData) {
    if (departmentService.editDepartment(DepartmentDataMapper.departmentDataMapper(departmentData),
        id)) {
      return new ResponseEntity<>("updated", HttpStatus.OK);
    }
    return new ResponseEntity<>("upadte failed", HttpStatus.BAD_REQUEST);
  }

  @DeleteMapping("/department/{id}")
  public HttpStatus DeleteDepartment(@PathVariable Integer id) {
    if (departmentService.deleteDepartment(id)) {
      return HttpStatus.ACCEPTED;
    }
    return HttpStatus.BAD_REQUEST;
  }

}
