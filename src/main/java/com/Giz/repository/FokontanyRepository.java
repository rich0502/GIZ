package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Fokontany;

public interface FokontanyRepository extends JpaRepository<Fokontany, Long> {
	//liste des Beneficiaires
	@Query("SELECT e FROM Fokontany e")
	List<Fokontany> fetchFokontanyData();
	
	
	
}

