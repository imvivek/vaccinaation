package com.vaccnow.vaccination.entity;

import java.io.Serializable;

public class VaccineBranchId implements Serializable {

	private static final long serialVersionUID = 1L;

	private int branch;
	private int vaccine;

	public int getBranch() {
		return branch;
	}

	public void setBranch(int branch) {
		this.branch = branch;
	}

	public int getVaccine() {
		return vaccine;
	}

	public void setVaccine(int vaccine) {
		this.vaccine = vaccine;
	}

}
