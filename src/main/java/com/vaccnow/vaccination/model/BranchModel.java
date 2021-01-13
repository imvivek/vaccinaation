package com.vaccnow.vaccination.model;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vaccnow.vaccination.dto.BranchDTO;

public class BranchModel {

	private Integer branchId;
	private String branchName;
	private String branchLocation;
	
	@JsonInclude(value = Include.NON_NULL)
	private VaccineBranchStatusModel vaccineBranchStatus;

	public VaccineBranchStatusModel getVaccineBranchStatus() {
		return vaccineBranchStatus;
	}

	public void setVaccineBranchStatus(VaccineBranchStatusModel vaccineBranchStatus) {
		this.vaccineBranchStatus = vaccineBranchStatus;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchLocation() {
		return branchLocation;
	}

	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}

	public static List<BranchModel> fromDTO(List<BranchDTO> allBranch) {
		return allBranch.stream().map(BranchModel::fromDTO).collect(Collectors.toList());
	}

	public static BranchModel fromDTO(BranchDTO branchDTO) {
		BranchModel branchModel = new BranchModel();
		branchModel.setBranchId(branchDTO.getBranchId());
		branchModel.setBranchName(branchDTO.getBranchName());
		branchModel.setBranchLocation(branchDTO.getBranchLocation());
		if (null != branchDTO.getVaccineBranchStatus()) {
			VaccineBranchStatusModel vaccineBranchStatus =  new VaccineBranchStatusModel();
			vaccineBranchStatus.setVaccineCount(branchDTO.getVaccineBranchStatus().getVaccineCount());
			vaccineBranchStatus.setVaccineName(branchDTO.getVaccineBranchStatus().getVaccineName());
			vaccineBranchStatus.setVaccineId(branchDTO.getVaccineBranchStatus().getVaccineId());
			vaccineBranchStatus.setVaccineCost(branchDTO.getVaccineBranchStatus().getVaccineCost());
			branchModel.setVaccineBranchStatus(vaccineBranchStatus);
		}
		return branchModel;
	}

	public static BranchDTO toDTO(BranchModel branch) {
		BranchDTO branchDTO = new BranchDTO();
		branchDTO.setBranchId(branch.getBranchId());
		branchDTO.setBranchLocation(branch.getBranchLocation());
		branchDTO.setBranchName(branch.getBranchName());
		return branchDTO;
	}

}
