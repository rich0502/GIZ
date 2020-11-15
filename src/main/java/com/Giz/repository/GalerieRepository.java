package com.Giz.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Giz.data.domain.Galerie;

@Repository
public interface GalerieRepository extends CrudRepository<Galerie, Long> {

	@Query(value = "UPDATE galeries SET nom_album = ?2 WHERE id = ?1 ", nativeQuery = true)
	public void modifGalerie(Long id, String nom_album);
}
