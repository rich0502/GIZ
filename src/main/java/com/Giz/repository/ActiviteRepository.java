package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Long>{

	@Query(value = "SELECT producteur.nom_prod,producteur.genre,producteur.date_naissance FROM producteur WHERE producteur.nom_prod IN (null, ?1)", nativeQuery = true)
	List<Object[]> ListActiviteProd(List<String> params);
	
	@Query(value = "SELECT * FROM Activite WHERE Activite.type_intervention = ?1 AND Activite.theme_principal = ?2 AND Activite.sous_theme = ?3", nativeQuery = true)
	List<Activite> ListActiviteFind(String type_intervention, String theme_principal, String sous_theme);

}
