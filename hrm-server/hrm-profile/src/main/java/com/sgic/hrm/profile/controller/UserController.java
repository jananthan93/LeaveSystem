package com.sgic.hrm.profile.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.hrm.commons.dto.mapper.profile.UserDtoToUser;
import com.sgic.hrm.commons.dto.profile.UserDto;
import com.sgic.hrm.commons.dto.profile.UserSaveDto;
import com.sgic.hrm.commons.entity.mapper.profile.UserMapper;
import com.sgic.hrm.profile.service.DepartmentService;
import com.sgic.hrm.profile.service.RoleService;
import com.sgic.hrm.profile.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UserController {
  @Autowired
  private UserService userService;
  @Autowired
  private DepartmentService departmentService;
  @Autowired
  private RoleService roleService;

  @PostMapping("/user")
  public HttpStatus addUser(@RequestBody UserSaveDto userSaveDto) {
    if (userService.addUser(UserDtoToUser.map(userSaveDto),
        roleService.findByRoleId(userSaveDto.getRole()),
        departmentService.findByDepartmentId(userSaveDto.getDepartment()))) {
      return HttpStatus.CREATED;
    }
    return HttpStatus.BAD_REQUEST;
  }

  @GetMapping("/user")
  public ResponseEntity<List<UserDto>> getUser() {
    return new ResponseEntity<>(UserMapper.mapUserListToUserDtoList(userService.getUser()),
        HttpStatus.OK);
  }

  @GetMapping("/user/{id}")
  public UserDto getUserById(@PathVariable Integer id) {
    return UserMapper.mapUserToUserDto(userService.findByUserId(id));
  }

  @GetMapping("/userget/{fullName}")
  public UserDto getUserByName(@PathVariable String fullName) {
    return UserMapper.mapUserToUserDto(userService.findByUserName(fullName));
  }

  @DeleteMapping("user/{id}")
  public HttpStatus deleteUser(@PathVariable Integer id) {
    if (userService.deleteUser(id)) {
      return HttpStatus.ACCEPTED;
    }
    return HttpStatus.BAD_REQUEST;
  }
}
