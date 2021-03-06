package com.Giz.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Wp3UniteElevJeune;

public interface Wp3UniteElevJeuneRepository extends JpaRepository<Wp3UniteElevJeune, Long> {

	@Query("select count(*) from Wp3UniteElevJeune where lower(sexe)=:sexe")
	long countGenre(String sexe);

	@Query(value = "select count(*) from wp3_unite_elev_jeune where date_dem BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologique(String dateChronologique);

	@Query(value = "select count(*) from wp3_unite_elev_jeune where lower(sexe)=:sexe and date_dem BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologiqueGenre(String dateChronologique, String sexe);

	@Modifying
	@Transactional
	@Query("delete from Wp3UniteElevJeune e where id = ?1")
	void deleteWp3UniteElevJeune(Long id);

	// graphe

	@Query(value = "SELECT count(*) as y FROM wp3_unite_elev_jeune WHERE date_suivi1 BETWEEN :debut_date AND :fin_date", nativeQuery = true)
	long SomTotal(java.util.Date debut_date, java.util.Date fin_date);

	@Query(value = "SELECT village.district,count(village.district) as y from village,wp3_unite_elev_jeune where village.code_village=wp3_unite_elev_jeune.code_village group by village.district", nativeQuery = true)
	List<Object[]> fetchData();

	// count
	@Query(value = "SELECT count(village.district) as y from village,wp3_unite_elev_jeune WHERE village.code_village=wp3_unite_elev_jeune.code_village", nativeQuery = true)
	long CamembertTot();

	@Query(value = "SELECT e.date_suivi1 as x,count(e.nom_prenom) as y FROM wp3_unite_elev_jeune e WHERE e.date_suivi1 BETWEEN ?1 AND ?2 GROUP BY e.date_suivi1 ORDER BY e.date_suivi1 ASC", nativeQuery = true)
	List<Object[]> TpsData(Date debut_date, Date fin_date);

	// tableau

	@Query(value = "SELECT village.code_village,village.village,count(wp3_unite_elev_jeune.sexe) as nbr, wp3_unite_elev_jeune.sexe FROM"
			+ " village,wp3_unite_elev_jeune WHERE wp3_unite_elev_jeune.sexe=?4 AND village.code_village=wp3_unite_elev_jeune.code_village AND wp3_unite_elev_jeune.code_village "
			+ " IN (null, ?3) AND wp3_unite_elev_jeune.date_suivi1 BETWEEN ?1 AND ?2 \r\n"
			+ "GROUP BY village.code_village,village.village, wp3_unite_elev_jeune.sexe", nativeQuery = true)
	List<Object[]> TableData(Date debut_date, Date fin_date, List<String> params, String sexe);

	@Query(value = "SELECT village.commune,count(wp3_unite_elev_jeune.sexe) as nbr, wp3_unite_elev_jeune.sexe FROM"
			+ " village,wp3_unite_elev_jeune WHERE wp3_unite_elev_jeune.sexe=?3 AND village.code_village=wp3_unite_elev_jeune.code_village AND "
			+ " wp3_unite_elev_jeune.date_suivi1 BETWEEN ?1 AND ?2 \r\n"
			+ "GROUP BY village.commune, wp3_unite_elev_jeune.sexe", nativeQuery = true)
	List<Object[]> TableDataCommune(Date debut_date, Date fin_date, String sexe);

	@Query(value = "SELECT village.district,count(wp3_unite_elev_jeune.sexe) as nbr, wp3_unite_elev_jeune.sexe FROM"
			+ " village,wp3_unite_elev_jeune WHERE wp3_unite_elev_jeune.sexe=?3 AND village.code_village=wp3_unite_elev_jeune.code_village "
			+ " AND wp3_unite_elev_jeune.date_suivi1 BETWEEN ?1 AND ?2 \r\n"
			+ "GROUP BY village.district, wp3_unite_elev_jeune.sexe", nativeQuery = true)
	List<Object[]> TableDataDist(Date debut_date, Date fin_date, String sexe);

	@Query(value = "select hommes.code_village,hommes.village,hommes.homme,femmes.femme\r\n"
			+ "	from (SELECT village.code_village,village.village,count(wp3_unite_elev_jeune.sexe) as homme FROM"
			+ "	 village,wp3_unite_elev_jeune WHERE wp3_unite_elev_jeune.sexe= 'H' AND village.code_village=wp3_unite_elev_jeune.code_village AND wp3_unite_elev_jeune.code_village \r\n"
			+ " IN (null, ?3) AND wp3_unite_elev_jeune.date_suivi1 BETWEEN ?1 AND ?2 \r\n"
			+ "GROUP BY village.code_village,village.village) as hommes,\r\n"
			+ "	(SELECT village.code_village,village.village,count(wp3_unite_elev_jeune.sexe) as femme FROM\r\n"
			+ "	 village,wp3_unite_elev_jeune WHERE wp3_unite_elev_jeune.sexe= 'F' AND village.code_village=wp3_unite_elev_jeune.code_village AND wp3_unite_elev_jeune.code_village \r\n"
			+ " IN (null, ?3) AND wp3_unite_elev_jeune.date_suivi1 BETWEEN ?1 AND ?2 \r\n"
			+ "GROUP BY village.code_village,village.village) as femmes where hommes.village=femmes.village", nativeQuery = true)
	List<Object[]> TableDataAll(Date debut_date, Date fin_date, List<String> params);

	@Query(value = "select hommes.commune,hommes.homme,femmes.femme\r\n"
			+ "	from (SELECT village.commune,count(wp3_unite_elev_jeune.sexe) as homme FROM\r\n"
			+ "	 village,wp3_unite_elev_jeune WHERE village.code_village=wp3_unite_elev_jeune.code_village AND\r\n"
			+ "	wp3_unite_elev_jeune.date_suivi1 BETWEEN ?1 AND ?2 \r\n" + "	and wp3_unite_elev_jeune.sexe = 'H'\r\n"
			+ "	GROUP BY village.commune) as hommes,\r\n"
			+ "	(SELECT village.commune,count(wp3_unite_elev_jeune.sexe) as femme FROM\r\n"
			+ "	 village,wp3_unite_elev_jeune WHERE village.code_village=wp3_unite_elev_jeune.code_village AND\r\n"
			+ "	wp3_unite_elev_jeune.date_suivi1 BETWEEN ?1 AND ?2 \r\n" + " and wp3_unite_elev_jeune.sexe = 'F'\r\n"
			+ "	GROUP BY village.commune) as femmes where hommes.commune=femmes.commune", nativeQuery = true)
	List<Object[]> TableDataCommuneAll(Date debut_date, Date fin_date);

	@Query(value = "select hommes.district,hommes.homme,femmes.femme\r\n"
			+ "	from (SELECT village.district,count(wp3_unite_elev_jeune.sexe) as homme FROM\r\n"
			+ "	 village,wp3_unite_elev_jeune WHERE village.code_village=wp3_unite_elev_jeune.code_village AND\r\n"
			+ "	wp3_unite_elev_jeune.date_suivi1 BETWEEN ?1 AND ?2 \r\n" + "	and wp3_unite_elev_jeune.sexe = 'H'\r\n"
			+ "	GROUP BY village.district) as hommes,\r\n"
			+ "	(SELECT village.district,count(wp3_unite_elev_jeune.sexe) as femme FROM\r\n"
			+ "	 village,wp3_unite_elev_jeune WHERE village.code_village=wp3_unite_elev_jeune.code_village AND\r\n"
			+ "	wp3_unite_elev_jeune.date_suivi1 BETWEEN ?1 AND ?2 \r\n" + " and wp3_unite_elev_jeune.sexe = 'F'\r\n"
			+ "	GROUP BY village.district) as femmes where hommes.district=femmes.district", nativeQuery = true)
	List<Object[]> TableDataDistAll(Date debut_date, Date fin_date);

	// VILLAGE DETAIL TABLEAU COUNT

	@Query(value = "SELECT village.code_village,wp3_unite_elev_jeune.nom_prenom FROM village,wp3_unite_elev_jeune WHERE"
			+ " village.code_village=wp3_unite_elev_jeune.code_village AND village.village = ?1   AND upper(wp3_unite_elev_jeune.sexe)= ?2 \r\n", nativeQuery = true)
	List<Object[]> TableCountDetailGenre(String village, String sexe);

	@Query(value = "SELECT village.code_village,wp3_unite_elev_jeune.nom_prenom FROM village,wp3_unite_elev_jeune WHERE"
			+ " village.code_village=wp3_unite_elev_jeune.code_village AND village.village = ?1   \r\n", nativeQuery = true)
	List<Object[]> TableCountDetailGenreAll(String village);

	// COMMUNE DETAIL TABLEAU COUNT

	@Query(value = "SELECT village.code_village,wp3_unite_elev_jeune.nom_prenom FROM village,wp3_unite_elev_jeune WHERE"
			+ " village.code_village=wp3_unite_elev_jeune.code_village AND village.commune = ?1   AND upper(wp3_unite_elev_jeune.sexe)= ?2 \r\n", nativeQuery = true)
	List<Object[]> TableCountDetailGenreComm(String commune, String sexe);

	@Query(value = "SELECT village.code_village,wp3_unite_elev_jeune.nom_prenom FROM village,wp3_unite_elev_jeune WHERE"
			+ " village.code_village=wp3_unite_elev_jeune.code_village AND village.commune = ?1   \r\n", nativeQuery = true)
	List<Object[]> TableCountDetailGenreAllComm(String commune);

	// DISTRICT DETAIL TABLEAU COUNT

	@Query(value = "SELECT village.code_village,wp3_unite_elev_jeune.nom_prenom FROM village,wp3_unite_elev_jeune WHERE"
			+ " village.code_village=wp3_unite_elev_jeune.code_village AND village.district = ?1   AND upper(wp3_unite_elev_jeune.sexe)= ?2 \r\n", nativeQuery = true)
	List<Object[]> TableCountDetailGenreDist(String district, String sexe);

	@Query(value = "SELECT village.code_village,wp3_unite_elev_jeune.nom_prenom FROM village,wp3_unite_elev_jeune WHERE"
			+ " village.code_village=wp3_unite_elev_jeune.code_village AND village.district = ?1   \r\n", nativeQuery = true)
	List<Object[]> TableCountDetailGenreAllDist(String district);

	@Query(value="SELECT wp3_unite_elev_jeune.created_by, wp3_unite_elev_jeune.creation_date, wp3_unite_elev_jeune.last_modified_by, wp3_unite_elev_jeune.last_modified_date FROM wp3_unite_elev_jeune", nativeQuery = true)
	List<Object[]> historiqueList();

}
