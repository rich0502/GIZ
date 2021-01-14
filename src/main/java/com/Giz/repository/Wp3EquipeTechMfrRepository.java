package com.Giz.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Wp3EquipeTechMfr;

public interface Wp3EquipeTechMfrRepository extends JpaRepository<Wp3EquipeTechMfr, Long> {
	
	@Query("select count(*) from Wp3EquipeTechMfr where lower(sexe) = :sexe")
	long countGenre(String sexe);
	
	@Query(value="select count(*) from wp3_eequipe_tech_mfr where date_eval BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologique(String dateChronologique);
	
	@Query(value="select count(*) from wp3_eequipe_tech_mfr where lower(sexe) = :sexe and date_eval BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologiqueGenre(String dateChronologique, String sexe);
	
	@Modifying
    @Transactional
    @Query("delete from Wp3EquipeTechMfr e where id = ?1")
    void deleteWp3EquipeTechMfr(Long id);
	
	//graphe
	
	@Query(value = "SELECT count(*) as y FROM wp3_eequipe_tech_mfr WHERE date_eval BETWEEN :debut_date AND :fin_date", nativeQuery = true)
	long SomTotal(java.util.Date debut_date,java.util.Date fin_date);

	@Query(value = "SELECT village.district,count(village.district) as y from village,wp3_eequipe_tech_mfr where village.code_village=wp3_eequipe_tech_mfr.code_village group by village.district", nativeQuery = true)
	List<Object[]> fetchData();

	//count
	@Query(value = "SELECT count(village.district) as y from village,wp3_eequipe_tech_mfr WHERE village.code_village=wp3_eequipe_tech_mfr.code_village", nativeQuery = true)
	long CamembertTot();

	@Query(value = "SELECT e.date_eval as x,count(e.nom_prenom) as y FROM wp3_eequipe_tech_mfr e WHERE e.date_eval BETWEEN ?1 AND ?2 GROUP BY e.date_eval ORDER BY e.date_eval ASC", nativeQuery = true)
	List<Object[]> TpsData(Date debut_date,Date fin_date);
}
