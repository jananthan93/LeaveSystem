package com.sgic.hrm.employee.service;

import java.util.List;

import com.sgic.hrm.commons.entity.RequestPromotion;

public interface RequestPromotionService {
	boolean addRequestPromotion(RequestPromotion requestPromotion);

	List<RequestPromotion> getAllRequestPromotion();

	boolean updateRequestPromotion(RequestPromotion equestPromotion, Integer id);

	boolean deleteRequstPromotion(Integer id);

	RequestPromotion getRequestPromotionById(int id);
	
	List<RequestPromotion> getPromotionByUserId(int id);
}
