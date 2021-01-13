package com.vaccnow.vaccination.dto;

public class VaccineDTO {
	private Integer vaccineId;
	private String vaccineCode;
	private String vaccineName;
	private String vaccineCost;
	private String vaccineCountry;
	
	public Integer getVaccineId() {
		return vaccineId;
	}
	public void setVaccineId(Integer vaccineId) {
		this.vaccineId = vaccineId;
	}
	public String getVaccineCode() {
		return vaccineCode;
	}
	public void setVaccineCode(String vaccineCode) {
		this.vaccineCode = vaccineCode;
	}
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	public String getVaccineCost() {
		return vaccineCost;
	}
	public void setVaccineCost(String vaccineCost) {
		this.vaccineCost = vaccineCost;
	}
	public String getVaccineCountry() {
		return vaccineCountry;
	}
	public void setVaccineCountry(String vaccineCountry) {
		this.vaccineCountry = vaccineCountry;
	}
	@Override
	public String toString() {
		return "VaccineDTO [vaccineId=" + vaccineId + ", vaccineCode=" + vaccineCode + ", vaccineName=" + vaccineName
				+ ", vaccineCost=" + vaccineCost + ", vaccineCountry=" + vaccineCountry + "]";
	}

}
