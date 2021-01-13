package com.vaccnow.vaccination.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccnow.vaccination.repository.VaccineBranchRelationRepository;
import com.vaccnow.vaccination.service.IVaccineBranchService;

@Service
public class VaccineBranchServiceImpl implements IVaccineBranchService {

	@Autowired
	private VaccineBranchRelationRepository vaccineBranchRepository;

	@Override
	public void updateVaccineCountInBranch(Integer branchId, Integer vaccineId) {
		vaccineBranchRepository.updateVaccineCountInBranch(branchId, vaccineId);
	}
	
	@Override
	public Integer getVaccineCountAtBranch(Integer branchId, Integer vaccineId) {
		return vaccineBranchRepository.findVaccinationCountAtBranch(branchId, vaccineId);
	}
}
