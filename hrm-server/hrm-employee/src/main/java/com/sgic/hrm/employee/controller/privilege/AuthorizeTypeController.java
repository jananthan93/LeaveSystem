package com.sgic.hrm.employee.controller.privilege;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.mapper.privilege.AuthorizeTypeDtoMapper;
import com.sgic.hrm.commons.dto.privilege.AuthorizeTypeDto;
import com.sgic.hrm.commons.entity.mapper.privilege.AuthorizeTypeMapper;
import com.sgic.hrm.employee.service.privilege.AuthorizeTypeService;

@RestController
@RequestMapping("/authorizetype")
public class AuthorizeTypeController {
	@Autowired
	private AuthorizeTypeService authorizeTypeService;
	
	@GetMapping
	public ResponseEntity<List<AuthorizeTypeDto>> getAllAuthorizeTypes() {
		return new ResponseEntity<>(
				AuthorizeTypeMapper.mapAuthorizeTypeListToAuthorizeTypeDtoList(authorizeTypeService.getAllAuthorizeTypes()), HttpStatus.OK);
	}
	
	@PostMapping
	public HttpStatus addAuthorizeType(@RequestBody AuthorizeTypeDto authorizeTypeDto) {
		boolean flag = authorizeTypeService.createAuthorizeType(AuthorizeTypeDtoMapper.mapAuthorizeTypeDtoToAuthorizeType(authorizeTypeDto));
		if(flag) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@PutMapping("/{id}")
	public HttpStatus editAuthorizeType(@RequestBody AuthorizeTypeDto authorizeTypeDto, @PathVariable Integer id) {
		boolean flag = authorizeTypeService.editAuthorizeType((AuthorizeTypeDtoMapper.mapAuthorizeTypeDtoToAuthorizeType(authorizeTypeDto)), id);
		if(flag) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteAuthorizeType(@PathVariable Integer id) {
		boolean flag = authorizeTypeService.deleteAuthorizeType(id);
		if(flag) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}
}
