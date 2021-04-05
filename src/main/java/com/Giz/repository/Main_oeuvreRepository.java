package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Main_oeuvre;

public interface Main_oeuvreRepository extends JpaRepository<Main_oeuvre, Long> {

	@Query(value = "SELECT * FROM Main_oeuvre,producteur WHERE Main_oeuvre.code_prod=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Main_oeuvre> findByCodeProd(String code_prod);
}
