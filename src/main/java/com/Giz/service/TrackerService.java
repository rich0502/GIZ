package com.Giz.service;

import java.util.List;

import com.Giz.data.domain.Tracker;

public interface TrackerService {
	
	public Tracker addTracker(Tracker uploads) throws Exception;
	
	public List<Tracker> getTracker(String type_tracker) throws Exception;
	
	public void deleteTracker(Long id);

	public List<Object[]> historiqueList(String type_tracker);
	
}
