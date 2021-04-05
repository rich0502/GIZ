package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Info_parcelle_divers;

public interface Info_parcelle_diversRepository extends JpaRepository<Info_parcelle_divers, Long> {
	@Query(value = "SELECT * FROM Info_parcelle_divers,producteur WHERE Info_parcelle_divers.code_prod=producteur.code_prod AND"
		    + " producteur.code_prod = ?1", nativeQuery = true)
	List<Info_parcelle_divers> findByCodeProd(String code_prod);
}
