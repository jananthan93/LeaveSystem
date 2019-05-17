package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.DeniedPromotion;

public interface DeniedPromotionService {

	boolean addDeniedPromotion(DeniedPromotion deniedPromotion);

	List<DeniedPromotion> getAllDeniedPromotion();

	boolean editDeniedPromotion(DeniedPromotion deniedPromotion, Integer id);

	boolean deleteDeniedPromotion(Integer id);

	DeniedPromotion getById(Integer id);

	List<DeniedPromotion> getDeniedPromotionByUserId(int id);

}
