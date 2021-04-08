package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Fertilisant_culture;


public interface Fertilisant_cultureService {

	List<Fertilisant_culture> ListFertilisant_culture(String code_prod);
	
	public void addFertilisantCulture(String code_prod,String use_fertilisant, String type_use, String autre,String qte,int nbr_ans);

}
