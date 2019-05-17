package com.sgic.hrm.commons.dto.mapper;

import com.sgic.hrm.commons.dto.UserData;
import com.sgic.hrm.commons.entity.User;

public class UserDataMapper {
	private UserDataMapper() {}
	public static User userDataMapper(UserData userData) {
		User user = new User();

		user.setId(userData.getId());
		user.setFullName(userData.getFullName());
		return user;
	}
}
