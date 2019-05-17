
package com.sgic.hrm.lms.serviceimpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.Login;
import com.sgic.hrm.commons.entity.User;
import com.sgic.hrm.commons.repository.LoginRepository;
import com.sgic.hrm.lms.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

  @Autowired
  LoginRepository loginRepository;

  @Override
  public User getUser(String username) {
    Optional<Login> login = loginRepository.findByUsername(username);
    if (login.isPresent()) {
      return login.get().getUser();
    }
    return null;
  }
}
