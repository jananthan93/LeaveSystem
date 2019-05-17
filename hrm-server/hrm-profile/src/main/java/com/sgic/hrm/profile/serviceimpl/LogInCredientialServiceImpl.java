package com.sgic.hrm.profile.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.LogInCrediential;
import com.sgic.hrm.commons.repository.LogInCredientialRepository;
import com.sgic.hrm.profile.service.LogInCredientialService;

@Service
public class LogInCredientialServiceImpl implements LogInCredientialService {

  @Autowired
  private LogInCredientialRepository logInCredientialRepository;

  @Override
  public boolean addLogInCrediential(LogInCrediential logInCrediential) {

    logInCredientialRepository.save(logInCrediential);
    return true;
  }

  @Override
  public List<LogInCrediential> getAllLogInCrediential() {
    return logInCredientialRepository.findAll();
  }

  @Override
  public Optional<LogInCrediential> getLogInCredientialById(int id) {
    return logInCredientialRepository.findById(id);

  }

}
