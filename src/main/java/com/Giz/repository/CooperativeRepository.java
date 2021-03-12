package com.Giz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Giz.data.domain.Cooperative;

public interface CooperativeRepository extends JpaRepository<Cooperative, Long> {
	
}

