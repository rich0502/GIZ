package com.Giz.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.AtelierMFR;
import com.Giz.data.domain.Beneficiaire;


public interface AtelierMFRRepository extends JpaRepository<AtelierMFR, Long> {
	
	@Query("SELECT e FROM AtelierMFR e where type_atelier = ?1")
	List<AtelierMFR> fetchAtelier(String type_atelier);
}

