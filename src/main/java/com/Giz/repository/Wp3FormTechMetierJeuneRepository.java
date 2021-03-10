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
	
	@Query(value = "SELECT village.code_village,village.district,count(wp3form_tech_metier_jeune.sexe) as nbr, wp3form_tech_metier_jeune.sexe FROM"
			+ " village,wp3form_tech_metier_jeune WHERE wp3form_tech_metier_jeune.sexe=?4 AND village.code_village=wp3form_tech_metier_jeune.code_village AND wp3form_tech_metier_jeune.code_village "
			+ " IN (null, ?3) AND wp3form_tech_metier_jeune.date_realise BETWEEN ?1 AND ?2 \r\n" + 
			"GROUP BY village.code_village,village.district, wp3form_tech_metier_jeune.sexe", nativeQuery = true)
	List<Object[]> TableData(Date debut_date,Date fin_date,List<String> params,String sexe);
	
	@Query(value = "SELECT village.code_village,village.commune,count(wp3form_tech_metier_jeune.sexe) as nbr, wp3form_tech_metier_jeune.sexe FROM"
			+ " village,wp3form_tech_metier_jeune WHERE wp3form_tech_metier_jeune.sexe=?3 AND village.code_village=wp3form_tech_metier_jeune.code_village AND "
			+ " wp3form_tech_metier_jeune.date_realise BETWEEN ?1 AND ?2 \r\n" + 
			"GROUP BY village.code_village,village.commune, wp3form_tech_metier_jeune.sexe", nativeQuery = true)
	List<Object[]> TableDataCommune(Date debut_date,Date fin_date, String sexe);
	
	@Query(value = "SELECT village.district,count(wp3form_tech_metier_jeune.sexe) as nbr, wp3form_tech_metier_jeune.sexe FROM"
			+ " village,wp3form_tech_metier_jeune WHERE wp3form_tech_metier_jeune.sexe=?3 AND village.code_village=wp3form_tech_metier_jeune.code_village "
			+ " AND wp3form_tech_metier_jeune.date_realise BETWEEN ?1 AND ?2 \r\n" + 
			"GROUP BY village.district, wp3form_tech_metier_jeune.sexe", nativeQuery = true)
	List<Object[]> TableDataDist(Date debut_date,Date fin_date,String sexe);

}
