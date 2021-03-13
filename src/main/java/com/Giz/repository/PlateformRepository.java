package com.Giz.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.Giz.data.domain.Plateforme;


public interface PlateformRepository extends JpaRepository<Plateforme, Long> {
	
	@Query("SELECT e FROM Plateforme e where type_plateform = ?1")
	List<Plateforme> fetchPlateforme(String type_plateform);
	
	@Query(value = "SELECT village.district,count(village.district) as y from village,plateforme where  type_plateform=?1 and village.code_village=plateforme.code_village group by village.district", nativeQuery = true)
	List<Object[]> fetchplateformeData(String type_plateform);
	
	//count
	@Query(value = "SELECT count(village.district) as y from village,plateforme WHERE type_plateform=:type_plateform and village.code_village=plateforme.code_village", nativeQuery = true)
	long SomplateformeData(String type_plateform);
	
	//count
	@Query(value = "SELECT count(operationnel) as y FROM plateforme WHERE operationnel=true and type_plateform=:type_plateform and date_suivi BETWEEN :debut_date AND :fin_date", nativeQuery = true)
	long Somplateforme(String type_plateform,java.util.Date debut_date,java.util.Date fin_date);
	
	@Query(value = "SELECT e.date_suivi as x,count(e.operationnel) as y FROM plateforme e WHERE  e.type_plateform=:type_plateform and e.date_suivi BETWEEN :debut_date AND :fin_date GROUP BY e.date_suivi ORDER BY e.date_suivi ASC", nativeQuery = true)
	List<Object[]> TpsplateformeData(String type_plateform,java.util.Date debut_date,java.util.Date fin_date);
	
	//indicateur
	
	@Query(value="Select count(*)  from plateforme where type_plateform=:type_plateform AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long getCount(String dateChronologique, String type_plateform);
	
	@Query(value="Select CASE WHEN count(*) >= 1 THEN true ELSE false END from plateforme where type_plateform=:type_plateform AND date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	boolean getCountIsExist(String dateChronologique, String type_plateform);
	
	@Query(value="Select count(*) from plateforme where  type_plateform=:type_plateform and date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long getCountChronologique(String dateChronologique, String type_plateform);
	
	@Query(value="Select CASE WHEN  count(*) >= 1 THEN true ELSE false END from plateforme where  type_plateform=:type_plateform and date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	boolean getCountChronologiqueIsExist(String dateChronologique, String type_plateform);
	
	@Query(value = "SELECT village.code_village,village.village,count(plateforme.commentaire) as nbr\r\n" + 
			"FROM village,plateforme\r\n" + 
			" WHERE    plateforme.type_plateform=?1 AND \r\n" + 
			" village.code_village=plateforme.code_village AND plateforme.code_village  IN (null, ?2) AND plateforme.date_suivi BETWEEN ?3 AND ?4 \r\n" + 
			"GROUP BY village.code_village,village.village", nativeQuery = true)
	List<Object[]> TableData(String type_plateform, List<String> params, Date debut_date, Date fin_date);
	
	@Query(value = "SELECT village.commune,count(plateforme.commentaire) as nbr\r\n" + 
			"FROM village,plateforme\r\n" + 
			" WHERE    plateforme.type_plateform=?1 AND \r\n" + 
			" village.code_village=plateforme.code_village AND plateforme.date_suivi BETWEEN ?2 AND ?3 \r\n" + 
			"GROUP BY village.commune", nativeQuery = true)
	List<Object[]> TableDataCommune(String type_plateform,Date debut_date, Date fin_date);
	
	@Query(value = "SELECT village.district,count(plateforme.commentaire) as nbr\r\n" + 
			"FROM village,plateforme\r\n" + 
			" WHERE    plateforme.type_plateform=?1 AND \r\n" + 
			" village.code_village=plateforme.code_village AND plateforme.date_suivi BETWEEN ?2 AND ?3 \r\n" + 
			"GROUP BY village.district", nativeQuery = true)
	List<Object[]> TableDataDist(String type_plateform,Date debut_date, Date fin_date);
}

