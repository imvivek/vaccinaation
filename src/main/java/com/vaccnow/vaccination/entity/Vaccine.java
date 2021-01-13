package com.vaccnow.vaccination.entity;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.vaccnow.vaccination.dto.VaccineDTO;

@Entity
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vaccine_id")
	private Integer vaccineId;
	private String vaccineCode;
	private String vaccineName;
	private String vaccineCost;
	private String vaccineCountry;
	
	@OneToMany(mappedBy = "vaccine")
	private List<VaccineBranchRelation> vaccineBranchStatus;

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

	public List<VaccineBranchRelation> getVaccineBranchStatus() {
		return vaccineBranchStatus;
	}

	public void setVaccineBranchStatus(List<VaccineBranchRelation> vaccineBranchStatus) {
		this.vaccineBranchStatus = vaccineBranchStatus;
	}

	public static VaccineDTO toDTO(Vaccine vaccine) {
		VaccineDTO vaccineDTO = new VaccineDTO();
		vaccineDTO.setVaccineName(vaccine.getVaccineName());
		vaccineDTO.setVaccineCost(vaccine.getVaccineCost());
		vaccineDTO.setVaccineCode(vaccine.getVaccineCode());
		vaccineDTO.setVaccineCountry(vaccine.getVaccineCountry());
		vaccineDTO.setVaccineId(vaccine.getVaccineId());
		return vaccineDTO;
	}

	public static Vaccine fromDTO(VaccineDTO vaccineDTO) {
		Vaccine vaccine = new Vaccine();
		vaccine.setVaccineId(vaccineDTO.getVaccineId());
		vaccine.setVaccineCode(vaccineDTO.getVaccineCode());
		vaccine.setVaccineCost(vaccineDTO.getVaccineCost());
		vaccine.setVaccineName(vaccineDTO.getVaccineName());
		vaccine.setVaccineCountry(vaccineDTO.getVaccineCountry());
		return vaccine;
	}

}
