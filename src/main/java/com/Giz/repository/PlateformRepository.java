package com.Giz.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.AtelierMFR;
import com.Giz.data.domain.Beneficiaire;
import com.Giz.data.domain.Plateforme;


public interface PlateformRepository extends JpaRepository<Plateforme, Long> {
	
	@Query("SELECT e FROM Plateforme e where type_plateform = ?1")
	List<Plateforme> fetchPlateforme(String type_plateform);
}

