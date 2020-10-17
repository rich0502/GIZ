package com.Giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.District;


public interface DistrictRepository extends JpaRepository<District, Long> {
	//liste des Beneficiaires
	@Query("SELECT e FROM District e")
	List<District> fetchDistrictData();
	
	
	
}

