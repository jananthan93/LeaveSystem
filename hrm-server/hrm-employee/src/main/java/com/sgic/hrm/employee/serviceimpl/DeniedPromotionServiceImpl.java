package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.DeniedPromotion;
import com.sgic.hrm.commons.repository.DeniedPromotionRepository;
import com.sgic.hrm.employee.service.DeniedPromotionService;

@Service
public class DeniedPromotionServiceImpl implements DeniedPromotionService {

	@Autowired
	private DeniedPromotionRepository deniedPromotionRepository;

	@Override
	public boolean addDeniedPromotion(DeniedPromotion deniedPromotion) {
		deniedPromotionRepository.save(deniedPromotion);
		return true;
	}

	@Override
	public List<DeniedPromotion> getAllDeniedPromotion() {
		return deniedPromotionRepository.findAll();
	}

	@Override
	public boolean editDeniedPromotion(DeniedPromotion deniedPromotion, Integer id) {
		boolean success = false;
		if (deniedPromotionRepository.getOne(deniedPromotion.getId()) != null) {
			deniedPromotionRepository.save(deniedPromotion);
			success = true;
		}
		return success;
	}

	@Override
	public boolean deleteDeniedPromotion(Integer id) {
		DeniedPromotion deniedPromotion = deniedPromotionRepository.getOne(id);
		if (deniedPromotion.getId() == (id)) {
			deniedPromotionRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public DeniedPromotion getById(Integer id) {
		return deniedPromotionRepository.getOne(id);
	}

	@Override
	public List<DeniedPromotion> getDeniedPromotionByUserId(int id) {
		return deniedPromotionRepository.findByUserId(id);
	}

}
