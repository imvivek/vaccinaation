package com.vaccnow.vaccination.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.vaccnow.vaccination.dto.BranchDTO;
import com.vaccnow.vaccination.dto.ReportDTO;
import com.vaccnow.vaccination.dto.VaccineDTO;
import com.vaccnow.vaccination.entity.Branch;
import com.vaccnow.vaccination.entity.Schedule;
import com.vaccnow.vaccination.entity.Vaccine;
import com.vaccnow.vaccination.repository.ScheduleRepository;
import com.vaccnow.vaccination.service.IReportService;

@Service
public class ReportServiceImpl implements IReportService {

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public List<ReportDTO> getAppliedVaccinationAtBranch(Integer branchId) {

		List<Schedule> appliedVaccines = scheduleRepository.findAppliedVaccinationAtBranch(branchId);
		if (!CollectionUtils.isEmpty(appliedVaccines)) {
			return reportDTOMapper(appliedVaccines);
		}
		return Collections.emptyList();
	}

	@Override
	public List<ReportDTO> getAllAppliedVaccination() {
		List<Schedule> appliedVaccines = scheduleRepository.findAppliedVaccination();
		if (!CollectionUtils.isEmpty(appliedVaccines)) {
			return reportDTOMapper(appliedVaccines);
		}
		return Collections.emptyList();
	}

	private List<ReportDTO> reportDTOMapper(List<Schedule> schedules) {
		
		List<ReportDTO> reports = new ArrayList<>();
		for (Schedule schedule : schedules) {
			ReportDTO report = reports.stream()
					.filter(o -> o.getBranch().getBranchId().equals(schedule.getBranch().getBranchId())).findAny()
					.orElse(null);

			if (report != null) {
				VaccineDTO vaccineDTO = Vaccine.toDTO(schedule.getVaccine());
				report.getVaccines().add(vaccineDTO);
			} else {
				report = new ReportDTO();
				BranchDTO branchDTO = Branch.toDTO(schedule.getBranch());
				report.setBranch(branchDTO);

				List<VaccineDTO> vaccines = new ArrayList<>();
				VaccineDTO vaccineDTO = Vaccine.toDTO(schedule.getVaccine());
				vaccines.add(vaccineDTO);
				report.setVaccines(vaccines);
				reports.add(report);
			}

		}
		return reports;
	}
}
