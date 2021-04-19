package com.Giz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Info_parcelle;

public interface Info_parcelleRepository extends JpaRepository<Info_parcelle, Long>{
	@Query(value = "SELECT * FROM Info_parcelle,producteur WHERE Info_parcelle.code_prod=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Info_parcelle> findByCodeProd(String code_prod);
	
	@Query(value = "SELECT * FROM Info_parcelle where code_prod = ?1", nativeQuery = true)
	Optional<Info_parcelle> existCodeProd(String code_prod);
}
