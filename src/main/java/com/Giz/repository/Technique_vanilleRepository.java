package com.Giz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Technique_vanille;

public interface Technique_vanilleRepository extends JpaRepository<Technique_vanille, Long> {
	@Query(value = "SELECT * FROM Technique_vanille,producteur WHERE Technique_vanille.code_pro=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Technique_vanille> findByCodeProd(String code_prod);
	
	@Query(value = "SELECT * FROM Technique_vanille where code_pro = ?1", nativeQuery = true)
	Optional<Technique_vanille> existCodeProd(String code_prod);

	@Query(value = "SELECT * FROM Technique_vanille,producteur WHERE Technique_vanille.code_pro=producteur.code_prod AND"
		    + " producteur.zone = ?1", nativeQuery = true)
	List<Technique_vanille> ListTechnique_vanilleAllFkt(String zone);

	@Query(value = "SELECT * FROM Technique_vanille,producteur WHERE Technique_vanille.code_pro=producteur.code_prod AND"
		    + " producteur.code_fkt = ?1", nativeQuery = true)
	List<Technique_vanille> ListTechnique_vanilleAllProd(String code_fkt);

}
