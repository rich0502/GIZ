package com.Giz.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Adoption_innovation;


public interface Adopte_InnovationRepository extends JpaRepository<Adoption_innovation, Long> {
	//liste des Beneficiaires
	@Query("SELECT e FROM Adoption_innovation e")
	List<Adoption_innovation> fetchAdoption_innovationData();
	
	@Modifying
    @Transactional
    @Query("delete from Adoption_innovation e where id_ai = ?1")
    void deleteAdoption_innovation(Long id_ai);
	
	@Query("SELECT f FROM Adoption_innovation f WHERE f.id_ai = ?1")
	Adoption_innovation findByIdAdoption_innovation(Long id_ai);
	
	@Query("SELECT COUNT(u) FROM Adoption_innovation u WHERE u.genre_ai=?1")
	 Long countAdoption_innov(String name);
	
}

