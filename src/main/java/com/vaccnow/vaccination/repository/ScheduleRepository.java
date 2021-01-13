package com.vaccnow.vaccination.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaccnow.vaccination.entity.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

	@Query("select s from Schedule s where s.scheduleStatus ='OPEN'")
	public List<Schedule> findAllOpenSchedule();

	@Query("select s.scheduleTime from Schedule s where s.branch.branchId =:branchId and s.scheduleStatus ='OPEN'")
	public List<String> findAvailableTimeSlotForBranch(Integer branchId);

	@Query("select s from Schedule s where s.branch.branchId =:branchId and s.scheduleStatus ='DONE'")
	public List<Schedule> findAppliedVaccinationAtBranch(Integer branchId);

	@Query("select s from Schedule s where s.scheduleStatus ='DONE'")
	public List<Schedule> findAppliedVaccination();

}
