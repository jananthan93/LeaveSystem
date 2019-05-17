package com.sgic.hrm.profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.entity.Role;
import com.sgic.hrm.profile.service.RoleService;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/roles")
	public ResponseEntity <List<Role>> viewRoles()
	{
		return new ResponseEntity<>(roleService.getRoles(), HttpStatus.OK);
		
  }

}
