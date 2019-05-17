package com.sgic.hrm.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.RequestPromotion;
import com.sgic.hrm.commons.repository.RequestPromotionRepository;
import com.sgic.hrm.employee.service.RequestPromotionService;

@Service
public class RequestPromotionServiceImp implements RequestPromotionService {
	@Autowired
	private RequestPromotionRepository requestPromotionRepository;

	public boolean addRequestPromotion(RequestPromotion requestPromotion) {
		requestPromotionRepository.save(requestPromotion);
		return true;
	}

	@Override
	public List<RequestPromotion> getAllRequestPromotion() {
		return requestPromotionRepository.findAll();
	}

	@Override
	public boolean updateRequestPromotion(RequestPromotion requestPromotion, Integer id) {
		if (requestPromotionRepository.getOne(id) != null) {
			requestPromotion.setId(id);
			requestPromotionRepository.save(requestPromotion);
			return true;
		}
		return false;
	}

	@Override
	public RequestPromotion getRequestPromotionById(int id) {
		return requestPromotionRepository.getOne(id);
	}

	@Override
	public boolean deleteRequstPromotion(Integer id) {
		if (requestPromotionRepository.getOne(id) != null) {
			requestPromotionRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<RequestPromotion> getPromotionByUserId(int id) {
		return requestPromotionRepository.findById(id);
	}
	
	

}
