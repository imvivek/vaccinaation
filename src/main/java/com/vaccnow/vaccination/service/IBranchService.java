package com.vaccnow.vaccination.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vaccnow.vaccination.dto.BranchDTO;

@Service
public interface IBranchService {
	List<BranchDTO> getAllBranches();
	List<BranchDTO> getVaccinationByBranchId(Integer branchId);
	List<BranchDTO> getAllAvailableVaccines();
	List<String> getAvailableTimeForBranch(Integer branchId);
}
