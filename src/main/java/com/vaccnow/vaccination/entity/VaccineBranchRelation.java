package com.vaccnow.vaccination.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(VaccineBranchId.class)
@Table(name = "vaccine_branch_relation")
public class VaccineBranchRelation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "branch_id", referencedColumnName = "branch_id")
	private Branch branch;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "vaccine_id", referencedColumnName = "vaccine_id")
	private Vaccine vaccine;
	
	@Column(name="vaccine_count")
	private int vaccineCount;

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public int getVaccineCount() {
		return vaccineCount;
	}

	public void setVaccineCount(int vaccineCount) {
		this.vaccineCount = vaccineCount;
	}

}
