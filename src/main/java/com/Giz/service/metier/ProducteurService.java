package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Producteur;

public interface ProducteurService {

	List<Producteur> ListZone();

	List<Producteur> ListFkt(String zone);
	
	List<Producteur> ListProd(String code_fkt);

}
