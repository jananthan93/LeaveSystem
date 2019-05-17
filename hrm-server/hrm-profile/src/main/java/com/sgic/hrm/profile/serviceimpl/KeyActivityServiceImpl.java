package com.sgic.hrm.profile.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.KeyActivity;
import com.sgic.hrm.commons.repository.KeyActivityRepository;
import com.sgic.hrm.profile.service.KeyActivityService;

@Service
public class KeyActivityServiceImpl implements KeyActivityService {
  @Autowired
  private KeyActivityRepository keyActivityRepository;

  @Override
  public boolean addKeyActivity(KeyActivity keyActivity) {
    keyActivityRepository.save(keyActivity);
    return true;
  }

  @Override
  public List<KeyActivity> getKeyActivity() {
    return keyActivityRepository.findAll();
  }

  @Override
  public boolean editKeyActivity(KeyActivity keyActivity, Integer id) {
    if (keyActivityRepository.getOne(id) != null) {
      keyActivity.setId(id);
      keyActivityRepository.save(keyActivity);
      return true;
    }
    return false;
  }

  @Override
  public Optional<KeyActivity> getKeyActivityId(Integer id) {
    return keyActivityRepository.findById(id);
  }

  @Override
  public boolean deleteKeyActivity(Integer id) {
    if (keyActivityRepository.getOne(id) != null) {
      keyActivityRepository.deleteById(id);
      return true;
    }
    return true;
  }

  @Override
  public KeyActivity findByActivityId(Integer id) {
    // TODO Auto-generated method stub
    return keyActivityRepository.findKeyActivityById(id);
  }

}
