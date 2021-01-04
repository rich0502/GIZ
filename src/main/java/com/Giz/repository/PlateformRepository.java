package com.Giz.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.Giz.data.domain.Plateforme;
import com.Giz.data.domain.TpsFormes;


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
}

