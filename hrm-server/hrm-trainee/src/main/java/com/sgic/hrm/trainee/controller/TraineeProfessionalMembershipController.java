package com.sgic.hrm.trainee.controller;

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

import com.sgic.hrm.commons.dto.mapper.trainee.TraineeProfessionalMembershipDtoMapper;
import com.sgic.hrm.commons.dto.trainee.TraineeProfessionalMembershipDto;
import com.sgic.hrm.commons.dto.trainee.TraineeProfessionalMembershipSaveDto;
import com.sgic.hrm.commons.entity.mapper.trainee.TraineeProfessionalMembershipMapper;
import com.sgic.hrm.commons.entity.trainee.Trainee;
import com.sgic.hrm.trainee.service.TraineeProfessionalMembershipService;
import com.sgic.hrm.trainee.service.TraineeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TraineeProfessionalMembershipController {

	@Autowired
	private TraineeProfessionalMembershipService traineeProfessionalMembershipService;
	@Autowired
	private TraineeService traineeService;

	@GetMapping("/professionalMembership")
	public ResponseEntity<List<TraineeProfessionalMembershipDto>> getProfessionalMembership() {
		return new ResponseEntity<>(
				TraineeProfessionalMembershipMapper.mapProfessionalMembershipListToProfessionalMembershipDtoList(
						traineeProfessionalMembershipService.getAllProfessionalMembership()),
				HttpStatus.OK);

	}

	@GetMapping("/professionalMembership/{tid}")
	public ResponseEntity<List<TraineeProfessionalMembershipDto>> getProfesionalMembershipByTraineeId(
			@PathVariable("tid") Integer id) {
		return new ResponseEntity<>(
				TraineeProfessionalMembershipMapper.mapProfessionalMembershipListToProfessionalMembershipDtoList(
						traineeProfessionalMembershipService.getProfessionalMembershipByTraineeId(id)),
				HttpStatus.OK);

	}

	@PostMapping("/professionalMembership")
	public HttpStatus addProfessionalMembership(
			@RequestBody TraineeProfessionalMembershipSaveDto traineeProfessionalMembershipSaveDto) {
		Trainee trainee = traineeService.findTraineeById(traineeProfessionalMembershipSaveDto.getTrainee());
		if (traineeProfessionalMembershipService.addProfessionalMembership(TraineeProfessionalMembershipDtoMapper
				.mapProfessionalMembershipSaveDtoToProfeesionalMembership(traineeProfessionalMembershipSaveDto),
				trainee)) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PutMapping("/professionalMembership/{id}")
	public HttpStatus ModifyProfessionalMembership(@PathVariable Integer id,
			@RequestBody TraineeProfessionalMembershipSaveDto traineeProfessionalMembershipSaveDto) {
		Trainee trainee = traineeService.findTraineeById(traineeProfessionalMembershipSaveDto.getTrainee());
		if (traineeProfessionalMembershipService.editProfessionalMembership(TraineeProfessionalMembershipDtoMapper
				.mapProfessionalMembershipSaveDtoToProfeesionalMembership(traineeProfessionalMembershipSaveDto),
				trainee, id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@DeleteMapping("/professionalMembership/{id}")
	public HttpStatus deleteProfessionalMembership(@PathVariable Integer id) {
		if (traineeProfessionalMembershipService.deleteProfessionalMembership(id)) {
			return HttpStatus.ACCEPTED;
		}
		return HttpStatus.BAD_REQUEST;
	}
}
