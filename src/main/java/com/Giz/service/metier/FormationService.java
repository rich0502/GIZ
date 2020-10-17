package com.Giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.Giz.data.domain.Formation;;


public interface FormationService {


	public List<Formation> ListFormation();

	public void deleteFormation(Long id_form);
	
	public void addFormation(String nom_form,
			String type_form, String district_form, String commune_form, String fkt_form);
	
	
	public void modifyFormation(Formation formation, String nom_form,
			String type_form, String district_form, String commune_form, String fkt_form, Long id_form);
	
}
