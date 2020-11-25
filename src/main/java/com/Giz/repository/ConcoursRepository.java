package com.Giz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Giz.data.domain.Concours;


public interface ConcoursRepository extends JpaRepository<Concours, Long> {
		
}

