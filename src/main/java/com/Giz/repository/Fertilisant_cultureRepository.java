package com.Giz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Fertilisant_culture;

public interface Fertilisant_cultureRepository extends JpaRepository<Fertilisant_culture, Long> {
	@Query(value = "SELECT * FROM Fertilisant_culture,producteur WHERE Fertilisant_culture.code_pro=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Fertilisant_culture> findByCodeProd(String code_prod);
	
	@Query(value = "SELECT * FROM Fertilisant_culture where code_pro = ?1", nativeQuery = true)
	Optional<Fertilisant_culture> existCodeProd(String code_prod);
	
	@Query(value = "SELECT * FROM Fertilisant_culture,producteur WHERE Fertilisant_culture.code_pro=producteur.code_prod AND"
		    + " producteur.zone = ?1", nativeQuery = true)
	List<Fertilisant_culture> ListFertilisant_cultureAllFkt(String zone);
	
	@Query(value = "SELECT * FROM Fertilisant_culture,producteur WHERE Fertilisant_culture.code_pro=producteur.code_prod AND"
		    + " producteur.code_fkt = ?1", nativeQuery = true)
	List<Fertilisant_culture> ListFertilisant_cultureAllProd(String code_fkt);
}
