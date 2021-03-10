package com.Giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Recherche;


public interface RechercheRepository extends JpaRepository<Recherche, Long> {
	//liste des Beneficiaires
	@Query("SELECT e FROM Recherche e")
	List<Recherche> fetchRechercheData();
	
	@Modifying
    @Transactional
    @Query("delete from Recherche e where id_re = ?1")
    void deleteRecherche(Long id_re);
	
	@Query("SELECT f FROM Recherche f WHERE f.id_re = ?1")
	Recherche findByIdRecherche(Long id_re);
	
	
	
}

