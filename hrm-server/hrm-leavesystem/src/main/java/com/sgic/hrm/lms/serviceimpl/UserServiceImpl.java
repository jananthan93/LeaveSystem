/**
 * 
 */
package com.sgic.hrm.lms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.User;
import com.sgic.hrm.commons.repository.UserRepository;
import com.sgic.hrm.lms.service.UserService;

/**
 * @author Anushanth
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	@Override
	public User getUser(Integer userId) {
		
		return userRepository.findById(userId).get();
	}

	
}
