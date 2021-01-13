package com.vaccnow.vaccination.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaccnow.vaccination.entity.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {

	@Override
	public List<Vaccine> findAll();
	
}
