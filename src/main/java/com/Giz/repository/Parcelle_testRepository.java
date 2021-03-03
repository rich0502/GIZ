package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Parcelle_test;


public interface Parcelle_testRepository extends JpaRepository<Parcelle_test, Long> {
	@Query("SELECT f FROM Parcelle_test f WHERE f.type = ?1")
	List<Parcelle_test> findByIdParcellTestVanille(String type);
	
	 @Query("SELECT COUNT(u) FROM Parcelle_test u WHERE u.type=?1")
	 Long countParcelVanille(String name);
}
