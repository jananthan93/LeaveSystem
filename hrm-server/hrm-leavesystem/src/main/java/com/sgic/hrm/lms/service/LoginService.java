package com.sgic.hrm.lms.service;

import com.sgic.hrm.commons.entity.User;

public interface LoginService {

  User getUser(String username);
}
