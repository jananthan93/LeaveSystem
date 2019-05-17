package com.sgic.hrm.employee.remuneration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.LoanDetailsEntity;
import com.sgic.hrm.commons.repository.LoanDetailsRepository;
import com.sgic.hrm.employee.remuneration.service.LoanDetailsService;

@Service
public class LoanDetailsServiceImpl implements LoanDetailsService{
	@Autowired
	private LoanDetailsRepository loanDetailsRepository;

	@Override
	public List<LoanDetailsEntity> getAllLoanDetails() {
		// TODO Auto-generated method stub
		return loanDetailsRepository.findAll();
	}

}
