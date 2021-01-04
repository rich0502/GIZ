package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Giz.data.domain.Tracker;;


@Repository
public interface TrackerRepository extends CrudRepository<Tracker, Long> {
	
	@Query(value = "SELECT * FROM Tracker where type_tracker=:type_tracker",  nativeQuery = true)
	List<Tracker> ListTracker(String type_tracker);
}
