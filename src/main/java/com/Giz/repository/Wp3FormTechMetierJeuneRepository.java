package com.Giz.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Wp3FormTechMetierJeune;


public interface Wp3FormTechMetierJeuneRepository extends JpaRepository<Wp3FormTechMetierJeune, Long> {
	
	@Query(value="select count(*) from wp3form_tech_metier_jeune where lower(sexe)=:sexe", nativeQuery = true)
	long countGenre(String sexe);
	
	@Query(value="select count(*) from wp3form_tech_metier_jeune where date_realise BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologique(String dateChronologique);
	
	@Query(value="select count(*) from wp3form_tech_metier_jeune where lower(sexe)=:sexe and date_realise BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologiqueGenre(String dateChronologique, String sexe);
	
	@Modifying
    @Transactional
    @Query("delete from Wp3FormTechMetierJeune e where id = ?1")
    void deleteWp3FormTechMetierJeune(Long id);
	
	//graphe
	
	@Query(value = "SELECT count(*) as y FROM wp3form_tech_metier_jeune WHERE date_realise BETWEEN :debut_date AND :fin_date", nativeQuery = true)
	long SomTotal(java.util.Date debut_date,java.util.Date fin_date);

	@Query(value = "SELECT village.district,count(village.district) as y from village,wp3form_tech_metier_jeune where village.code_village=wp3form_tech_metier_jeune.code_village group by village.district", nativeQuery = true)
	List<Object[]> fetchData();

	//count
	@Query(value = "SELECT count(village.district) as y from village,wp3form_tech_metier_jeune WHERE village.code_village=wp3form_tech_metier_jeune.code_village", nativeQuery = true)
	long CamembertTot();

	@Query(value = "SELECT e.date_realise as x,count(e.theme) as y FROM wp3form_tech_metier_jeune e WHERE e.date_realise BETWEEN ?1 AND ?2 GROUP BY e.date_realise ORDER BY e.date_realise ASC", nativeQuery = true)
	List<Object[]> TpsData(Date debut_date,Date fin_date);

}
