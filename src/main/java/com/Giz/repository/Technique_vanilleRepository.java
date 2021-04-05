package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Technique_vanille;

public interface Technique_vanilleRepository extends JpaRepository<Technique_vanille, Long> {
	@Query(value = "SELECT * FROM Technique_vanille,producteur WHERE Technique_vanille.code_pro=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Technique_vanille> findByCodeProd(String code_prod);
}
