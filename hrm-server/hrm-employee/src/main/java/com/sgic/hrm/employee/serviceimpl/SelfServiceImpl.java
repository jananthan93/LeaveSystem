package com.sgic.hrm.employee.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.SelfService;
import com.sgic.hrm.commons.repository.LoginRepository;
import com.sgic.hrm.commons.repository.SelfServiceRepository;
import com.sgic.hrm.employee.service.SelfServiceService;

@Service
public class SelfServiceImpl implements SelfServiceService {

	@Autowired
	private SelfServiceRepository selfServiceRepository;
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public List<SelfService> viewSelfService() {
		return selfServiceRepository.findAll();
	}

	@Override
	public boolean addSelfService(SelfService selfService) {
		selfServiceRepository.save(selfService);
		return true;
	}

	@Override
	public boolean editSelfService(SelfService selfService, Integer id) {
		if (selfServiceRepository.getOne(id) != null) {
			selfService.setId(id);
			selfServiceRepository.save(selfService);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteSelfService(Integer id) {
		if (selfServiceRepository.getOne(id) != null) {
			selfServiceRepository.deleteById(id);
			return true;
		}
		return false;
	}

  @Override
  public List<SelfService> findByUserId(Integer id) {
    return selfServiceRepository.findByUser(id);
  }
  
  @Override
  public List<SelfService> findByStatusNot(String status){
    return selfServiceRepository.findByStatus(status);
  }

@Override
public List<SelfService> getSpecificUser(String name) {
	return selfServiceRepository.findByuser(loginRepository.findByUsername(name).get().getUser());
}

}
