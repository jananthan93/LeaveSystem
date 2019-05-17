package com.sgic.hrm.employee.controller.privilege;

import java.util.List;

import javax.transaction.Transactional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.mapper.privilege.ModuleDtoMapper;
import com.sgic.hrm.commons.dto.privilege.ModuleDto;
import com.sgic.hrm.commons.entity.Role;
import com.sgic.hrm.commons.entity.mapper.privilege.ModuleMapper;
import com.sgic.hrm.commons.entity.privilege.AuthorizeType;
import com.sgic.hrm.commons.entity.privilege.Module;
import com.sgic.hrm.commons.repository.RoleRepository;
import com.sgic.hrm.commons.repository.privilege.ModuleRepository;
import com.sgic.hrm.employee.service.privilege.AuthorizeTypeService;
import com.sgic.hrm.employee.service.privilege.ModuleService;
import com.sgic.hrm.employee.service.privilege.PrivilegeService;

@RestController
@RequestMapping("/module")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ModuleContoller {
	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private ModuleRepository moduleRepository;

	@Autowired
	private PrivilegeService privilegeService;

	@Autowired
	private AuthorizeTypeService authorizeTypeService;

	@Autowired
	private RoleRepository roleRepository;

	@GetMapping
	public ResponseEntity<List<ModuleDto>> getAllModules() {
		return new ResponseEntity<>(ModuleMapper.mapModuleListToModuleDtoList(moduleService.getAllModules()),
				HttpStatus.OK);
	}

	@PostMapping
	@Transactional
	public void addModule(@RequestBody ModuleDto moduleDto) {
		moduleService.createModule(ModuleDtoMapper.mapModuleDtoToModule(moduleDto));
		Module module = moduleRepository.findByModuleName(moduleDto.getModuleName());
		List<AuthorizeType> authorizeTypeList = authorizeTypeService.getAllAuthorizeTypes();
		List<Role> roleList = roleRepository.findAll();
		privilegeService.addPrivilegeForEachModule(module, authorizeTypeList, roleList);
	}

	@PutMapping("/{id}")
	public HttpStatus editModule(@RequestBody ModuleDto moduleDto, @PathVariable Integer id) {
		boolean flag = moduleService.editModule((ModuleDtoMapper.mapModuleDtoToModule(moduleDto)), id);
		if (flag) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteModule(@PathVariable Integer id) {
		boolean flag = moduleService.deleteModule(id);
		if (flag) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

}
