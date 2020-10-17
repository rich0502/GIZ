package com.Giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Commune;
import com.Giz.data.domain.District;
import com.Giz.data.domain.Fokontany;
import com.Giz.repository.CommuneRepository;
import com.Giz.repository.DistrictRepository;
import com.Giz.repository.FokontanyRepository;





@Service
public class ZoneServiceImpl implements ZoneService {

	@Autowired
    private DistrictRepository repo;
	
	@Autowired
	private CommuneRepository communeRepository;
	
	@Autowired
	private FokontanyRepository fokontanyRepository;
	
	@Override
	public List<District> getDistrict() {
		// TODO Auto-generated method stub
		return repo.fetchDistrictData();
	}

	@Override
	public List<Commune> getCommune() {
		// TODO Auto-generated method stub
		return communeRepository.fetchCommuneData();
	}

	@Override
	public List<Fokontany> getFokontany() {
		// TODO Auto-generated method stub
		return fokontanyRepository.fetchFokontanyData();
	}
	


	

}
