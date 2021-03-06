package com.Giz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.Giz.data.domain.Tracker;;


@Repository
public interface TrackerRepository extends CrudRepository<Tracker, Long> {
	
	@Query(value = "SELECT * FROM Tracker where type_tracker=:type_tracker",  nativeQuery = true)
	List<Tracker> ListTracker(@Param("type_tracker") String type_tracker);

	@Query(value="SELECT tracker.created_by, tracker.creation_date, tracker.last_modified_by, tracker.last_modified_date FROM tracker WHERE type_tracker=?1", nativeQuery = true)
	List<Object[]> historiqueList(String type_tracker);
}
