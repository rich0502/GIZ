package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Giz.data.domain.Valider;

@Repository
public interface ValiderRepository extends JpaRepository<Valider, Long>{
	
	@Query("SELECT v FROM Valider v where  canevas = 'L3'")
	List<Valider> findAllL3();
	
	@Query("SELECT v FROM Valider v where  canevas = 'VSLA'")
	List<Valider> findAllVSLA();
	
	@Query("SELECT v FROM Valider v where  canevas = 'FBS'")
	List<Valider> findAllFBS();
	
	@Query("SELECT v FROM Valider v where  canevas = 'Mobile'")
	List<Valider> findAllMobileMoney();
	
	@Query("SELECT v FROM Valider v where  canevas = 'Finance'")
	List<Valider> findAllFinance();
	
	@Query("SELECT v FROM Valider v  where  canevas = 'Producteur'")
	List<Valider> findAllProducteur();
	
	@Query("SELECT v FROM Valider v where  canevas = 'Adhesion'")
	List<Valider> findAllAdhesion();
	
	@Query("SELECT v  FROM Valider v where  canevas = 'Menage'")
	List<Valider> findAllMenage();

}
