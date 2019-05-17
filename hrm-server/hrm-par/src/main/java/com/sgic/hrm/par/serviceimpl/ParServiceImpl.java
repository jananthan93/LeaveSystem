package com.sgic.hrm.par.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.par.Par;
import com.sgic.hrm.commons.repository.par.ParRepository;
import com.sgic.hrm.par.service.ParService;

@Service
public class ParServiceImpl implements ParService {

	@Autowired
	ParRepository parRepo;

	// find par object by id
	public Par findParById(Integer id) {
		return parRepo.findParById(id);
	}

	// create a new par record
	public Par createPar(Par par) {
		
		return parRepo.save(par);
	}

	@Override
	public List<Par> parHistory() {
		// TODO Auto-generated method stub
		return parRepo.findAll();
	}

	@Override
	public List<Par> findByEmployeeId(String id) {
		// TODO Auto-generated method stub
		return parRepo.findByEmployeeId(id);
	}

	@Override
	public void deleteParById(Integer parId) {
		// TODO Auto-generated method stub
		parRepo.deleteById(parId);
	}

}
