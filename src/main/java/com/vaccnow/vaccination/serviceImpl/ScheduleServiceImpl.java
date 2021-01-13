package com.vaccnow.vaccination.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccnow.vaccination.dto.ScheduleDTO;
import com.vaccnow.vaccination.entity.Schedule;
import com.vaccnow.vaccination.exception.VaccinationException;
import com.vaccnow.vaccination.repository.BranchRepository;
import com.vaccnow.vaccination.repository.ScheduleRepository;
import com.vaccnow.vaccination.repository.VaccineBranchRelationRepository;
import com.vaccnow.vaccination.repository.VaccineRepository;
import com.vaccnow.vaccination.service.IReportService;
import com.vaccnow.vaccination.service.IScheduleService;

@Service
public class ScheduleServiceImpl implements IScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Autowired
	private VaccineBranchRelationRepository vaccineBranchRepository;

	@Override
	public List<ScheduleDTO> getAllSchedule() {
		return scheduleRepository.findAllOpenSchedule().stream().map(Schedule::toDTO).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public ScheduleDTO saveSchedule(ScheduleDTO scheduleDTO) {

		if (scheduleDTO.getScheduleId() != null) {
			Optional<Schedule> schedule = scheduleRepository.findById(scheduleDTO.getScheduleId());
			if (schedule.isPresent()) {
				return Schedule.toDTO(scheduleRepository.save(Schedule.fromDTO(scheduleDTO)));
			}

		}
		List<String> bookedTimeSlotForBranch = scheduleRepository
				.findAvailableTimeSlotForBranch(scheduleDTO.getBranch().getBranchId());
		Integer vaccineCount = vaccineBranchRepository.findVaccinationCountAtBranch(
				scheduleDTO.getBranch().getBranchId(), scheduleDTO.getVaccine().getVaccineId());
		if (bookedTimeSlotForBranch.contains(scheduleDTO.getScheduleTime())) {
			throw new VaccinationException("Schedule Time is Not Available ! Please try another time-slot");
		}
		if (vaccineCount <= 0) {
			throw new VaccinationException(
					"Vaccine is not Available at this branch! Please try to book on another branch");
		}

		vaccineBranchRepository.updateVaccineCountInBranch(scheduleDTO.getBranch().getBranchId(),
				scheduleDTO.getVaccine().getVaccineId());
		return Schedule.toDTO(scheduleRepository.save(Schedule.fromDTO(scheduleDTO)));
	}

	@Override
	public List<String> getBookedTimeForBranch(Integer branchId) {
		return scheduleRepository.findAvailableTimeSlotForBranch(branchId);
	}

	@Override
	public Optional<Schedule> findById(Integer scheduleId) {
		return scheduleRepository.findById(scheduleId);
	}

}
