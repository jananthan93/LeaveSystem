package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.Promotion;

public interface PromotionService {

	boolean addPromotion(Promotion promotion);

	List<Promotion> getAllPromotion();

	boolean deletePromotion(Integer id);

	boolean editPromotion(Promotion promotion, Integer id);

	Promotion findPromotionById(Integer id);

	List<Promotion> getPromotionByUserId(int id);

}
