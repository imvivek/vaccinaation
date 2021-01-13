package com.vaccnow.vaccination.dto;

public class ScheduleDTO {
	
	private Integer scheduleId;
	private String scheduleTime;
	private String paymentMode;
	private String scheduleStatus;
	private String paymentStatus;
	private String contactInfo;
	private VaccineDTO vaccine;
	private BranchDTO branch;

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
	
	public VaccineDTO getVaccine() {
		return vaccine;
	}

	public void setVaccine(VaccineDTO vaccine) {
		this.vaccine = vaccine;
	}

	public BranchDTO getBranch() {
		return branch;
	}

	public void setBranch(BranchDTO branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "ScheduleDTO [scheduleId=" + scheduleId + ", scheduleTime=" + scheduleTime + ", paymentMode="
				+ paymentMode + ", scheduleStatus=" + scheduleStatus + ", paymentStatus=" + paymentStatus
				+ ", contactInfo=" + contactInfo + ", vaccine=" + vaccine.toString() + ", branch=" + branch.toString() + "]";
	}
	
}
