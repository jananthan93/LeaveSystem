package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.Promotion;
import com.sgic.hrm.commons.repository.PromotionRepository;
import com.sgic.hrm.employee.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {

	@Autowired
	private PromotionRepository promotionRepository;

	@Override
	public boolean addPromotion(Promotion promotion) {
		promotionRepository.save(promotion);
		return true;
	}

	@Override
	public List<Promotion> getAllPromotion() {
		return promotionRepository.findAll();
	}

	@Override
	public boolean deletePromotion(Integer id) {
		Promotion promotion = promotionRepository.getOne(id);
		if (promotion.getId() == (id)) {
			promotionRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean editPromotion(Promotion promotion, Integer id) {
		boolean success = false;
		if (promotionRepository.getOne(id) != null) {
			promotion.setId(id);
			promotionRepository.save(promotion);
			success = true;
			return success;
		}
		return success;
	}

	@Override
	public Promotion findPromotionById(Integer id) {
		return promotionRepository.findById(id).orElse(null);
	}

	@Override
	public List<Promotion> getPromotionByUserId(int id) {
		return promotionRepository.findByUserId(id);
	}
}
