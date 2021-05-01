package com.Giz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Main_oeuvre;

public interface Main_oeuvreRepository extends JpaRepository<Main_oeuvre, Long> {

	@Query(value = "SELECT * FROM Main_oeuvre,producteur WHERE Main_oeuvre.code_prod=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Main_oeuvre> findByCodeProd(String code_prod);
	
	@Query(value = "SELECT * FROM Main_oeuvre where code_prod = ?1", nativeQuery = true)
	Optional<Main_oeuvre> existCodeProd(String code_prod);
	
	@Query(value = "SELECT * FROM Main_oeuvre,producteur WHERE Main_oeuvre.code_prod=producteur.code_prod AND"
		    + " producteur.zone = ?1", nativeQuery = true)
	List<Main_oeuvre> ListMain_oeuvreAllFkt(String zone);
	
	@Query(value = "SELECT * FROM Main_oeuvre,producteur WHERE Main_oeuvre.code_prod=producteur.code_prod AND"
		    + " producteur.code_fkt = ?1", nativeQuery = true)
	List<Main_oeuvre> ListMain_oeuvreAllProd(String code_fkt);
}
