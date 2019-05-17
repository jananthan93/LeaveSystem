package com.sgic.hrm.employee.remuneration.service;

import java.util.List;

import com.sgic.hrm.commons.entity.UserLoanDetails;

public interface UserLoanDetailsService {

	public List<UserLoanDetails> getAllUserLoanDetails();
	public List<UserLoanDetails> getSpecificUser(String username);
	public List<UserLoanDetails> getSpecificUserByName(String name);
}
 