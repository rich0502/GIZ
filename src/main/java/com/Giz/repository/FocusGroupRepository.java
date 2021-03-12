package com.Giz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Giz.data.domain.FocusGroup;

public interface FocusGroupRepository extends JpaRepository<FocusGroup, Long> {
	
}

