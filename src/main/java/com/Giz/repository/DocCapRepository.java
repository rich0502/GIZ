package com.Giz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Giz.data.domain.DocCap;


public interface DocCapRepository extends JpaRepository<DocCap, Long> {
	
}

