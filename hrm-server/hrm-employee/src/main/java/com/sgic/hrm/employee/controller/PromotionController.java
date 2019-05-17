package com.sgic.hrm.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.hrm.commons.dto.PromotionData;
import com.sgic.hrm.commons.dto.PromotionSaveData;
import com.sgic.hrm.commons.dto.mapper.PromotionDataToPromotion;
import com.sgic.hrm.commons.entity.Promotion;
import com.sgic.hrm.commons.entity.RequestPromotion;
import com.sgic.hrm.commons.entity.mapper.PromotionToPromotionData;
import com.sgic.hrm.employee.service.PromotionService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PromotionController {

	@Autowired
	PromotionService promotionService;

	@GetMapping("/promotion/{id}")
	public ResponseEntity<PromotionData> getById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<>(PromotionToPromotionData.mapToPromotionData(promotionService.findPromotionById(id)),
				HttpStatus.OK);
	}

	@GetMapping("/getpromotion")
	public ResponseEntity<List<PromotionData>> getAllPromotion() {

		return new ResponseEntity<>(PromotionToPromotionData.mapToPromotionDataList(promotionService.getAllPromotion()),
				HttpStatus.OK);
	}

	@PostMapping("/addpromotion")
	public ResponseEntity<String> addPromotion(@RequestBody PromotionData promotionData) {

		if (promotionService.addPromotion(PromotionDataToPromotion.mapToPromotion(promotionData))) {
			return new ResponseEntity<>("Promotion Create Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Promotion Create Failed ", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/promotionsave")
	public HttpStatus postRequestPromotion(@RequestBody PromotionSaveData promotionSaveData) {

		boolean test = promotionService
				.addPromotion(PromotionDataToPromotion.mapPromotionSaveDataToPromotion(promotionSaveData));
		if (test) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PutMapping("/editpromotion/{id}")
	public ResponseEntity<String> editPromotion(@PathVariable(name = "id") Integer id,
			@RequestBody PromotionData promotionData) {
		if (promotionService.editPromotion(PromotionDataToPromotion.mapToPromotion(promotionData), id)) {
			return new ResponseEntity<>("Promotion Update Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Promotion Update Failed ", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deletepromotion/{id}")
	public ResponseEntity<String> deletePromotion(@PathVariable(name = "id") Integer id) {
		if (promotionService.deletePromotion(id)) {
			return new ResponseEntity<>("Promotion Delete Succesfully ", HttpStatus.OK);
		}
		return new ResponseEntity<>("Promotion Delete Failed ", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/promotionByUser/{id}")
	public List<Promotion> getAllPromotionsByUserId(@PathVariable int id) {
		return promotionService.getPromotionByUserId(id);
	}
}
