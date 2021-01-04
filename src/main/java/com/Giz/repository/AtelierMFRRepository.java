package com.Giz.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.AtelierMFR;
import com.Giz.data.domain.Beneficiaire;
import com.Giz.data.domain.GraphDist;
import com.Giz.data.domain.GraphDistrict;
import com.Giz.data.domain.TpsFormes;


public interface AtelierMFRRepository extends JpaRepository<AtelierMFR, Long> {
	
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
	
	
}

