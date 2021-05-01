package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Formation_culture;


public interface Formation_cultureService {

	List<Formation_culture> ListFormation_cultureAll();

	List<Formation_culture> ListFormation_culture(String code_prod);
	
	public void addFormationCulture(long id,String code_prod,String recu_formation, String quelle_formation, String autre_formation,String recu_dernier_form, String change_observer);
	
	Optional<Formation_culture> existCodeProd(String code_prod);

	List<Formation_culture> ListFormation_cultureAllFkt(String zone);

	List<Formation_culture> ListFormation_cultureAllProd(String code_fkt);

}
