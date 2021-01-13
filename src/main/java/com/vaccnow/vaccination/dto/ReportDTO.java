package com.vaccnow.vaccination.dto;

import java.util.List;

public class ReportDTO {

	private BranchDTO branch;
	private List<VaccineDTO> vaccines;
	
	public BranchDTO getBranch() {
		return branch;
	}
	public void setBranch(BranchDTO branch) {
		this.branch = branch;
	}
	public List<VaccineDTO> getVaccines() {
		return vaccines;
	}
	public void setVaccines(List<VaccineDTO> vaccines) {
		this.vaccines = vaccines;
	}
	
}
