package com.Giz.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Wp3JeunePathway;

public interface Wp3JeunePathwayRepository extends JpaRepository<Wp3JeunePathway, Long> {
	
	@Query("select count(*) from Wp3JeunePathway where existance_agr = 'true'")
	long countAll();
	
	@Query("select count(*) from Wp3JeunePathway where existance_agr = 'true' and lower(sexe)=:sexe")
	long countGenre(String sexe);
	
	@Query(value="select count(*) from wp3_jeune_pathway where existance_agr = 'true'  and date_fin_frm BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologie(String dateChronologique);
	
	@Query(value="select count(*) from wp3_jeune_pathway where existance_agr = 'true' and lower(sexe)=:sexe  and date_fin_frm BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologieGenre(String dateChronologique, String sexe);
	
	//graphe
	
	@Query(value = "SELECT count(*) as y FROM wp3_jeune_pathway WHERE date_fin_frm BETWEEN :debut_date AND :fin_date", nativeQuery = true)
	long SomTotal(java.util.Date debut_date,java.util.Date fin_date);

	@Query(value = "SELECT village.district,count(village.district) as y from village,wp3_jeune_pathway where village.code_village=wp3_jeune_pathway.code_village group by village.district", nativeQuery = true)
	List<Object[]> fetchData();

	//count
	@Query(value = "SELECT count(village.district) as y from village,wp3_jeune_pathway WHERE village.code_village=wp3_jeune_pathway.code_village", nativeQuery = true)
	long CamembertTot();

	@Query(value = "SELECT e.date_fin_frm as x,count(e.nom_prenom) as y FROM wp3_jeune_pathway e WHERE e.date_fin_frm BETWEEN ?1 AND ?2 GROUP BY e.date_fin_frm ORDER BY e.date_fin_frm ASC", nativeQuery = true)
	List<Object[]> TpsData(Date debut_date,Date fin_date);

}
