//package com.sgic.hrm.commons.dto.mapper;
//
//import java.util.ArrayList;
//import java.util.List;
//import com.sgic.hrm.commons.dto.UserDto;
//import com.sgic.hrm.commons.entity.Department;
//import com.sgic.hrm.commons.entity.User;
//
//public class UserDtoMapper {
//
//  public static User mapUser(UserDto userDto) {
//    User user = new User();
//    Department department = new Department();
//    department.setDepartmentName(userDto.getDepartment());
//    if(userDto.getId() != null) {
//      user.setId(userDto.getId());
//      user.setFullName(userDto.getFullname());
//      user.setDepartment(department);
//    }
//    return user;
//  }
//  
//  public static List<User> mapUserList(List<UserDto> userDtos){
//    List<User> userList = new ArrayList<User>();
//    if(userDtos != null) {
//      for(UserDto userDto : userDtos) {
//        userList.add(mapUser(userDto));
//      }
//    }
//    return userList;
//  }
//  
//}
