package com.sgic.hrm.profile.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.Department;
import com.sgic.hrm.commons.entity.Role;
import com.sgic.hrm.commons.entity.User;
import com.sgic.hrm.commons.repository.UserRepository;
import com.sgic.hrm.profile.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;


  @Override
  public List<User> getUser() {
    return userRepository.findAll();

  }

  @Override
  public boolean editUser(User user, Integer id) {
    if (userRepository.getOne(id) != null) {
      user.setId(id);
      userRepository.save(user);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteUser(Integer id) {
    if (userRepository.getOne(id) != null) {
      userRepository.deleteById(id);
      return true;
    }
    return false;
  }

  @Override
  public User findByUserId(Integer id) {
    return userRepository.findUserById(id);
  }

  @Override
  public User findByUserName(String fullName) {

    return userRepository.findByfullName(fullName);
  }

  @Override
  public boolean addUser(User user, Role role, Department department) {
    user.setDepartment(department);
    user.setRole(role);
    userRepository.save(user);
    return true;
  }



}
