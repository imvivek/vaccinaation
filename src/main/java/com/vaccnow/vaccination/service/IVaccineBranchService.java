package com.vaccnow.vaccination.service;

import org.springframework.stereotype.Service;

@Service
public interface IVaccineBranchService {
	void updateVaccineCountInBranch(Integer branchId, Integer vaccineId);
	Integer getVaccineCountAtBranch(Integer branchId, Integer vaccineId);
}
