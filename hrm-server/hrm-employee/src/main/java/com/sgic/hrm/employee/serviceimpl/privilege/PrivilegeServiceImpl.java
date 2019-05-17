package com.sgic.hrm.employee.serviceimpl.privilege;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.Role;
import com.sgic.hrm.commons.entity.privilege.AuthorizeType;
import com.sgic.hrm.commons.entity.privilege.Module;
import com.sgic.hrm.commons.entity.privilege.Privilege;
import com.sgic.hrm.commons.repository.privilege.PrivilegeRepository;
import com.sgic.hrm.employee.service.privilege.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Override
	public List<Privilege> getAllPrivileges() {
		return privilegeRepository.findAll();
	}

	@Override
	public boolean createPrivilege(Privilege privilege) {
		if (privilege != null) {
			privilegeRepository.save(privilege);
			return true;
		}
		return false;
	}

	@Override
	public boolean editPrivilege(Privilege privilege, Integer id) {
		if (privilegeRepository.getOne(id) != null) {
			privilege.setId(id);
			privilegeRepository.save(privilege);
			return true;
		}
		return false;
	}

	@Override
	public boolean deletePrivilege(Integer id) {
		if (privilegeRepository.getOne(id) != null) {
			privilegeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public void addPrivilegeForEachModule(Module module, List<AuthorizeType> authorizeTypeList, List<Role> roleList) {

		for (Role role : roleList) {
			for (AuthorizeType authorizeType : authorizeTypeList) {
				Privilege privilege = new Privilege();
				privilege.setAuthorizeType(authorizeType);
				privilege.setModule(module);
				privilege.setRole(role);
				privilege.setEnabled(false);
				privilegeRepository.save(privilege);
			}
		}
	}

}
