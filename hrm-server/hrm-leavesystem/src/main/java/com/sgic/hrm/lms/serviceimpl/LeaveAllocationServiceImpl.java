package com.sgic.hrm.lms.serviceimpl;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sgic.hrm.commons.entity.AppointmentType;
import com.sgic.hrm.commons.entity.CarryforwardRequest;
import com.sgic.hrm.commons.entity.LeaveAllocation;
import com.sgic.hrm.commons.entity.LeaveRequest;
import com.sgic.hrm.commons.entity.LeaveType;
import com.sgic.hrm.commons.entity.User;
import com.sgic.hrm.commons.enums.LeaveTypes;
import com.sgic.hrm.commons.enums.Status;
import com.sgic.hrm.commons.repository.LeaveAllocationRepository;
import com.sgic.hrm.commons.repository.LeaveTypeRepository;
import com.sgic.hrm.lms.service.LeaveAllocationService;

@Service
public class LeaveAllocationServiceImpl implements LeaveAllocationService {

	@Autowired
	LeaveAllocationRepository leaveAllocationRepository;
	@Autowired
	LeaveTypeRepository leaveTypeRepository;

	@Override
	public boolean allocateLeave(User user, AppointmentType appointmentType, List<LeaveType> leaveTypeList) {

		for (LeaveType leaveType : leaveTypeList) {
			LeaveAllocation leaveAllocation = new LeaveAllocation();
			leaveAllocation.setUser(user);
			leaveAllocation.setLeaveType(leaveType);

			if (leaveType.getLeaveTypeValue().equals(LeaveTypes.ANNUAL.toString())) {
				leaveAllocation.setAllocatedDays(0.0);
			} else if (leaveType.getLeaveTypeValue().equals(LeaveTypes.CASUAL.toString())) {
				if (!appointmentType.getAppointmentType().equals("PERMENANT")) {
					leaveAllocation.setAllocatedDays(0.0);
				} else {
					leaveAllocation.setAllocatedDays(leaveType.getDefaultAllocation());
				}
			} else {
				leaveAllocation.setAllocatedDays(leaveType.getDefaultAllocation());
			}
			leaveAllocation.setUtilizedDays(0.0);
			leaveAllocationRepository.save(leaveAllocation);
		}
		return true;
	}

	@Override
	public List<LeaveAllocation> viewLeaveAllocationByUser(User user) {
		return leaveAllocationRepository.findAllByUserOrderByIdAsc(user);
	}

	@Override
	public boolean deleteLeaveAllocation(Integer id) {
		if (leaveAllocationRepository.getOne(id) != null) {
			leaveAllocationRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public void resetLeaveAllocationYearly() {
		//
	}

	@Override
	public void resetLeaveAllocationMonthly() {
		//
	}

	@Override
	public boolean updateLeaveCount(LeaveRequest leaveRequest) {

		LeaveAllocation allocation = leaveRequest.getLeaveAllocation();
		long diffInMillies = Math.abs(leaveRequest.getStartDate().getTime() - leaveRequest.getEndDate().getTime());
		double days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

		if (leaveRequest.getStatus() == Status.PENDING
				&& allocation.getAllocatedDays() >= allocation.getUtilizedDays() + days + 1) {

			allocation.setUtilizedDays(allocation.getUtilizedDays() + days + 1);
			leaveAllocationRepository.save(allocation);
			return true;
		}

		if (leaveRequest.getStatus() == Status.CANCELED || leaveRequest.getStatus() == Status.REJECTED
				|| leaveRequest.getStatus() == Status.DELETED) {
			allocation.setUtilizedDays(allocation.getUtilizedDays() - days - 1);
			leaveAllocationRepository.save(allocation);
			return true;
		}
		return false;
	}

	@Override
	public boolean deductCarryforwardedDays(CarryforwardRequest carryforwardRequest) {

		LeaveAllocation allocation = leaveAllocationRepository.findByUserAndLeaveType(carryforwardRequest.getUser(),
				leaveTypeRepository.findByLeaveTypeValue("Annual"));
		if (carryforwardRequest.getStatus() == Status.PENDING) {
			if ((allocation.getAllocatedDays() - allocation.getUtilizedDays()) >= carryforwardRequest
					.getCarryForwardDays()) {
				allocation.setUtilizedDays(allocation.getUtilizedDays() + carryforwardRequest.getCarryForwardDays());
				leaveAllocationRepository.save(allocation);
				return true;
			}
		} else if (carryforwardRequest.getStatus() == Status.CANCELED
				|| carryforwardRequest.getStatus() == Status.REJECTED
				|| carryforwardRequest.getStatus() == Status.DELETED) {
			allocation.setUtilizedDays(allocation.getUtilizedDays() - carryforwardRequest.getCarryForwardDays());
			leaveAllocationRepository.save(allocation);
			return true;
		}
		return false;
	}

	@Override
	public LeaveAllocation getByUserAndType(User user) {

		return leaveAllocationRepository.findByUserAndLeaveType(user,
				leaveTypeRepository.findByLeaveTypeValue("Annual"));
	}

}
