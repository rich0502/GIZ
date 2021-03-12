package com.Giz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Giz.data.domain.ThemeRealise;

public interface ThemeRepository extends JpaRepository<ThemeRealise, Long> {
	
}

