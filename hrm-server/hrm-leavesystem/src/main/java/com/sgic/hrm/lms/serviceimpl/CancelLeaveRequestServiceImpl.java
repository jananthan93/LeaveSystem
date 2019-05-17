package com.sgic.hrm.lms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.hrm.commons.dto.AcceptCancelRequestDto;
import com.sgic.hrm.commons.dto.RejectCancelRequestDto;
import com.sgic.hrm.commons.entity.AcceptCancelRequest;
import com.sgic.hrm.commons.entity.CancelLeaveRequest;
import com.sgic.hrm.commons.entity.RejectCancelRequest;
import com.sgic.hrm.commons.enums.Status;
import com.sgic.hrm.commons.repository.CancelLeaveRequestRepository;
import com.sgic.hrm.lms.service.AcceptCancelRequestService;
import com.sgic.hrm.lms.service.CancelLeaveRequestService;
import com.sgic.hrm.lms.service.LeaveAllocationService;
import com.sgic.hrm.lms.service.LeaveRequestService;
import com.sgic.hrm.lms.service.LoginService;
import com.sgic.hrm.lms.service.RejectCancelRequestService;

@Service
public class CancelLeaveRequestServiceImpl implements CancelLeaveRequestService {

	@Autowired
	CancelLeaveRequestRepository cancelLeaveRequestRepository;
	@Autowired
	LeaveRequestService leaveRequestService;
	@Autowired
	LeaveAllocationService leaveAllocationService;
	@Autowired
	AcceptCancelRequestService acceptCancelRequestService;
	@Autowired
	RejectCancelRequestService rejectCancelRequestService;
	@Autowired
	LoginService loginService;

	@Override
	public boolean addCancelLeaveRequest(CancelLeaveRequest cancelLeaveRequest) {
		cancelLeaveRequest.setStatus(Status.PENDING);
		cancelLeaveRequest.getLeaveRequest().setStatus(Status.FOR_CANCEL);
		if (leaveRequestService.updateLeaveRequest(cancelLeaveRequest.getLeaveRequest())) {
			cancelLeaveRequestRepository.save(cancelLeaveRequest);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCancelLeaveRequest(Integer id) {
		cancelLeaveRequestRepository.deleteById(id);
		return true;
	}

	@Transactional
	@Override
	public boolean acceptCancelLeaveRequest(AcceptCancelRequestDto acceptCancelRequestDto) {

		CancelLeaveRequest cancelLeaveRequest = cancelLeaveRequestRepository
				.findById(acceptCancelRequestDto.getCancelRequestId()).orElse(null);

		if (cancelLeaveRequest != null && cancelLeaveRequest.getStatus() == Status.PENDING) {
			cancelLeaveRequest.getLeaveRequest().setStatus(Status.CANCELED);
			if (leaveAllocationService.updateLeaveCount(cancelLeaveRequest.getLeaveRequest())) {
				cancelLeaveRequest.setStatus(Status.ACCEPTED);
				cancelLeaveRequestRepository.save(cancelLeaveRequest);
				if (leaveRequestService.updateLeaveRequest(cancelLeaveRequest.getLeaveRequest())) {
					AcceptCancelRequest acceptCancelRequest = new AcceptCancelRequest();
					acceptCancelRequest.setCancelLeaveRequest(cancelLeaveRequest);
					acceptCancelRequest.setAcceptedBy(loginService.getUser(acceptCancelRequestDto.getUserName()));
					acceptCancelRequestService.addAcceptCancelRequest(acceptCancelRequest);
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public List<CancelLeaveRequest> getAllCancelRequest() {
		return cancelLeaveRequestRepository.findAll();
	}

	@Override
	public List<CancelLeaveRequest> getPendingCancelRequest() {
		return cancelLeaveRequestRepository.findByStatusOrderByIdDesc(Status.PENDING);
	}

	@Override
	public List<CancelLeaveRequest> getCancelRequestByUser(Integer userId) {
		return null;
	}

	@Override
	public boolean rejectCancelLeaveRequest(RejectCancelRequestDto rejectCancelRequestDto) {

		CancelLeaveRequest cancelLeaveRequest = cancelLeaveRequestRepository
				.findById(rejectCancelRequestDto.getCancelRequestId()).orElse(null);

		if (cancelLeaveRequest != null && cancelLeaveRequest.getStatus() == Status.PENDING) {
			cancelLeaveRequest.getLeaveRequest().setStatus(Status.TAKE_LEAVE);
			if (leaveRequestService.updateLeaveRequest(cancelLeaveRequest.getLeaveRequest())) {
				cancelLeaveRequest.setStatus(Status.REJECTED);
				cancelLeaveRequestRepository.save(cancelLeaveRequest);
				RejectCancelRequest rejectCancelRequest = new RejectCancelRequest();
				rejectCancelRequest.setCancelLeaveRequest(cancelLeaveRequest);
				rejectCancelRequest.setRejectedBy(loginService.getUser(rejectCancelRequestDto.getUserName()));
				rejectCancelRequest.setReason(rejectCancelRequestDto.getRejectReason());
				rejectCancelRequestService.addRejectCancelRequest(rejectCancelRequest);
				return true;
			}
		}

		return false;
	}
}
