package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.Giz.data.domain.Formations;

public interface FormationsRepository extends JpaRepository<Formations, Long> {
	
	@Query("SELECT p FROM Formations p WHERE p.type_formation = ?1" )
	List<Formations> findFormations(String type_formation);

}
