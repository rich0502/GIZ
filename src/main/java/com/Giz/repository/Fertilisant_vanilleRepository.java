package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Fertilisant_vanille;

public interface Fertilisant_vanilleRepository extends JpaRepository<Fertilisant_vanille, Long> {
	@Query(value = "SELECT * FROM Fertilisant_vanille,producteur WHERE Fertilisant_vanille.code_pro=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Fertilisant_vanille> findByCodeProd(String code_prod);
}
