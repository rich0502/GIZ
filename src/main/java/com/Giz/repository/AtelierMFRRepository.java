package com.Giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.AtelierMFR;


public interface AtelierMFRRepository extends JpaRepository<AtelierMFR, Long> {
	
	@Modifying
    @Transactional
    @Query("delete from AtelierMFR v where type_atelier = ?1")
    void deleteAllAtelier(String type_atelier);
	
	@Query("SELECT e FROM AtelierMFR e WHERE  e.type_atelier=?1")
	List<AtelierMFR> fetchAtelier(String type_atelier);
	
	@Query(value = "SELECT village.district,count(village.district) as y from village,ateliermfr where  type_atelier=?1 and village.code_village=ateliermfr.code_village group by village.district", nativeQuery = true)
	List<Object[]> fetchAtelierMFRData(String type_atelier);
	
	//liste
	/*@Query("SELECT new com.Giz.data.domain.TpsFormes(e.date_realise as x,sum(e.nbr_particip) as y) FROM AtelierMFR e WHERE  e.type_atelier=?1 and e.date_realise BETWEEN ?2 AND ?3 group by e.date_realise order by e.date_realise ASC")
	List<TpsFormes> TpsAtelierMFRData(String type_atelier,java.util.Date debut_date,java.util.Date fin_date);*/
	
	//count
	@Query(value = "SELECT count(village.district) as y from village,ateliermfr WHERE type_atelier=:type_atelier and village.code_village=ateliermfr.code_village", nativeQuery = true)
	long SomAtelierMFRData(String type_atelier);
	
	//count
	@Query(value = "SELECT sum(nbr_particip) as y FROM AtelierMFR WHERE type_atelier=:type_atelier and date_realise BETWEEN :debut_date AND :fin_date", nativeQuery = true)
	long SomAtelierMFR(String type_atelier,java.util.Date debut_date,java.util.Date fin_date);
	
	@Query(value = "SELECT e.date_realise as x,sum(e.nbr_particip) as y FROM atelierMFR e WHERE  e.type_atelier=:type_atelier AND  e.date_realise BETWEEN :debut_date AND :fin_date GROUP BY e.date_realise ORDER BY e.date_realise ASC", nativeQuery = true)
	List<Object[]> TpsAtelierMFRData(String type_atelier,java.util.Date debut_date,java.util.Date fin_date);
	
	//indicateur
	
	@Query(value="Select sum(nbr_homme) as homme from ateliermfr where type_atelier=:type_atelier AND date_realise BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long getCountHomme(String dateChronologique, String type_atelier);
	
	@Query(value="Select CASE WHEN sum(nbr_homme) >= 1 THEN true ELSE false END from ateliermfr where type_atelier=:type_atelier AND date_realise BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	boolean getCountHommeIsExist(String dateChronologique, String type_atelier);
	
	@Query(value="Select sum(nbr_femme) as femme from ateliermfr where type_atelier=:type_atelier AND date_realise BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long getCountFemme(String dateChronologique, String type_atelier);
	
	
	@Query(value="Select CASE WHEN sum(nbr_femme) >= 1 THEN true ELSE false END from ateliermfr where type_atelier=:type_atelier AND date_realise BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	boolean getCountFemmeIsExist(String dateChronologique, String type_atelier);
	
	@Query(value="Select count(*) from ateliermfr where  type_atelier=:type_atelier and date_realise BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long getCountChronologique(String dateChronologique, String type_atelier);
	
	@Query(value="Select CASE WHEN  count(*) >= 1 THEN true ELSE false END from ateliermfr where  type_atelier=:type_atelier and date_realise BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	boolean getCountChronologiqueIsExist(String dateChronologique, String type_atelier);
	
	@Query(value = "SELECT village.code_village,village.village,sum(atelierMFR.nbr_homme) as H, sum(atelierMFR.nbr_femme) as F FROM village,"
			+ "atelierMFR WHERE atelierMFR.type_atelier=?1 AND village.code_village=atelierMFR.code_village AND atelierMFR.code_village  IN (null, ?2) "
			+ "AND atelierMFR.date_realise BETWEEN ?3 AND ?4 GROUP BY village.code_village,village.village", nativeQuery = true)
	List<Object[]> TableData(String type_atelier, List<String> params, java.util.Date debut_date,
			java.util.Date fin_date);
	
	@Query(value = "SELECT village.commune,sum(atelierMFR.nbr_homme) as H,sum(atelierMFR.nbr_femme) as F FROM\r\n" + 
			"village,atelierMFR WHERE atelierMFR.type_atelier=?1 \r\n" + 
			"AND village.code_village=atelierMFR.code_village \r\n" + 
			"AND atelierMFR.date_realise BETWEEN ?2 AND ?3 GROUP BY village.commune", nativeQuery = true)
	List<Object[]> TableDataCommune(String type_atelier,java.util.Date debut_date,java.util.Date fin_date);
	
	@Query(value = "SELECT village.district,sum(atelierMFR.nbr_homme) as H,sum(atelierMFR.nbr_femme) as F FROM\r\n" + 
			"village,atelierMFR WHERE atelierMFR.type_atelier=?1 \r\n" + 
			"AND village.code_village=atelierMFR.code_village \r\n" + 
			"AND atelierMFR.date_realise BETWEEN ?2 AND ?3 GROUP BY village.district", nativeQuery = true)
	List<Object[]> TableDataDist(String type_atelier, java.util.Date debut_date, java.util.Date fin_date);
	
	@Query(value="SELECT atelierMFR.created_by, atelierMFR.creation_date, atelierMFR.last_modified_by, atelierMFR.last_modified_date FROM atelierMFR WHERE type_atelier=?1", nativeQuery = true)
	List<Object[]> historiqueList(String type_atelier);
	
	
	
}

