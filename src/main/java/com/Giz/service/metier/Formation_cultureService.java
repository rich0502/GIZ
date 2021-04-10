package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Formation_culture;


public interface Formation_cultureService {

	List<Formation_culture> ListFormation_cultureAll();

	List<Formation_culture> ListFormation_culture(String code_prod);
	
	public void addFormationCulture(long id,String code_prod,String recu_formation, String quelle_formation, String autre_formation,String recu_dernier_form, String change_observer);

}
