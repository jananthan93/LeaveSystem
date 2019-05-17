package com.sgic.hrm.profile.service;

import java.util.List;
import java.util.Optional;
import com.sgic.hrm.commons.entity.KeyActivity;



public interface KeyActivityService {
  boolean addKeyActivity(KeyActivity keyActivity);

  List<KeyActivity> getKeyActivity();

  boolean editKeyActivity(KeyActivity keyActivity, Integer id);

  Optional<KeyActivity> getKeyActivityId(Integer id);

  boolean deleteKeyActivity(Integer id);

  KeyActivity findByActivityId(Integer id);
}
