package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Formateur;

public interface FormateursRepository extends JpaRepository<Formateur, Long> {
	
	@Query("SELECT p FROM Formateur p WHERE p.type_form = ?1" )
	List<Formateur> findElevage(String type_form);
}
