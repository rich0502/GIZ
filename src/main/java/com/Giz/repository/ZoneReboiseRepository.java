package com.Giz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Adoption_innovation;
import com.Giz.data.domain.ZoneReboise;


public interface ZoneReboiseRepository extends JpaRepository<ZoneReboise, Long> {
	
}

