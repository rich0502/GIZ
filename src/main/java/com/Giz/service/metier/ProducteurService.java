package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Producteur;

public interface ProducteurService {

	List<Object[]> ListZone();

	List<Object[]> ListFkt(String zone);
	
	List<Object[]> ListProd(String code_fkt);

	List<Producteur> ListProducteur();

}
