package com.Giz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Giz.data.domain.ParcelleVG;


public interface PvgRepository extends JpaRepository<ParcelleVG, Long> {
	
}

