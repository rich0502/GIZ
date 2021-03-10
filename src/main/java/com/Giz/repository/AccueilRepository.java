package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Accueil;

public interface AccueilRepository extends JpaRepository<Accueil, Long>{
	//liste des articles à l'accueil
	@Query("SELECT e FROM Accueil e")
	List<Accueil> fetchAccueilData();
		
	@Query("SELECT f FROM Accueil f WHERE f.id_acc = ?1")
	Accueil findByIdAccueil(Long id_acc);
}
