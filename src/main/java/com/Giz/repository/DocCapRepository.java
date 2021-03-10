package com.Giz.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.DocCap;


public interface DocCapRepository extends JpaRepository<DocCap, Long> {
	//liste
	/*@Query("SELECT new com.Giz.data.domain.TpsFormes(e.date_partage as x, count(e.date_partage) as y) FROM DocCap e WHERE e.date_partage BETWEEN ?1 AND ?2 group by e.date_partage order by e.date_partage ASC")
	List<TpsFormes> TpsDoc_capData(java.util.Date debut_date,java.util.Date fin_date);*/
	
	//liste
	@Query("SELECT count(e) as tot FROM DocCap e")
	int SomDocCapData();
	
	@Query(value = "SELECT e.date_partage as x,count(e.date_partage) as y FROM DocCap e WHERE e.date_partage BETWEEN ?1 AND ?2 GROUP BY e.date_partage ORDER BY e.date_partage ASC", nativeQuery = true)
	List<Object[]> TpsDoc_capData(java.util.Date debut_date,java.util.Date fin_date);
	
	@Modifying
    @Transactional
    @Query("delete from DocCap e where id_dc = ?1")
    void deleteDocCap(Long id_dc);
	
	//graphe
	
	@Query(value = "SELECT count(*) as y FROM doc_cap WHERE date_partage BETWEEN :debut_date AND :fin_date", nativeQuery = true)
	long SomTotal(java.util.Date debut_date,java.util.Date fin_date);
	
	
	@Query(value = "SELECT e.date_partage as x,count(e.auteur_doc) as y FROM doc_cap e WHERE e.date_partage BETWEEN ?1 AND ?2 GROUP BY e.date_partage ORDER BY e.date_partage ASC", nativeQuery = true)
	List<Object[]> TpsData(java.util.Date debut_date,java.util.Date fin_date);
	

	@Query(value="Select count(*) from doc_cap where lower(sexe) =:sexe", nativeQuery = true)
	long getCountGenre(String sexe);
	
	@Query(value="Select count(*) from doc_cap where date_partage BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long getCountChronologique(String dateChronologique);
}

