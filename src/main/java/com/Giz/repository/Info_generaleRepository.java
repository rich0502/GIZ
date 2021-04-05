package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Info_generale;

public interface Info_generaleRepository extends JpaRepository<Info_generale, Long>{
	@Query(value = "SELECT * FROM Info_generale,producteur WHERE Info_generale.code_pro=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Info_generale> findByCodeProd(String code_prod);
}
