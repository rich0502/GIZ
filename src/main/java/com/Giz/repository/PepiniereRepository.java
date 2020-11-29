package com.Giz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Giz.data.domain.Pepiniere;

public interface PepiniereRepository extends JpaRepository<Pepiniere, Long> {

	 @Query("SELECT COUNT(u) FROM Pepiniere u WHERE u.genre_pep=?1")
	 Long countPepiniere(String name);
}
