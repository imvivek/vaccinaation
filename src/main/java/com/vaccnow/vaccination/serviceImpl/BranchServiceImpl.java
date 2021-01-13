package com.vaccnow.vaccination.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccnow.vaccination.dto.BranchDTO;
import com.vaccnow.vaccination.dto.VaccineBranchStatusDTO;
import com.vaccnow.vaccination.entity.Branch;
import com.vaccnow.vaccination.repository.BranchRepository;
import com.vaccnow.vaccination.repository.ScheduleRepository;
import com.vaccnow.vaccination.service.IBranchService;

@Service
public class BranchServiceImpl implements IBranchService{

	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	

	@Override
	public List<BranchDTO> getAllBranches() {
		List<Branch> branches = branchRepository.findAll();
		return branches.stream().map(Branch::toDTO).collect(Collectors.toList());
	}

	@Override
	public List<BranchDTO> getVaccinationByBranchId(Integer branchId) {
		List<Object> branches = branchRepository.findVaccinationByBranchId(branchId);
		if(branches.size() > 0) {
			return branchVaccineMapper(branches);
		}
		return Collections.emptyList();
	}

	@Override
	public List<BranchDTO> getAllAvailableVaccines() {
		List<Object> branches = branchRepository.findAllAvailableVaccines();
		if(branches.size() > 0) {
			return branchVaccineMapper(branches);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<String> getAvailableTimeForBranch(Integer branchId) {
		List<String> bookedTimeSlots = scheduleRepository.findAvailableTimeSlotForBranch(branchId);
		List<String> availableTimeSlots = getTimeSet(false);
		availableTimeSlots.removeAll(bookedTimeSlots);
		return availableTimeSlots;
	}
	
	private List<BranchDTO> branchVaccineMapper(List<Object> branches) {
		List<BranchDTO> branhesList =  new ArrayList<BranchDTO>();
		for (Object object : branches) {
			Object[] values = (Object[]) object;
			BranchDTO branch = new BranchDTO();
			branch.setBranchId((Integer)values[0]);
			branch.setBranchName(values[1].toString());
			branch.setBranchLocation(values[2].toString());
			
			VaccineBranchStatusDTO vaccineBranchStatus = new VaccineBranchStatusDTO();
			vaccineBranchStatus.setVaccineId((Integer)values[3]);
			vaccineBranchStatus.setVaccineName(values[4].toString());
			vaccineBranchStatus.setVaccineCost(values[5].toString());
			vaccineBranchStatus.setVaccineCount((Integer)values[6]);
			
			branch.setVaccineBranchStatus(vaccineBranchStatus);
			branhesList.add(branch);
		}
		return branhesList;
	}
	
	private List<String> getTimeSet(boolean isCurrentDay) {
        List<String> results = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        if(!isCurrentDay)
            calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        for (int i = 0; i < 32; i++) {
            String  day1 = sdf.format(calendar.getTime());
            // add 15 minutes to the current time; the hour adjusts automatically!
            calendar.add(Calendar.MINUTE, 15);
            String day2 = sdf.format(calendar.getTime());
            String day = day1 + " - " + day2;
            results.add(i, day);
        }
        return results;
    }
	
}
