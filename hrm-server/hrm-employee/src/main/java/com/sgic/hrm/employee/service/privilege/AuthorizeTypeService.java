package com.sgic.hrm.employee.service.privilege;

import java.util.List;

import com.sgic.hrm.commons.entity.privilege.AuthorizeType;

public interface AuthorizeTypeService {
	public List<AuthorizeType> getAllAuthorizeTypes();

	public boolean createAuthorizeType(AuthorizeType authorizeType);

	public boolean editAuthorizeType(AuthorizeType authorizeType, Integer id);

	public boolean deleteAuthorizeType(Integer id);
}
