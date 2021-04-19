package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Fertilisant_culture;


public interface Fertilisant_cultureService {

	List<Fertilisant_culture> ListFertilisant_culture(String code_prod);
	
	public void addFertilisantCulture(long id, String code_prod,String use_fertilisant, String type_use, String autre,String qte,int nbr_ans);

	List<Fertilisant_culture> ListFertilisant_cultureAll();
	
	Optional<Fertilisant_culture> existCodeProd(String code_prod);

}
