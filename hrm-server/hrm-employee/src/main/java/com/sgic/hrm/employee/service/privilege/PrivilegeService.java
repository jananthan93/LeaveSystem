package com.sgic.hrm.employee.service.privilege;

import java.util.List;

import com.sgic.hrm.commons.entity.Role;
import com.sgic.hrm.commons.entity.privilege.AuthorizeType;
import com.sgic.hrm.commons.entity.privilege.Module;
import com.sgic.hrm.commons.entity.privilege.Privilege;

public interface PrivilegeService {
	public List<Privilege> getAllPrivileges();

	public boolean createPrivilege(Privilege privilege);

	public boolean editPrivilege(Privilege privilege, Integer id);

	public boolean deletePrivilege(Integer id);
	
	public void addPrivilegeForEachModule(Module module, List<AuthorizeType> authorizeTypeList,
			List<Role> roleList);
}
