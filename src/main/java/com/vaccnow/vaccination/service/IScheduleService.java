package com.vaccnow.vaccination.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vaccnow.vaccination.dto.ScheduleDTO;
import com.vaccnow.vaccination.entity.Schedule;

@Service
public interface IScheduleService {
	List<ScheduleDTO> getAllSchedule();
	ScheduleDTO saveSchedule(ScheduleDTO schedule);
	List<String> getBookedTimeForBranch(Integer branchId);
	Optional<Schedule> findById(Integer scheduleId);
}
