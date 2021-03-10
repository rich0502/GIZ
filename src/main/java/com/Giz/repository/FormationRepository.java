package com.Giz.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Formation;


public interface FormationRepository extends JpaRepository<Formation, Long> {
	//liste des Beneficiaires
	@Query("SELECT e FROM Formation e")
	List<Formation> fetchFormationData();
	
	@Modifying
    @Transactional
    @Query("delete from Formation e where id_form = ?1")
    void deleteFormation(Long id_form);
	
	@Query("SELECT f FROM Formation f WHERE f.id_form = ?1")
	Formation findByIdFormation(Long id_form);
	
	
}

