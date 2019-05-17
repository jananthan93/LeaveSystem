package com.sgic.hrm.employee.service.privilege;

import java.util.List;

import com.sgic.hrm.commons.entity.privilege.Module;

public interface ModuleService {
	public List<Module> getAllModules();

	public boolean createModule(Module module);

	public boolean editModule(Module module, Integer id);

	public boolean deleteModule(Integer id);
}
