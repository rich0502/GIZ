package com.Giz.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Wp3PeerEducator;

public interface Wp3PeerEducatorRepository extends JpaRepository<Wp3PeerEducator, Long> {
	
	@Query("select count(*) from Wp3PeerEducator where lower(sexe)=:sexe ")
	long countGenre(String sexe);
	
	@Query(value="select count(*) from wp3_peer_educator where date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologique(String dateChronologique);
	
	@Query(value="select count(*) from wp3_peer_educator where lower(sexe)=:sexe and date_suivi BETWEEN cast(TO_DATE('01/01/2020', 'DD/MM/YYYY') as date) and cast(TO_DATE(:dateChronologique, 'DD/MM/YYYY') as date)", nativeQuery = true)
	long countChronologiqueGenre(String dateChronologique, String sexe);
	
	@Modifying
    @Transactional
    @Query("delete from Wp3PeerEducator e where id = ?1")
    void deleteWp3PeerEducator(Long id);
	
	//graphe
	
	@Query(value = "SELECT count(*) as y FROM wp3_peer_educator WHERE date_suivi BETWEEN :debut_date AND :fin_date", nativeQuery = true)
	long SomTotal(java.util.Date debut_date,java.util.Date fin_date);

	@Query(value = "SELECT village.district,count(village.district) as y from village,wp3_peer_educator where village.code_village=wp3_peer_educator.code_village group by village.district", nativeQuery = true)
	List<Object[]> fetchData();

	//count
	@Query(value = "SELECT count(village.district) as y from village,wp3_peer_educator WHERE village.code_village=wp3_peer_educator.code_village", nativeQuery = true)
	long CamembertTot();

	@Query(value = "SELECT e.date_suivi as x,count(e.nom_prenom) as y FROM wp3_peer_educator e WHERE e.date_suivi BETWEEN ?1 AND ?2 GROUP BY e.date_suivi ORDER BY e.date_suivi ASC", nativeQuery = true)
	List<Object[]> TpsData(Date debut_date,Date fin_date);
	
	@Query(value = "SELECT village.code_village,village.district,count(wp3_peer_educator.sexe) as nbr, wp3_peer_educator.sexe FROM"
			+ " village,wp3_peer_educator WHERE wp3_peer_educator.sexe=?4 AND village.code_village=wp3_peer_educator.code_village AND wp3_peer_educator.code_village "
			+ " IN (null, ?3) AND wp3_peer_educator.date_suivi BETWEEN ?1 AND ?2 \r\n" + 
			"GROUP BY village.code_village,village.district, wp3_peer_educator.sexe", nativeQuery = true)
	List<Object[]> TableData(Date debut_date,Date fin_date,List<String> params,String sexe);
	
	@Query(value = "SELECT village.code_village,village.commune,count(wp3_peer_educator.sexe) as nbr, wp3_peer_educator.sexe FROM"
			+ " village,wp3_peer_educator WHERE wp3_peer_educator.sexe=?3 AND village.code_village=wp3_peer_educator.code_village AND "
			+ " wp3_peer_educator.date_suivi BETWEEN ?1 AND ?2 \r\n" + 
			"GROUP BY village.code_village,village.commune, wp3_peer_educator.sexe", nativeQuery = true)
	List<Object[]> TableDataCommune(Date debut_date,Date fin_date, String sexe);
	
	@Query(value = "SELECT village.district,count(wp3_peer_educator.sexe) as nbr, wp3_peer_educator.sexe FROM"
			+ " village,wp3_peer_educator WHERE wp3_peer_educator.sexe=?3 AND village.code_village=wp3_peer_educator.code_village "
			+ " AND wp3_peer_educator.date_suivi BETWEEN ?1 AND ?2 \r\n" + 
			"GROUP BY village.district, wp3_peer_educator.sexe", nativeQuery = true)
	List<Object[]> TableDataDist(Date debut_date,Date fin_date,String sexe);

}
