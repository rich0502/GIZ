package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Formation_culture;


public interface Formation_cultureService {

	List<Formation_culture> ListFormation_cultureAll();

	List<Formation_culture> ListFormation_culture(String code_prod);

}
