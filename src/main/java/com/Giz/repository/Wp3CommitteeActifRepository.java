package com.Giz.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Wp3CommitteeActif;

public interface Wp3CommitteeActifRepository extends JpaRepository<Wp3CommitteeActif, Long> {
	
	@Query("select count(*) from Wp3CommitteeActif where lower(sexe)=:sexe")
	long countGenre(String sexe);
	
	@Query(value="select count(*) from wp3_committee_actif where date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologe(String dateChronologique);
	
	@Query(value="select count(*) from wp3_committee_actif where lower(sexe)=:sexe and date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologeGenre(String dateChronologique, String sexe);
	
	@Query(value="Select sum(sexe_f) as femme from wp3_committee_actif where  date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long getCountFemme(String dateChronologique);
	
	@Query(value="Select CASE WHEN sum(sexe_f) >= 1 THEN true ELSE false END from wp3_committee_actif where date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	boolean getCountFemmeIsExist(String dateChronologique);
	
	
	@Query(value="Select sum(sexe_h) as homme from wp3_committee_actif where date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long getCountHomme(String dateChronologique);
	
	@Query(value="Select CASE WHEN sum(sexe_h) >= 1 THEN true ELSE false END from wp3_committee_actif where date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	boolean getCountHommeIsExist(String dateChronologique);
	
	
	@Modifying
    @Transactional
    @Query("delete from Wp3CommitteeActif e where id = ?1")
    void deleteWp3CommitteeActif(Long id);
	
	//graphe
	
	@Query(value = "SELECT count(*) as y FROM wp3_committee_actif WHERE date_suivi BETWEEN :debut_date AND :fin_date", nativeQuery = true)
	long SomTotal(java.util.Date debut_date,java.util.Date fin_date);

	@Query(value = "SELECT village.district,count(village.district) as y from village,wp3_committee_actif where village.code_village=wp3_committee_actif.code_village group by village.district", nativeQuery = true)
	List<Object[]> fetchData();

	//count
	@Query(value = "SELECT count(village.district) as y from village,wp3_committee_actif WHERE village.code_village=wp3_committee_actif.code_village", nativeQuery = true)
	long CamembertTot();

	@Query(value = "SELECT e.date_suivi as x,sum(e.effectif_membre) as y FROM wp3_committee_actif e WHERE e.date_suivi BETWEEN ?1 AND ?2 GROUP BY e.date_suivi ORDER BY e.date_suivi ASC", nativeQuery = true)
	List<Object[]> TpsData(Date debut_date,Date fin_date);
	
	//tableau
	
	@Query(value = "SELECT village.code_village,village.village,sum(wp3_committee_actif.sexe_h) as H,sum(wp3_committee_actif.sexe_f) as F FROM village,wp3_committee_actif WHERE village.code_village=wp3_committee_actif.code_village AND wp3_committee_actif.code_village "
			+ " IN (null, ?3) AND wp3_committee_actif.date_suivi BETWEEN ?1 AND ?2 \r\n" + 
			"GROUP BY village.code_village,village.village", nativeQuery = true)
	List<Object[]> TableData(Date debut_date,Date fin_date,List<String> params);
	
	@Query(value = "SELECT village.commune,sum(wp3_committee_actif.sexe_h) as H,sum(wp3_committee_actif.sexe_f) as F FROM"
			+ " village,wp3_committee_actif WHERE village.code_village=wp3_committee_actif.code_village AND "
			+ " wp3_committee_actif.date_suivi BETWEEN ?1 AND ?2 \r\n" + 
			"GROUP BY village.commune", nativeQuery = true)
	List<Object[]> TableDataCommune(Date debut_date,Date fin_date);
	
	@Query(value = "SELECT village.district,sum(wp3_committee_actif.sexe_h) as H,sum(wp3_committee_actif.sexe_f) as F FROM"
			+ " village,wp3_committee_actif WHERE village.code_village=wp3_committee_actif.code_village "
			+ " AND wp3_committee_actif.date_suivi BETWEEN ?1 AND ?2 \r\n" + 
			"GROUP BY village.district", nativeQuery = true)
	List<Object[]> TableDataDist(Date debut_date,Date fin_date);

}
