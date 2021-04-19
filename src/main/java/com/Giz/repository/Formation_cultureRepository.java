package com.Giz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Formation_culture;

public interface Formation_cultureRepository extends JpaRepository<Formation_culture, Long>{
	@Query(value = "SELECT * FROM Formation_culture,producteur WHERE Formation_culture.code_prod=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Formation_culture> findByCodeProd(String code_prod);
	
	@Query(value = "SELECT * FROM Formation_culture where code_prod = ?1", nativeQuery = true)
	Optional<Formation_culture> existCodeProd(String code_prod);
}
