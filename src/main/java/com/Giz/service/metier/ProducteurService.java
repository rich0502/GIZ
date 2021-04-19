package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Producteur;

public interface ProducteurService {

	List<Object[]> ListZone();

	List<Object[]> ListFkt(String zone);
	
	List<Object[]> ListProd(String code_fkt);

	List<Producteur> ListProducteur();
	
	public void addProd(long id, String zone, String code_fkt, String code_prod, String nom_prod, String genre, String date_inspection, String date_naissance, String compte, String cin, String tel, String error_remonte, String photo_prod);

}
