package com.vaccnow.vaccination.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaccnow.vaccination.entity.VaccineBranchId;
import com.vaccnow.vaccination.entity.VaccineBranchRelation;

@Repository
public interface VaccineBranchRelationRepository extends JpaRepository<VaccineBranchRelation, VaccineBranchId> {

	@Transactional
	@Modifying
	@Query("update VaccineBranchRelation vb set vb.vaccineCount = vb.vaccineCount-1 where vb.branch.branchId =:branchId and vb.vaccine.vaccineId =:vaccineId")
	void updateVaccineCountInBranch(Integer branchId, Integer vaccineId);
	
	@Query("select vb.vaccineCount from VaccineBranchRelation vb "
			+ "where vb.vaccine.vaccineId =:vaccineId and vb.branch.branchId =:branchId")
	public Integer findVaccinationCountAtBranch(Integer branchId, Integer vaccineId);

}
