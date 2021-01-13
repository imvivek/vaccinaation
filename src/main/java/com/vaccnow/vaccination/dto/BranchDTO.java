package com.vaccnow.vaccination.dto;

public class BranchDTO {

	private Integer branchId;
	private String branchName;
	private String branchLocation;
	private VaccineBranchStatusDTO vaccineBranchStatus;

	public VaccineBranchStatusDTO getVaccineBranchStatus() {
		return vaccineBranchStatus;
	}

	public void setVaccineBranchStatus(VaccineBranchStatusDTO vaccineBranchStatus) {
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

	@Override
	public String toString() {
		return "BranchDTO [branchId=" + branchId + ", branchName=" + branchName + ", branchLocation=" + branchLocation
				+ "]";
	}
	

}
