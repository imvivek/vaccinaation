package com.vaccnow.vaccination.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.vaccnow.vaccination.dto.ScheduleDTO;

@Entity
@Table(name = "schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer scheduleId;
	private String scheduleTime;
	private String paymentMode;
	private String scheduleStatus;
	private String paymentStatus;
	private String contactInfo;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "branch_id", nullable = false)
	private Branch branch;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "vaccine_id", nullable = false)
	private Vaccine vaccine;

	public static ScheduleDTO toDTO(Schedule schedule) {
		ScheduleDTO scheduleDTO = new ScheduleDTO();
		scheduleDTO.setScheduleId(schedule.getScheduleId());
		scheduleDTO.setScheduleTime(schedule.getScheduleTime());
		scheduleDTO.setScheduleStatus(schedule.getScheduleStatus());
		scheduleDTO.setPaymentMode(schedule.getPaymentMode());
		scheduleDTO.setPaymentStatus(schedule.getPaymentStatus());
		scheduleDTO.setContactInfo(schedule.getContactInfo());
		scheduleDTO.setVaccine(Vaccine.toDTO(schedule.getVaccine()));
		scheduleDTO.setBranch(Branch.toDTO(schedule.getBranch()));
		return scheduleDTO;
	}

	public static Schedule fromDTO(ScheduleDTO scheduleDTO) {
		Schedule schedule = new Schedule();
		schedule.setScheduleId(scheduleDTO.getScheduleId());
		schedule.setScheduleTime(scheduleDTO.getScheduleTime());
		schedule.setScheduleStatus(scheduleDTO.getScheduleStatus());
		schedule.setPaymentMode(scheduleDTO.getPaymentMode());
		schedule.setPaymentStatus(scheduleDTO.getPaymentStatus());
		schedule.setContactInfo(scheduleDTO.getContactInfo());
		schedule.setBranch(Branch.fromDTO(scheduleDTO.getBranch()));
		schedule.setVaccine(Vaccine.fromDTO(scheduleDTO.getVaccine()));
		return schedule;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
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

	public Integer getScheduleId() {
		return scheduleId;
	}

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

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", scheduleTime=" + scheduleTime + ", paymentMode=" + paymentMode
				+ ", scheduleStatus=" + scheduleStatus + ", paymentStatus=" + paymentStatus + ", contactInfo="
				+ contactInfo + ", branch=" + branch + ", vaccine=" + vaccine + "]";
	}

}
