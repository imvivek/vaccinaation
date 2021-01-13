package com.vaccnow.vaccination.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.vaccnow.vaccination.entity.Branch;
import com.vaccnow.vaccination.repository.BranchRepository;
import com.vaccnow.vaccination.serviceImpl.BranchServiceImpl;

public class BranchServiceTest {
	
	@InjectMocks
	private BranchServiceImpl branchService;
	
	@Mock
	private BranchRepository branchRepository;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllBranches() {
		List<Branch> branches= new ArrayList<>();
		Branch branch = getBranch();
		branches.add(branch);
		Mockito.when(branchRepository.findAll()).thenReturn(branches);
		assertEquals(1, branchService.getAllBranches().get(0).getBranchId());
	}
	
	@Test
	public void testGetAllBranchesException() {
		List<Branch> branches= new ArrayList<>();
		Branch branch = getBranch();
		branches.add(branch);
		Mockito.when(branchRepository.findAll()).thenThrow(new RuntimeException());
	}
	
	private Branch getBranch() {
		Branch branch = new Branch();
		branch.setBranchId(1);
		branch.setBranchName("A");
		branch.setBranchLocation("Delhi");
		return branch;
	}

}
