package com.sgic.hrm.profile.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.Role;
import com.sgic.hrm.commons.repository.RoleRepository;
import com.sgic.hrm.profile.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public List<Role> getRoles() {
		return roleRepository.findAll();
	}
	@Override
	public Role findByRoleId(Long id) {
		
		return roleRepository.findRoleById(id);
	}
	
}
