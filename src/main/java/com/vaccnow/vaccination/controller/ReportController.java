package com.vaccnow.vaccination.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaccnow.vaccination.constant.Constant;
import com.vaccnow.vaccination.model.ReportModel;
import com.vaccnow.vaccination.service.IReportService;

@RestController
@RequestMapping(Constant.ROOT_PATH + "/reports")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReportController {
	
	@Autowired
	private IReportService reportService;

	
	@GetMapping(value = "/{branchId}")
	public @ResponseBody ResponseEntity<List<ReportModel>> getVaccinationByBranchId(@PathVariable Integer branchId ) {
		List<ReportModel> branches = ReportModel.fromDTO(reportService.getAppliedVaccinationAtBranch(branchId));
		return new ResponseEntity<List<ReportModel>>(branches, HttpStatus.OK);
	}
	
	@GetMapping(value = "/vaccines")
	public @ResponseBody ResponseEntity<List<ReportModel>> getAllAppliedVaccination() {
		List<ReportModel> branches = ReportModel.fromDTO(reportService.getAllAppliedVaccination());
		return new ResponseEntity<List<ReportModel>>(branches, HttpStatus.OK);
	}

}
