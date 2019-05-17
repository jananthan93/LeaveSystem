package com.sgic.hrm.commons.entity.mapper;

import com.sgic.hrm.commons.dto.UserData;
import com.sgic.hrm.commons.dto.UserDto;
import com.sgic.hrm.commons.entity.Department;
import com.sgic.hrm.commons.entity.User;

public class UserMapper {
	public static UserData userMapper(User user) {
		UserData userData = new UserData();

		if (user != null) {
			userData.setId(user.getId());
			userData.setFullName(user.getFullName());

			return userData;
		}
		return null;
	}

	public static UserDto mapUserDto(User user) {
		UserDto userDto = new UserDto();
		Department department = user.getDepartment();
		if (user.getId() != null) {
			userDto.setId(user.getId());
			userDto.setFullName(user.getFullName());
			userDto.setDepartment(department.getDepartmentName());
		}
		return userDto;
	}
}
