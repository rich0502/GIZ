package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Producteur;

public interface ProducteurRepository extends JpaRepository<Producteur, Long>{
	@Query(value = "SELECT * from producteur GROUP BY producteur.id, producteur.zone ORDER BY producteur.zone", nativeQuery = true)
	List<Producteur> ListZone();
	
	@Query(value = "SELECT * from producteur WHERE producteur.zone=?1  GROUP BY producteur.id, producteur.code_fkt ORDER BY producteur.code_fkt", nativeQuery = true)
	List<Producteur> ListFkt(String zone);
	
	@Query(value = "SELECT * from producteur WHERE producteur.code_fkt=?1 GROUP BY producteur.id, producteur.code_prod ORDER BY producteur.code_prod", nativeQuery = true)
	List<Producteur> ListProd(String code_fkt);
}
