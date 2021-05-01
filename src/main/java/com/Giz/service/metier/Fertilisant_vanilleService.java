package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Fertilisant_vanille;

public interface Fertilisant_vanilleService {

	List<Fertilisant_vanille> ListFertilisant_vanille(String code_prod);
	
	public void addFertilisantVanille(long id,String code_prod,String use_fertilisant, String type_use, String autre,String qte,int nbr_ans);

	List<Fertilisant_vanille> ListFertilisant_vanilleAll();
	
	Optional<Fertilisant_vanille> existCodeProd(String code_prod);

	List<Fertilisant_vanille> ListFertilisant_vanilleAllFkt(String zone);

	List<Fertilisant_vanille> ListFertilisant_vanilleAllProd(String code_fkt);

}
