package com.Giz.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Beneficiaire;


public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, Long> {
	//liste des Beneficiaires
	@Query("SELECT e FROM Beneficiaire e")
	List<Beneficiaire> fetchBeneficiaireData();
	
	@Modifying
    @Transactional
    @Query("delete from Beneficiaire e where id_bf = ?1")
    void deleteBeneficiaire(Long id_bf);
	
	@Query("SELECT f FROM Beneficiaire f WHERE f.id_bf = ?1")
	Beneficiaire findByIdBeneficiaire(Long id_bf);
	
	
}

