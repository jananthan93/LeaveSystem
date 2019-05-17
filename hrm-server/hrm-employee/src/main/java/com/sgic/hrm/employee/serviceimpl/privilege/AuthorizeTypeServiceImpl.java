package com.sgic.hrm.employee.serviceimpl.privilege;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.privilege.AuthorizeType;
import com.sgic.hrm.commons.repository.privilege.AuthorizeTypeRepository;
import com.sgic.hrm.employee.service.privilege.AuthorizeTypeService;

@Service
public class AuthorizeTypeServiceImpl implements AuthorizeTypeService{
	@Autowired
	private AuthorizeTypeRepository authorizeTypeRepository;

	@Override
	public List<AuthorizeType> getAllAuthorizeTypes() {
		return authorizeTypeRepository.findAll();
	}

	@Override
	public boolean createAuthorizeType(AuthorizeType authorizeType) {
		if(authorizeType != null) {
			authorizeTypeRepository.save(authorizeType);
			return true;
		}
		return false;
	}

	@Override
	public boolean editAuthorizeType(AuthorizeType authorizeType, Integer id) {
		if(authorizeTypeRepository.getOne(id) != null) {
			authorizeType.setId(id);
			authorizeTypeRepository.save(authorizeType);
		}
		return false;
	}

	@Override
	public boolean deleteAuthorizeType(Integer id) {
		if(authorizeTypeRepository.getOne(id) != null) {
			authorizeTypeRepository.deleteById(id);
		}
		return false;
	}
	
}
