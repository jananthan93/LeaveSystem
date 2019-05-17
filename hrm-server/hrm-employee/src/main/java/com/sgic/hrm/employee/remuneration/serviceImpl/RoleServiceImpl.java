package com.sgic.hrm.employee.remuneration.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.Role;
import com.sgic.hrm.commons.repository.RoleRepository;
import com.sgic.hrm.employee.remuneration.service.RoleService;
@Service 
public class RoleServiceImpl implements RoleService{
@Autowired
private RoleRepository roleRepository;
	@Override
	public List<Role> getAllRole() { 
		// TODO Auto-generated  method stub
		return roleRepository.findAll();
	}
}
