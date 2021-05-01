package com.Giz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Info_generale;

public interface Info_generaleRepository extends JpaRepository<Info_generale, Long>{
	@Query(value = "SELECT * FROM Info_generale,producteur WHERE Info_generale.code_pro=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Info_generale> findByCodeProd(String code_prod);
	
	@Query(value = "SELECT * FROM Info_generale where code_pro = ?1", nativeQuery = true)
	Optional<Info_generale> existCodeProd(String code_prod);
	
	@Query(value = "SELECT * FROM Info_generale,producteur WHERE Info_generale.code_pro=producteur.code_prod AND"
		    + " producteur.zone = ?1", nativeQuery = true)
	List<Info_generale> ListInfo_generaleAllFkt(String zone);
	
	@Query(value = "SELECT * FROM Info_generale,producteur WHERE Info_generale.code_pro=producteur.code_prod AND"
		    + " producteur.code_fkt = ?1", nativeQuery = true)
	List<Info_generale> ListInfo_generaleAllProd(String code_fkt);
}
