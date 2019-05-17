package com.sgic.hrm.employee.controller.privilege;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.mapper.privilege.PrivilegeDtoMapper;
import com.sgic.hrm.commons.dto.privilege.PrivilegeDto;
import com.sgic.hrm.commons.dto.privilege.PrivilegeUpdateDto;
import com.sgic.hrm.commons.entity.mapper.privilege.PrivilegeMapper;
import com.sgic.hrm.commons.entity.privilege.Privilege;
import com.sgic.hrm.commons.enums.RoleName;
import com.sgic.hrm.commons.repository.privilege.PrivilegeRepository;
import com.sgic.hrm.employee.service.privilege.PrivilegeService;

@RestController
@RequestMapping("/privilege")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 4200)
public class PrivilegeController {
	@Autowired
	private PrivilegeService privilegeService;

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@GetMapping
	public ResponseEntity<List<PrivilegeDto>> getAllPrivileges() {
		return new ResponseEntity<>(
				PrivilegeMapper.mapPrivilegeListToPrivilegeDtoList(privilegeService.getAllPrivileges()), HttpStatus.OK);
	}

	@PostMapping
	public HttpStatus addPrivilege(@RequestBody PrivilegeDto privilegeDto) {
		boolean flag = privilegeService.createPrivilege(PrivilegeDtoMapper.mapPrivilegeDtoToPrivilege(privilegeDto));
		if (flag) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PutMapping("/{id}")
	public HttpStatus editPrivilege(@RequestBody PrivilegeDto privilegeDto, @PathVariable Integer id) {
		boolean flag = privilegeService.editPrivilege((PrivilegeDtoMapper.mapPrivilegeDtoToPrivilege(privilegeDto)),
				id);
		if (flag) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@DeleteMapping("/{id}")
	public HttpStatus deletePrivilege(@PathVariable Integer id) {
		boolean flag = privilegeService.deletePrivilege(id);
		if (flag) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping(path = "/search", params = { "authorizeTypeName", "moduleName", "roleName" })
	public ResponseEntity<PrivilegeDto> getPrivilegeState(@RequestParam("authorizeTypeName") String authorizeTypeName,
			@RequestParam("moduleName") String moduleName, @RequestParam("roleName") RoleName roleName) {
		return new ResponseEntity<>(PrivilegeMapper.mapPrivilegeToPrivilegeDto(
				privilegeRepository.getPrivilegeState(authorizeTypeName, moduleName, roleName)), HttpStatus.OK);
	}

	@PostMapping("/update")
	public HttpStatus editPrivilegeState(@RequestBody PrivilegeUpdateDto privilegeUpdateDto) {

		if (privilegeUpdateDto != null) {
			Privilege privilege = privilegeRepository.getPrivilegeState(privilegeUpdateDto.getAuthorizeName(),
					privilegeUpdateDto.getModuleName(), privilegeUpdateDto.getRoleName());

			if (privilege != null) {
				privilege.setEnabled(privilegeUpdateDto.isEnabled());

				boolean flag = privilegeService.editPrivilege(privilege, privilege.getId());

				if (flag) {
					return HttpStatus.ACCEPTED;
				}
			}
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PostMapping("/state")
	public boolean findPrivilegeState(@RequestBody PrivilegeUpdateDto privilegeUpdateDto) {
		if (privilegeUpdateDto != null) {
			Privilege privilege = privilegeRepository.getPrivilegeState(privilegeUpdateDto.getAuthorizeName(),
					privilegeUpdateDto.getModuleName(), privilegeUpdateDto.getRoleName());
			if (privilege != null) {
				boolean state = privilege.isEnabled();
				return state;
			}
		}
		return false;
	}
}
