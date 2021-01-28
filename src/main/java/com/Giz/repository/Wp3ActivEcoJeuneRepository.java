package com.Giz.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.TpsFormes;
import com.Giz.data.domain.Wp3ActivEcoJeune;

public interface Wp3ActivEcoJeuneRepository extends JpaRepository<Wp3ActivEcoJeune, Long> {

	@Query("Select count(*) from Wp3ActivEcoJeune where lower(sexe) =:sexe")
	long getCountGenre(String sexe);
	
	@Query(value="Select count(*) from wp3_activ_eco_jeune where date_fin_frm BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long getCountChronologique(String dateChronologique);
	
	@Query(value="Select count(*) from wp3_activ_eco_jeune where lower(sexe) =:sexe and date_fin_frm BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long getCountChronologiqueGenre(String dateChronologique, String sexe);
	
	@Modifying
    @Transactional
    @Query("delete from Wp3ActivEcoJeune e where id = ?1")
    void deleteWP3ActivEcoJeune(Long id);
	
	//graphe
	
	@Query(value = "SELECT count(*) as y FROM wp3_activ_eco_jeune WHERE date_fin_frm BETWEEN :debut_date AND :fin_date", nativeQuery = true)
	long SomTotal(java.util.Date debut_date,java.util.Date fin_date);
	
	@Query(value = "SELECT village.district,count(village.district) as y from village,wp3_activ_eco_jeune where village.code_village=wp3_activ_eco_jeune.code_village group by village.district", nativeQuery = true)
	List<Object[]> fetchData();
	
	//count
	@Query(value = "SELECT count(village.district) as y from village,wp3_activ_eco_jeune WHERE village.code_village=wp3_activ_eco_jeune.code_village", nativeQuery = true)
	long CamembertTot();
	
	@Query(value = "SELECT e.date_fin_frm as x,count(e.nom_prenom) as y FROM Wp3_activ_eco_jeune e WHERE e.date_fin_frm BETWEEN ?1 AND ?2 GROUP BY e.date_fin_frm ORDER BY e.date_fin_frm ASC", nativeQuery = true)
	List<Object[]> TpsData(Date debut_date,Date fin_date);
	
	@Query(value = "SELECT village.code_village,village.district,count(wp3_activ_eco_jeune.sexe) as nbr, wp3_activ_eco_jeune.sexe FROM"
			+ " village,wp3_activ_eco_jeune WHERE wp3_activ_eco_jeune.sexe=?4 AND village.code_village=wp3_activ_eco_jeune.code_village AND wp3_activ_eco_jeune.code_village "
			+ " IN (null, ?3) AND wp3_activ_eco_jeune.date_fin_frm BETWEEN ?1 AND ?2 \r\n" + 
			"GROUP BY village.code_village,village.district, wp3_activ_eco_jeune.sexe", nativeQuery = true)
	List<Object[]> TableData(Date debut_date,Date fin_date,List<String> params,String sexe);
	
	@Query(value = "SELECT village.code_village,village.commune,count(wp3_activ_eco_jeune.sexe) as nbr, wp3_activ_eco_jeune.sexe FROM"
			+ " village,wp3_activ_eco_jeune WHERE wp3_activ_eco_jeune.sexe=?3 AND village.code_village=wp3_activ_eco_jeune.code_village AND "
			+ " wp3_activ_eco_jeune.date_fin_frm BETWEEN ?1 AND ?2 \r\n" + 
			"GROUP BY village.code_village,village.commune, wp3_activ_eco_jeune.sexe", nativeQuery = true)
	List<Object[]> TableDataCommune(Date debut_date,Date fin_date, String sexe);
	
	@Query(value = "SELECT village.district,count(wp3_activ_eco_jeune.sexe) as nbr, wp3_activ_eco_jeune.sexe FROM"
			+ " village,wp3_activ_eco_jeune WHERE wp3_activ_eco_jeune.sexe=?3 AND village.code_village=wp3_activ_eco_jeune.code_village "
			+ " AND wp3_activ_eco_jeune.date_fin_frm BETWEEN ?1 AND ?2 \r\n" + 
			"GROUP BY village.district, wp3_activ_eco_jeune.sexe", nativeQuery = true)
	List<Object[]> TableDataDist(Date debut_date,Date fin_date,String sexe);
}
