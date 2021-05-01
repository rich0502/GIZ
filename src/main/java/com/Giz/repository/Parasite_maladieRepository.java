package com.Giz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Parasite_maladie;

public interface Parasite_maladieRepository extends JpaRepository<Parasite_maladie, Long>{
	@Query(value = "SELECT * FROM Parasite_maladie,producteur WHERE Parasite_maladie.code_prod=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Parasite_maladie> findByCodeProd(String code_prod);
	
	@Query(value = "SELECT * FROM Parasite_maladie where code_prod = ?1", nativeQuery = true)
	Optional<Parasite_maladie> existCodeProd(String code_prod);

	@Query(value = "SELECT * FROM Parasite_maladie,producteur WHERE Parasite_maladie.code_prod=producteur.code_prod AND"
		    + " producteur.zone = ?1", nativeQuery = true)
	List<Parasite_maladie> ListParasite_maladieAllFkt(String zone);

	@Query(value = "SELECT * FROM Parasite_maladie,producteur WHERE Parasite_maladie.code_prod=producteur.code_prod AND"
		    + " producteur.code_fkt = ?1", nativeQuery = true)
	List<Parasite_maladie> ListParasite_maladieAllProd(String code_fkt);
}
