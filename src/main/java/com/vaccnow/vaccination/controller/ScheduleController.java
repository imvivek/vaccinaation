package com.vaccnow.vaccination.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaccnow.vaccination.constant.Constant;
import com.vaccnow.vaccination.dto.ScheduleDTO;
import com.vaccnow.vaccination.model.ScheduleModel;
import com.vaccnow.vaccination.service.IMailService;
import com.vaccnow.vaccination.service.IScheduleService;

@RestController
@RequestMapping(Constant.ROOT_PATH + "/schedules")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ScheduleController {

	@Autowired
	private IScheduleService scheduleService;

	@Autowired
	private IMailService mailService;

	@GetMapping
	public @ResponseBody ResponseEntity<List<ScheduleModel>> getAllSchedule() {
		List<ScheduleModel> schedules = ScheduleModel.fromDTO(scheduleService.getAllSchedule());
		return new ResponseEntity<List<ScheduleModel>>(schedules, HttpStatus.OK);
	}

	@PostMapping
	public @ResponseBody ResponseEntity<Object> saveSchedule(@RequestBody ScheduleModel scheduleModel) {
		ScheduleDTO scheduleDTO = scheduleService.saveSchedule(ScheduleModel.toDTO(scheduleModel));
		ScheduleModel response = ScheduleModel.fromDTO(scheduleDTO);
		mailService.sendEmail(scheduleDTO);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

}
