package com.Giz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Giz.data.domain.Tracker;
import com.Giz.repository.TrackerRepository;

@Service
@Transactional
public class TrackerServiceImpl implements TrackerService {

	@Autowired
	private TrackerRepository trackerRepository;
	
	@Override
	public Tracker addTracker(Tracker uploads) throws Exception {
		// TODO Auto-generated method stub
		return trackerRepository.save(uploads);
	}

	@Override
	public List<Tracker> getTracker(String type_tracker) throws Exception {
		List<Tracker> list = trackerRepository.ListTracker(type_tracker);
		return list;
	}

	
}
