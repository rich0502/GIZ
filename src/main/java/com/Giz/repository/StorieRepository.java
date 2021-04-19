package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Giz.data.domain.Storie;

@Repository
public interface StorieRepository extends CrudRepository<Storie, Long> {
	@Query(value = "SELECT * FROM Storie",  nativeQuery = true)
	List<Storie> ListStorie();

	@Query(value="SELECT storie.created_by, storie.creation_date, storie.last_modified_by, storie.last_modified_date FROM storie", nativeQuery = true)
	List<Object[]> historiqueList();
}
