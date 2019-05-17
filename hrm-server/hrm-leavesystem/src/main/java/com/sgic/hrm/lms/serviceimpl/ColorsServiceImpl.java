package com.sgic.hrm.lms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.hrm.commons.entity.Colors;
import com.sgic.hrm.commons.repository.ColorsRepository;
import com.sgic.hrm.lms.service.ColorsService;
@Service
public class ColorsServiceImpl implements ColorsService{
	@Autowired
	ColorsRepository colorsRepository;

	@Override
	public List<Colors> getAllColors() {
		return colorsRepository.findAll();
	}
	

}
