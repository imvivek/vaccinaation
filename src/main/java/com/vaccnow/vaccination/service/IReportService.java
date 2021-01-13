package com.vaccnow.vaccination.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vaccnow.vaccination.dto.ReportDTO;

@Service
public interface IReportService {
	List<ReportDTO> getAppliedVaccinationAtBranch(Integer branchId);

	List<ReportDTO> getAllAppliedVaccination();
}
