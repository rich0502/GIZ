package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Giz.data.domain.Uploads;


@Repository
public interface UploadsRepository extends CrudRepository<Uploads, Long> {
	@Query(value = "SELECT * FROM Uploads",  nativeQuery = true)
	List<Uploads> ListUploads();
}
