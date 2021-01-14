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

}
