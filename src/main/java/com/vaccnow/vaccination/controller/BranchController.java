package com.vaccnow.vaccination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaccnow.vaccination.constant.Constant;
import com.vaccnow.vaccination.model.BranchModel;
import com.vaccnow.vaccination.service.IBranchService;

@RestController
@RequestMapping(Constant.ROOT_PATH +"/branches")
public class BranchController {
	
	@Autowired
	private IBranchService branchService;

	@GetMapping
	public @ResponseBody ResponseEntity<List<BranchModel>> getAllBranches() {
		List<BranchModel> branches = BranchModel.fromDTO(branchService.getAllBranches());
		return new ResponseEntity<List<BranchModel>>(branches, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{branchId}")
	public @ResponseBody ResponseEntity<List<BranchModel>> getVaccinationByBranchId(@PathVariable Integer branchId ) {
		List<BranchModel> branches = BranchModel.fromDTO(branchService.getVaccinationByBranchId(branchId));
		return new ResponseEntity<List<BranchModel>>(branches, HttpStatus.OK);
	}
	
	@GetMapping(value = "/vaccines")
	public @ResponseBody ResponseEntity<List<BranchModel>> getAllAvailableVaccines() {
		List<BranchModel> branches = BranchModel.fromDTO(branchService.getAllAvailableVaccines());
		return new ResponseEntity<List<BranchModel>>(branches, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{branchId}/timeslots")
	public @ResponseBody ResponseEntity<List<String>> getAvailableTimeForBranch(@PathVariable Integer branchId ) {
		List<String> timeSlots = branchService.getAvailableTimeForBranch(branchId);
		return new ResponseEntity<List<String>>(timeSlots, HttpStatus.OK);
	}
}
