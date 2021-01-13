package com.vaccnow.vaccination.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.vaccnow.vaccination.dto.BranchDTO;

@Entity
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "branch_id")
	private Integer branchId;

	private String branchName;
	private String branchLocation;

	@OneToMany(mappedBy = "branch")
	private List<VaccineBranchRelation> vaccineBranchStatus;

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public List<VaccineBranchRelation> getVaccineBranchStatus() {
		return vaccineBranchStatus;
	}

	public void setVaccineBranchStatus(List<VaccineBranchRelation> vaccineBranchStatus) {
		this.vaccineBranchStatus = vaccineBranchStatus;
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

	public static BranchDTO toDTO(Branch branch) {
		BranchDTO branchDTO = new BranchDTO();
		branchDTO.setBranchId(branch.getBranchId());
		branchDTO.setBranchName(branch.getBranchName());
		branchDTO.setBranchLocation(branch.getBranchLocation());
		return branchDTO;
	}

	public static Branch fromDTO(BranchDTO branchDTO) {
		Branch branch = new Branch();
		branch.setBranchId(branchDTO.getBranchId());
		branch.setBranchName(branchDTO.getBranchName());
		branch.setBranchLocation(branchDTO.getBranchLocation());
		return branch;
	}

}
