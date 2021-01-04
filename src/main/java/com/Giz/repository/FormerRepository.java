package com.Giz.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Former;
import com.Giz.data.domain.GraphDistrict;
import com.Giz.data.domain.TpsFormes;


public interface FormerRepository extends JpaRepository<Former, Long> {
	//liste des Beneficiaires
	@Query("SELECT e FROM Former e")
	List<Former> fetchFormerData();
	
	@Modifying
    @Transactional
    @Query("delete from Former e where id = ?1")
    void deleteFormer(Long id);
	
	@Query("SELECT f FROM Former f WHERE f.id = ?1")
	Former findByIdFormer(Long id);
	
	//liste des Beneficiaires
	@Query("SELECT e FROM Former e INNER JOIN e.formation INNER JOIN e.beneficiaire")
	List<Former> fetchFormesData();
	
	//liste graphe chart animated
	@Query("SELECT new com.Giz.data.domain.GraphDistrict(e.formation.district_form, count(e.formation.commune_form) as y) FROM Former e INNER JOIN e.formation group by e.formation.district_form")
	List<GraphDistrict> fetchFormsData();
	
	//liste
	@Query("SELECT count(e) as tot FROM Former e")
	int SomFormerData();
	
	//liste
	@Query("SELECT new com.Giz.data.domain.TpsFormes(e.date_frm as x, count(e.date_frm) as y) FROM Former e WHERE e.date_frm BETWEEN ?1 AND ?2 group by e.date_frm order by e.date_frm ASC")
	List<TpsFormes> TpsFormerData(Date debut_date,Date fin_date);
	

	
}