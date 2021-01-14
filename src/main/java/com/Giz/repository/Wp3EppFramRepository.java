package com.Giz.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Wp3EppFram;

public interface Wp3EppFramRepository extends JpaRepository<Wp3EppFram, Long> {
	@Query("select count(*) from Wp3EppFram where lower(sexe)=:sexe")
	long countGenre(String sexe);
	
	@Query(value="select count(*) from wp3_epp_fram where date_validation BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologie(String dateChronologique);
	
	@Query(value="select count(*) from wp3_epp_fram where lower(sexe)=:sexe and date_validation BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologieGenre(String dateChronologique, String sexe);
	
	@Modifying
    @Transactional
    @Query("delete from Wp3EppFram e where id = ?1")
    void deleteWp3EppFram(Long id);
	
	//graphe
	
	@Query(value = "SELECT count(*) as y FROM wp3_epp_fram WHERE date_validation BETWEEN :debut_date AND :fin_date", nativeQuery = true)
	long SomTotal(java.util.Date debut_date,java.util.Date fin_date);

	@Query(value = "SELECT village.district,count(village.district) as y from village,wp3_epp_fram where village.code_village=wp3_epp_fram.code_village group by village.district", nativeQuery = true)
	List<Object[]> fetchData();

	//count
	@Query(value = "SELECT count(village.district) as y from village,wp3_epp_fram WHERE village.code_village=wp3_epp_fram.code_village", nativeQuery = true)
	long CamembertTot();

	@Query(value = "SELECT e.date_validation as x,count(e.nom_ecole) as y FROM wp3_epp_fram e WHERE e.date_validation BETWEEN ?1 AND ?2 GROUP BY e.date_validation ORDER BY e.date_validation ASC", nativeQuery = true)
	List<Object[]> TpsData(Date debut_date,Date fin_date);
}
