package com.vaccnow.vaccination.model;

import java.util.List;
import java.util.stream.Collectors;

import com.vaccnow.vaccination.dto.ReportDTO;

public class ReportModel {
	
	private BranchModel branch;
	private List<VaccineModel> vaccines;
	
	public BranchModel getBranch() {
		return branch;
	}

	public void setBranch(BranchModel branch) {
		this.branch = branch;
	}

	public List<VaccineModel> getVaccines() {
		return vaccines;
	}

	public void setVaccines(List<VaccineModel> vaccines) {
		this.vaccines = vaccines;
	}

	public static List<ReportModel> fromDTO(List<ReportDTO> appliedVaccinationAtBranch) {
		return appliedVaccinationAtBranch.stream().map(ReportModel::fromDTO).collect(Collectors.toList());
	}

	private static ReportModel fromDTO(ReportDTO reportDTO) {
		ReportModel report =  new ReportModel();
		report.setBranch(BranchModel.fromDTO(reportDTO.getBranch()));
		report.setVaccines(VaccineModel.fromDTO(reportDTO.getVaccines()));
		return report;
	}

}
