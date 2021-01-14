package com.Giz.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Wp3FedeMfr;

public interface Wp3FedeMfrRepository extends JpaRepository<Wp3FedeMfr, Long> {
	
	@Query("select count(*) from Wp3FedeMfr where plan_strategique='true'")
	long countAll();
	
	@Query("select count(*) from Wp3FedeMfr where plan_strategique='true' and lower(sexe)=:sexe")
	long countGenre(String sexe);
	
	@Query(value="select count(*) from wp3_fede_mfr where plan_strategique='true' and date_validation BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronolgique(String dateChronologique);
	
	@Query(value="select count(*) from wp3_fede_mfr where plan_strategique='true' and lower(sexe)=:sexe and date_validation BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronolgiqueGenre(String dateChronologique, String sexe);
	
	@Modifying
    @Transactional
    @Query("delete from Wp3FedeMfr e where id = ?1")
    void deleteWp3FedeMfr(Long id);
	
	//graphe
	
	@Query(value = "SELECT count(*) as y FROM wp3_fede_mfr WHERE date_validation BETWEEN :debut_date AND :fin_date", nativeQuery = true)
	long SomTotal(java.util.Date debut_date,java.util.Date fin_date);

	@Query(value = "SELECT village.district,count(village.district) as y from village,wp3_fede_mfr where village.code_village=wp3_fede_mfr.code_region group by village.district", nativeQuery = true)
	List<Object[]> fetchData();

	//count
	@Query(value = "SELECT count(village.district) as y from village,wp3_fede_mfr WHERE village.code_village=wp3_fede_mfr.code_region", nativeQuery = true)
	long CamembertTot();

	@Query(value = "SELECT e.date_validation as x,count(e.nom_mfr) as y FROM wp3_fede_mfr e WHERE e.date_validation BETWEEN ?1 AND ?2 GROUP BY e.date_validation ORDER BY e.date_validation ASC", nativeQuery = true)
	List<Object[]> TpsData(Date debut_date,Date fin_date);

}
