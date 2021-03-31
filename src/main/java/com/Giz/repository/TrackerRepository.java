package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.Giz.data.domain.Tracker;;


@Repository
public interface TrackerRepository extends CrudRepository<Tracker, Long> {
	
	@Query(value = "SELECT * FROM Tracker where type_tracker=:type_tracker",  nativeQuery = true)
	List<Tracker> ListTracker(@Param("type_tracker") String type_tracker);
}
