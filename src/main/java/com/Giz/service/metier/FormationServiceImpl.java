package com.Giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Formation;
import com.Giz.repository.FormationRepository;



@Service
public class FormationServiceImpl implements FormationService {
	@Autowired
	private FormationRepository formationRepository;

	@Override
	public List<Formation> ListFormation() {
		// TODO Auto-generated method stub
		return formationRepository.fetchFormationData();
	}

	@Override
	public void deleteFormation(Long id_form) {
		formationRepository.deleteFormation(id_form);		
	}

	@Override
	public void addFormation(String nom_form, String type_form, String district_form, String commune_form,
			String fkt_form) {
		Formation formation = new Formation();
		formation.setNom_form(nom_form);
		formation.setType_form(type_form);
		formation.setDistrict_form(district_form);
		formation.setCommune_form(commune_form);
		formation.setFkt_form(fkt_form);
		formationRepository.save(formation);
	}

	@Override
	public void modifyFormation(Formation formation, String nom_form, String type_form, String district_form,
			String commune_form, String fkt_form, Long id_form) {
		formation.setNom_form(nom_form);
		formation.setType_form(type_form);
		formation.setDistrict_form(district_form);
		formation.setCommune_form(commune_form);
		formation.setFkt_form(fkt_form);
		formationRepository.save(formation);
		
	}


	

	

}
