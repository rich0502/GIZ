package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Village;

public interface VillageRepository extends JpaRepository<Village, Long>{
	//liste des articles à l'accueil
	@Query("SELECT e FROM Village e")
	List<Village> fetchVillageData();
		
}
