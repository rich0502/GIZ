package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.District;
import com.Giz.data.domain.Commune;
import com.Giz.data.domain.Fokontany;

public interface ZoneService {


	public List<District> getDistrict();

	public List<Commune> getCommune();
	
	public List<Fokontany> getFokontany();
}
