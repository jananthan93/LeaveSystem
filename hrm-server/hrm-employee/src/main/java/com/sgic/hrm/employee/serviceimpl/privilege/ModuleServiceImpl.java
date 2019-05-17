package com.sgic.hrm.employee.serviceimpl.privilege;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.privilege.Module;
import com.sgic.hrm.commons.repository.privilege.ModuleRepository;
import com.sgic.hrm.employee.service.privilege.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {
	@Autowired
	private ModuleRepository moduleRepository;

	@Override
	public List<Module> getAllModules() {
		List<Module> moduleList = moduleRepository.findAll();
		return moduleList;
	}

	@Override
	public boolean createModule(Module module) {
		if (module != null) {
			moduleRepository.save(module);
			return true;
		}
		return false;
	}

	@Override
	public boolean editModule(Module module, Integer id) {
		if (moduleRepository.getOne(id) != null) {
			module.setId(id);
			moduleRepository.save(module);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteModule(Integer id) {
		if (moduleRepository.getOne(id) != null) {
			moduleRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
