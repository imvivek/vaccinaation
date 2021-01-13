package com.vaccnow.vaccination.model;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vaccnow.vaccination.dto.VaccineDTO;

public class VaccineModel {

	private Integer vaccineId;

	@JsonInclude(value = Include.NON_NULL)
	private String vaccineCode;

	private String vaccineName;

	private String vaccineCost;

	@JsonInclude(value = Include.NON_NULL)
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

	public static VaccineModel fromDTO(VaccineDTO vaccineDTO) {
		VaccineModel vaccineModel = new VaccineModel();

		vaccineModel.setVaccineCode(vaccineDTO.getVaccineCode());
		vaccineModel.setVaccineName(vaccineDTO.getVaccineName());
		vaccineModel.setVaccineCost(vaccineDTO.getVaccineCost());
		vaccineModel.setVaccineCountry(vaccineDTO.getVaccineCountry());
		vaccineModel.setVaccineId(vaccineDTO.getVaccineId());
		return vaccineModel;
	}

	public static VaccineDTO toDTO(VaccineModel vaccine) {
		VaccineDTO vaccineDTO = new VaccineDTO();
		vaccineDTO.setVaccineId(vaccine.getVaccineId());
		vaccineDTO.setVaccineCode(vaccine.getVaccineCode());
		vaccineDTO.setVaccineCost(vaccine.getVaccineCost());
		vaccineDTO.setVaccineCountry(vaccine.getVaccineCountry());
		vaccineDTO.setVaccineName(vaccine.getVaccineName());
		return vaccineDTO;
	}

	public static List<VaccineModel> fromDTO(List<VaccineDTO> vaccines) {
		return vaccines.stream().map(VaccineModel :: fromDTO).collect(Collectors.toList());
	}
}
