//package com.sgic.hrm.employee.serviceimpl.privilege;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sgic.hrm.commons.entity.privilege.Permission;
//import com.sgic.hrm.commons.repository.privilege.PermissionRepository;
//import com.sgic.hrm.employee.service.privilege.PermissionService;
//
//@Service
//public class PermissionServiceImpl implements PermissionService {
//	@Autowired
//	private PermissionRepository permissionRepository;
//
//	@Override
//	public List<Permission> getAllPermissions() {
//		return permissionRepository.findAll();
//	}
//
//	@Override
//	public boolean createPermission(Permission permission) {
//		if (permission != null) {
//			permissionRepository.save(permission);
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public boolean editPermission(Permission permission, Integer id) {
//		if (permissionRepository.getOne(id) != null) {
//			permission.setId(id);
//			permissionRepository.save(permission);
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public boolean deletePermission(Integer id) {
//		if (permissionRepository.getOne(id) != null) {
//			permissionRepository.deleteById(id);
//			return true;
//		}
//		return false;
//	}
//
//}
