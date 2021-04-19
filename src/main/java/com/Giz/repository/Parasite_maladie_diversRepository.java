package com.Giz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Parasite_maladie_divers;

public interface Parasite_maladie_diversRepository extends JpaRepository<Parasite_maladie_divers, Long>{
	@Query(value = "SELECT * FROM Parasite_maladie_divers,producteur WHERE Parasite_maladie_divers.code_prod=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Parasite_maladie_divers> findByCodeProd(String code_prod);
	
	@Query(value = "SELECT * FROM Parasite_maladie_divers where code_prod = ?1", nativeQuery = true)
	Optional<Parasite_maladie_divers> existCodeProd(String code_prod);
}
