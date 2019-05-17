package com.sgic.hrm.employee.remuneration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.entity.Role; 
import com.sgic.hrm.employee.remuneration.service.RoleService;

@RestController
public class RoleController {
@Autowired
private RoleService roleService;
@GetMapping("/role")
public List<Role> viewall(){
	return roleService.getAllRole();
}
}
