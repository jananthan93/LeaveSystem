/**
 * 
 */
package com.sgic.hrm.lms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.hrm.commons.dto.AcceptLeaveDto;
import com.sgic.hrm.commons.dto.RejectLeaveDto;
import com.sgic.hrm.commons.entity.AcceptLeaveRequest;
import com.sgic.hrm.commons.entity.LeaveRequest;
import com.sgic.hrm.commons.entity.RejectLeaveRequest;
import com.sgic.hrm.commons.enums.Status;
import com.sgic.hrm.commons.repository.LeaveRequestRepository;
import com.sgic.hrm.lms.service.AcceptLeaveRequestService;
import com.sgic.hrm.lms.service.LeaveAllocationService;
import com.sgic.hrm.lms.service.LeaveRequestService;
import com.sgic.hrm.lms.service.LoginService;
import com.sgic.hrm.lms.service.RejectLeaveRequestService;
import com.sgic.hrm.lms.service.UserService;

/**
 * @author Anushanth
 *
 */
@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

	@Autowired
	LeaveRequestRepository leaveRequestRepository;
	@Autowired
	LeaveAllocationService leaveAllocationService;
	@Autowired
	LoginService loginService;
	@Autowired
	AcceptLeaveRequestService acceptLeaveRequestService;
	@Autowired
	RejectLeaveRequestService rejectLeaveRequestService;
	@Autowired
	UserService userService;

	@Transactional
	@Override
	public boolean addLeaveRequest(LeaveRequest leaveRequest, String userName) {

		if (leaveRequest != null) {
			leaveRequest.setUser(loginService.getUser(userName));

			leaveRequest.setStatus(Status.PENDING);
			if (leaveAllocationService.updateLeaveCount(leaveRequest)) {
				leaveRequestRepository.save(leaveRequest);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<LeaveRequest> getLeaveRequestByUserName(String userName) {
		return leaveRequestRepository.findByUserOrderByIdDesc(loginService.getUser(userName));
	}

	@Transactional
	@Override
	public boolean acceptLeaveRequest(AcceptLeaveDto acceptLeaveDto) {

		LeaveRequest leaveRequest = leaveRequestRepository.findById(acceptLeaveDto.getLeaveRequestId()).orElse(null);

		if (leaveRequest != null) {
			leaveRequest.setStatus(Status.ACCEPTED);
			leaveRequestRepository.save(leaveRequest);
			AcceptLeaveRequest acceptLeaveRequest = new AcceptLeaveRequest();
			acceptLeaveRequest.setLeaveRequest(leaveRequest);
			acceptLeaveRequest.setAcceptedBy(loginService.getUser(acceptLeaveDto.getUserName()));
			acceptLeaveRequestService.addAcceptLeaveRequest(acceptLeaveRequest);
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public boolean deleteLeaveRequest(Integer id) {

		LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElse(null);
		if (leaveRequest != null) {
			leaveRequest.setStatus(Status.DELETED);
			leaveAllocationService.updateLeaveCount(leaveRequest);
			leaveRequestRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<LeaveRequest> getLeaveRequestByUser(Integer userId) {

		return leaveRequestRepository.findByUserOrderByIdDesc(userService.getUser(userId));
	}

	@Override
	public List<LeaveRequest> getAllLeaveRequest() {
		return leaveRequestRepository.findAllByOrderByUpdatedAtDesc();
	}

	@Override
	public List<LeaveRequest> getAllLeaveRequestByStatus(Status status) {

		return leaveRequestRepository.findByStatusOrderByIdDesc(status);
	}

	@Transactional
	@Override
	public boolean rejectLeaveRequest(RejectLeaveDto rejectLeaveDto) {
		LeaveRequest leaveRequest = leaveRequestRepository.findById(rejectLeaveDto.getLeaveRequestId()).orElse(null);

		if (leaveRequest != null) {
			leaveRequest.setStatus(Status.REJECTED);
			leaveAllocationService.updateLeaveCount(leaveRequest);
			leaveRequestRepository.save(leaveRequest);
			RejectLeaveRequest rejectLeaveRequest = new RejectLeaveRequest();
			rejectLeaveRequest.setLeaveRequest(leaveRequest);
			rejectLeaveRequest.setRejectedBy(loginService.getUser(rejectLeaveDto.getUserName()));
			rejectLeaveRequest.setReason(rejectLeaveDto.getRejectReason());
			rejectLeaveRequestService.addRejectLeaveRequest(rejectLeaveRequest);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateLeaveRequest(LeaveRequest leaveRequest) {
		if (leaveRequestRepository.findById(leaveRequest.getId()).isPresent()) {
			leaveRequestRepository.save(leaveRequest);
			return true;
		}
		return false;
	}

	@Override
	public List<LeaveRequest> getLeaveRequestByUserNot(String userName) {
		// TODO Auto-generated method stub
		return leaveRequestRepository.findByUserNotAndStatus(loginService.getUser(userName), Status.PENDING);
	}
}
