//package com.sgic.hrm.employee.controller.privilege;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sgic.hrm.commons.dto.mapper.privilege.PermissionDtoMapper;
//import com.sgic.hrm.commons.dto.privilege.PermissionDto;
//import com.sgic.hrm.commons.entity.mapper.privilege.PermissionMapper;
//import com.sgic.hrm.employee.service.privilege.PermissionService;
//
//@RestController
//@RequestMapping("/permission")
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 4200)
//public class PermissionController {
//	@Autowired
//	private PermissionService permissionService;
//
//	@GetMapping
//	public ResponseEntity<List<PermissionDto>> getAllPermissions() {
//		return new ResponseEntity<>(
//				PermissionMapper.mapPermissionListToPermissionDtoList(permissionService.getAllPermissions()),
//				HttpStatus.OK);
//	}
//
//	@PostMapping
//	public HttpStatus addPermission(@RequestBody PermissionDto permissionDto) {
//		boolean flag = permissionService
//				.createPermission(PermissionDtoMapper.mapPermissionDtoToPermission(permissionDto));
//		if (flag) {
//			return HttpStatus.ACCEPTED;
//		}
//		return HttpStatus.BAD_REQUEST;
//	}
//
//	@PutMapping("/{id}")
//	public HttpStatus editPermission(@RequestBody PermissionDto permissionDto, @PathVariable Integer id) {
//		boolean flag = permissionService
//				.editPermission((PermissionDtoMapper.mapPermissionDtoToPermission(permissionDto)), id);
//		if (flag) {
//			return HttpStatus.ACCEPTED;
//		}
//		return HttpStatus.BAD_REQUEST;
//	}
//
//	@DeleteMapping("/{id}")
//	public HttpStatus deletePermission(@PathVariable Integer id) {
//		boolean flag = permissionService.deletePermission(id);
//		if (flag) {
//			return HttpStatus.ACCEPTED;
//		}
//		return HttpStatus.BAD_REQUEST;
//	}
//}
