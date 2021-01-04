package com.Giz.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Wp3AgrDevMfr;

public interface Wp3AgrDevMfrRepository extends JpaRepository<Wp3AgrDevMfr, Long> {
	@Query("Select count(*) from Wp3AgrDevMfr where lower(sexe)=:sexe")
	long countGenre(String sexe);
	
	@Query(value="select count(*) from wp3_agr_deev_mfr where date_eval BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologie(String dateChronologique);
	
	@Query(value="select count(*) from wp3_agr_deev_mfr where lower(sexe)=:sexe and date_eval BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologieGenre(String dateChronologique, String sexe);
	
	//graphe
	
	@Query(value = "SELECT count(*) as y FROM wp3_agr_deev_mfr WHERE date_suivi1 BETWEEN :debut_date AND :fin_date", nativeQuery = true)
	long SomTotal(java.util.Date debut_date,java.util.Date fin_date);

	@Query(value = "SELECT village.district,count(village.district) as y from village,wp3_agr_deev_mfr where village.code_village=wp3_agr_deev_mfr.code_village group by village.district", nativeQuery = true)
	List<Object[]> fetchData();

	//count
	@Query(value = "SELECT count(village.district) as y from village,wp3_agr_deev_mfr WHERE village.code_village=wp3_agr_deev_mfr.code_village", nativeQuery = true)
	long CamembertTot();

	@Query(value = "SELECT e.date_suivi1 as x,count(e.nom_mfr) as y FROM wp3_agr_deev_mfr e WHERE e.date_suivi1 BETWEEN ?1 AND ?2 GROUP BY e.date_suivi1 ORDER BY e.date_suivi1 ASC", nativeQuery = true)
	List<Object[]> TpsData(Date debut_date,Date fin_date);
	
}
