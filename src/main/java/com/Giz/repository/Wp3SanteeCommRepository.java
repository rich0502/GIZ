package com.Giz.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Wp3SanteeComm;

public interface Wp3SanteeCommRepository extends JpaRepository<Wp3SanteeComm, Long> {

	@Query("select count(*) from Wp3SanteeComm where lower(sexe)=:sexe")
	long countGenre(String sexe);

	@Query(value = "select count(*) from wp3_santee_comm where date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologique(String dateChronologique);

	@Query(value = "select count(*) from wp3_santee_comm where lower(sexe)=:sexe and date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologiqueGenre(String dateChronologique, String sexe);

	@Modifying
	@Transactional
	@Query("delete from Wp3SanteeComm e where id = ?1")
	void deleteWp3SanteeComm(Long id);

	// graphe

	@Query(value = "SELECT count(*) as y FROM wp3_santee_comm WHERE date_suivi BETWEEN :debut_date AND :fin_date", nativeQuery = true)
	long SomTotal(java.util.Date debut_date, java.util.Date fin_date);

	@Query(value = "SELECT village.district,count(village.district) as y from village,wp3_santee_comm where village.code_village=wp3_santee_comm.code_village group by village.district", nativeQuery = true)
	List<Object[]> fetchData();

	// count
	@Query(value = "SELECT count(village.district) as y from village,wp3_santee_comm WHERE village.code_village=wp3_santee_comm.code_village", nativeQuery = true)
	long CamembertTot();

	@Query(value = "SELECT e.date_suivi as x,count(e.csb) as y FROM wp3_santee_comm e WHERE e.date_suivi BETWEEN ?1 AND ?2 GROUP BY e.date_suivi ORDER BY e.date_suivi ASC", nativeQuery = true)
	List<Object[]> TpsData(Date debut_date, Date fin_date);

	@Query(value = "SELECT village.code_village,village.village,count(wp3_santee_comm.sexe) as nbr, wp3_santee_comm.sexe FROM"
			+ " village,wp3_santee_comm WHERE wp3_santee_comm.sexe=?4 AND village.code_village=wp3_santee_comm.code_village AND wp3_santee_comm.code_village "
			+ " IN (null, ?3) AND wp3_santee_comm.date_suivi BETWEEN ?1 AND ?2 \r\n"
			+ "GROUP BY village.code_village,village.village, wp3_santee_comm.sexe", nativeQuery = true)
	List<Object[]> TableData(Date debut_date, Date fin_date, List<String> params, String sexe);

	@Query(value = "SELECT village.commune,count(wp3_santee_comm.sexe) as nbr, wp3_santee_comm.sexe FROM"
			+ " village,wp3_santee_comm WHERE wp3_santee_comm.sexe=?3 AND village.code_village=wp3_santee_comm.code_village AND "
			+ " wp3_santee_comm.date_suivi BETWEEN ?1 AND ?2 \r\n"
			+ "GROUP BY village.commune, wp3_santee_comm.sexe", nativeQuery = true)
	List<Object[]> TableDataCommune(Date debut_date, Date fin_date, String sexe);

	@Query(value = "SELECT village.district,count(wp3_santee_comm.sexe) as nbr, wp3_santee_comm.sexe FROM"
			+ " village,wp3_santee_comm WHERE wp3_santee_comm.sexe=?3 AND village.code_village=wp3_santee_comm.code_village "
			+ " AND wp3_santee_comm.date_suivi BETWEEN ?1 AND ?2 \r\n"
			+ "GROUP BY village.district, wp3_santee_comm.sexe", nativeQuery = true)
	List<Object[]> TableDataDist(Date debut_date, Date fin_date, String sexe);

	@Query(value = "select hommes.code_village,hommes.village,hommes.homme,femmes.femme\r\n"
			+ "	from (SELECT village.code_village,village.village,count(wp3_santee_comm.sexe) as homme FROM"
			+ "	 village,wp3_santee_comm WHERE wp3_santee_comm.sexe= 'H' AND village.code_village=wp3_santee_comm.code_village AND wp3_santee_comm.code_village \r\n"
			+ " IN (null, ?3) AND wp3_santee_comm.date_suivi BETWEEN ?1 AND ?2 \r\n"
			+ "GROUP BY village.code_village,village.village) as hommes,\r\n"
			+ "	(SELECT village.code_village,village.village,count(wp3_santee_comm.sexe) as femme FROM\r\n"
			+ "	 village,wp3_santee_comm WHERE wp3_santee_comm.sexe= 'F' AND village.code_village=wp3_santee_comm.code_village AND wp3_santee_comm.code_village \r\n"
			+ " IN (null, ?3) AND wp3_santee_comm.date_suivi BETWEEN ?1 AND ?2 \r\n"
			+ "GROUP BY village.code_village,village.village) as femmes where hommes.village=femmes.village", nativeQuery = true)
	List<Object[]> TableDataAll(Date debut_date, Date fin_date, List<String> params);

	@Query(value = "select hommes.commune,hommes.homme,femmes.femme\r\n"
			+ "	from (SELECT village.commune,count(wp3_santee_comm.sexe) as homme FROM\r\n"
			+ "	 village,wp3_santee_comm WHERE village.code_village=wp3_santee_comm.code_village AND\r\n"
			+ "	wp3_santee_comm.date_suivi BETWEEN ?1 AND ?2 \r\n" + "	and wp3_santee_comm.sexe = 'H'\r\n"
			+ "	GROUP BY village.commune) as hommes,\r\n"
			+ "	(SELECT village.commune,count(wp3_santee_comm.sexe) as femme FROM\r\n"
			+ "	 village,wp3_santee_comm WHERE village.code_village=wp3_santee_comm.code_village AND\r\n"
			+ "	wp3_santee_comm.date_suivi BETWEEN ?1 AND ?2 \r\n" + " and wp3_santee_comm.sexe = 'F'\r\n"
			+ "	GROUP BY village.commune) as femmes where hommes.commune=femmes.commune", nativeQuery = true)
	List<Object[]> TableDataCommuneAll(Date debut_date, Date fin_date);

	@Query(value = "select hommes.district,hommes.homme,femmes.femme\r\n"
			+ "	from (SELECT village.district,count(wp3_santee_comm.sexe) as homme FROM\r\n"
			+ "	 village,wp3_santee_comm WHERE village.code_village=wp3_santee_comm.code_village AND\r\n"
			+ "	wp3_santee_comm.date_suivi BETWEEN ?1 AND ?2 \r\n" + "	and wp3_santee_comm.sexe = 'H'\r\n"
			+ "	GROUP BY village.district) as hommes,\r\n"
			+ "	(SELECT village.district,count(wp3_santee_comm.sexe) as femme FROM\r\n"
			+ "	 village,wp3_santee_comm WHERE village.code_village=wp3_santee_comm.code_village AND\r\n"
			+ "	wp3_santee_comm.date_suivi BETWEEN ?1 AND ?2 \r\n" + " and wp3_santee_comm.sexe = 'F'\r\n"
			+ "	GROUP BY village.district) as femmes where hommes.district=femmes.district", nativeQuery = true)
	List<Object[]> TableDataDistAll(Date debut_date, Date fin_date);

	// VILLAGE DETAIL TABLEAU COUNT

	@Query(value = "SELECT village.code_village,wp3_santee_comm.csb FROM village,wp3_santee_comm WHERE"
			+ " village.code_village=wp3_santee_comm.code_village AND village.village = ?1   AND upper(wp3_santee_comm.sexe)= ?2 \r\n", nativeQuery = true)
	List<Object[]> TableCountDetailGenre(String village, String sexe);

	@Query(value = "SELECT village.code_village,wp3_santee_comm.csb FROM village,wp3_santee_comm WHERE"
			+ " village.code_village=wp3_santee_comm.code_village AND village.village = ?1   \r\n", nativeQuery = true)
	List<Object[]> TableCountDetailGenreAll(String village);

	// COMMUNE DETAIL TABLEAU COUNT

	@Query(value = "SELECT village.code_village,wp3_santee_comm.csb FROM village,wp3_santee_comm WHERE"
			+ " village.code_village=wp3_santee_comm.code_village AND village.commune = ?1   AND upper(wp3_santee_comm.sexe)= ?2 \r\n", nativeQuery = true)
	List<Object[]> TableCountDetailGenreComm(String commune, String sexe);

	@Query(value = "SELECT village.code_village,wp3_santee_comm.csb FROM village,wp3_santee_comm WHERE"
			+ " village.code_village=wp3_santee_comm.code_village AND village.commune = ?1   \r\n", nativeQuery = true)
	List<Object[]> TableCountDetailGenreAllComm(String commune);

	// DISTRICT DETAIL TABLEAU COUNT

	@Query(value = "SELECT village.code_village,wp3_santee_comm.csb FROM village,wp3_santee_comm WHERE"
			+ " village.code_village=wp3_santee_comm.code_village AND village.district = ?1   AND upper(wp3_santee_comm.sexe)= ?2 \r\n", nativeQuery = true)
	List<Object[]> TableCountDetailGenreDist(String district, String sexe);

	@Query(value = "SELECT village.code_village,wp3_santee_comm.csb FROM village,wp3_santee_comm WHERE"
			+ " village.code_village=wp3_santee_comm.code_village AND village.district = ?1   \r\n", nativeQuery = true)
	List<Object[]> TableCountDetailGenreAllDist(String district);

	@Query(value="SELECT wp3_santee_comm.created_by, wp3_santee_comm.creation_date, wp3_santee_comm.last_modified_by, wp3_santee_comm.last_modified_date FROM wp3_santee_comm", nativeQuery = true)
	List<Object[]> historiqueList();

}
