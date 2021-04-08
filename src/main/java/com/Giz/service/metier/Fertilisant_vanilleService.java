package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Fertilisant_vanille;

public interface Fertilisant_vanilleService {

	List<Fertilisant_vanille> ListFertilisant_vanille(String code_prod);
	
	public void addFertilisantVanille(String code_prod,String use_fertilisant, String type_use, String autre,String qte,int nbr_ans);

	List<Fertilisant_vanille> ListFertilisant_vanilleAll();

}
