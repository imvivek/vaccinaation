package com.vaccnow.vaccination.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;

import com.vaccnow.vaccination.dto.ScheduleDTO;
import com.vaccnow.vaccination.enums.ScheduleStatus;

public class ScheduleModel {

	private Integer scheduleId;
	private String scheduleTime;
	private String paymentMode;
	private String scheduleStatus;
	private String paymentStatus;
	@Email
	private String contactInfo;
	private BranchModel branch;
	private VaccineModel vaccine;

	public BranchModel getBranch() {
		return branch;
	}

	public void setBranch(BranchModel branch) {
		this.branch = branch;
	}

	public VaccineModel getVaccine() {
		return vaccine;
	}

	public void setVaccine(VaccineModel vaccine) {
		this.vaccine = vaccine;
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getScheduleStatus() {
		return scheduleStatus;
	}

	public void setScheduleStatus(String scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public static List<ScheduleModel> fromDTO(List<ScheduleDTO> allSchedule) {
		return allSchedule.stream().map(ScheduleModel::fromDTO).collect(Collectors.toList());
	}

	public static ScheduleModel fromDTO(ScheduleDTO scheduleDTO) {
		ScheduleModel schedule = new ScheduleModel();
		schedule.setScheduleId(scheduleDTO.getScheduleId());
		schedule.setScheduleTime(scheduleDTO.getScheduleTime());
		schedule.setScheduleStatus(scheduleDTO.getScheduleStatus());
		schedule.setPaymentMode(scheduleDTO.getPaymentMode());
		schedule.setPaymentStatus(scheduleDTO.getPaymentStatus());
		schedule.setContactInfo(scheduleDTO.getContactInfo());
		schedule.setBranch(BranchModel.fromDTO(scheduleDTO.getBranch()));
		schedule.setVaccine(VaccineModel.fromDTO(scheduleDTO.getVaccine()));
		return schedule;
	}

	public static ScheduleDTO toDTO(ScheduleModel schedule) {
		ScheduleDTO scheduleDTO = new ScheduleDTO();
		scheduleDTO.setScheduleId(schedule.getScheduleId());
		
		scheduleDTO.setBranch(BranchModel.toDTO(schedule.getBranch()));
		scheduleDTO.setVaccine(VaccineModel.toDTO(schedule.getVaccine()));
		
		scheduleDTO.setScheduleTime(schedule.getScheduleTime());
		scheduleDTO.setScheduleStatus(schedule.getScheduleStatus());
		scheduleDTO.setPaymentMode(schedule.getPaymentMode());
		scheduleDTO.setPaymentStatus(schedule.getPaymentStatus());
		scheduleDTO.setContactInfo(schedule.getContactInfo());
		return scheduleDTO;
	}
}
