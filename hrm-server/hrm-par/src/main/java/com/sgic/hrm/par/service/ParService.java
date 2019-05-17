package com.sgic.hrm.par.service;

import java.util.List;

import com.sgic.hrm.commons.entity.par.Par;

public interface ParService {

	public Par findParById(Integer id);
	
	public Par createPar(Par par);
	List<Par>parHistory();
	public List<Par> findByEmployeeId(String id);

	public void deleteParById(Integer parId);
}
