package com.vaccnow.vaccination.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.vaccnow.vaccination.dto.BranchDTO;
import com.vaccnow.vaccination.service.IBranchService;

@SpringBootTest
public class BranchControllerTest {

	@InjectMocks
	private BranchController branchController;

	@Mock
	private IBranchService branchService;

	@Test
	public void testGetAllBranches() {
		List<BranchDTO> branches = new ArrayList<>();
		BranchDTO branchDTO = getBranchDTO();
		branches.add(branchDTO);
		Mockito.when(branchService.getAllBranches()).thenReturn(branches);
		assertEquals(1, branchController.getAllBranches().getBody().get(0).getBranchId());
	}

	@Test
	public void testGetAllBranchesException() {
		Mockito.when(branchService.getAllBranches()).thenThrow(new RuntimeException());
	}

	private BranchDTO getBranchDTO() {
		BranchDTO branchDTO = new BranchDTO();
		branchDTO.setBranchId(1);
		branchDTO.setBranchName("A");
		branchDTO.setBranchLocation("Delhi");
		return branchDTO;
	}

}
