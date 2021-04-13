package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Producteur;

public interface ProducteurRepository extends JpaRepository<Producteur, Long>{
	@Query(value = "SELECT producteur.zone from producteur GROUP BY producteur.zone ORDER BY producteur.zone", nativeQuery = true)
	List<Object[]> ListZone();
	
	@Query(value = "SELECT producteur.code_fkt from producteur WHERE producteur.zone=?1  GROUP BY producteur.code_fkt ORDER BY producteur.code_fkt", nativeQuery = true)
	List<Object[]> ListFkt(String zone);
	
	@Query(value = "SELECT producteur.code_prod, producteur.nom_prod from producteur WHERE producteur.code_fkt=?1 ORDER BY producteur.code_prod", nativeQuery = true)
	List<Object[]> ListProd(String code_fkt);
	
	@Query(value = "SELECT * FROM producteur WHERE producteur.date_inspection IS NOT NULL ORDER BY producteur.zone", nativeQuery = true)
	List<Producteur> ListProducteur();
}
