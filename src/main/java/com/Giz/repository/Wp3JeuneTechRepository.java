package com.Giz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Wp3JeuneTech;

public interface Wp3JeuneTechRepository extends JpaRepository<Wp3JeuneTech, Long> {
	
	@Query("select count(*) from Wp3JeuneTech where lower(sexe)=:sexe")
	long countGenre(String sexe);
	
	@Query(value="select count(*) from wp3_jeune_tech where date_fin_frm1 BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologique(String dateChronologique);
	
	@Query(value="select count(*) from wp3_jeune_tech where lower(sexe)=:sexe and date_fin_frm1 BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologiqueGenre(String dateChronologique, String sexe);

}
