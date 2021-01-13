package com.vaccnow.vaccination.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaccnow.vaccination.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {

	@Override
	public List<Branch> findAll();

	@Query("select b.branchId, b.branchName, b.branchLocation,"
			+ "v.vaccineId, v.vaccineName, v.vaccineCost, vb.vaccineCount from Branch b, VaccineBranchRelation vb,"
			+ " Vaccine v where v.vaccineId = vb.vaccine.vaccineId and b.branchId =:branchId and vb.branch.branchId =:branchId")
	public List<Object> findVaccinationByBranchId(Integer branchId);

	@Query("select b.branchId, b.branchName, b.branchLocation,"
			+ " v.vaccineId, v.vaccineName, v.vaccineCost, vb.vaccineCount from Branch b join VaccineBranchRelation vb"
			+ " on b.branchId = vb.branch.branchId join Vaccine v on v.vaccineId = vb.vaccine.vaccineId")
	public List<Object> findAllAvailableVaccines();
	
}
