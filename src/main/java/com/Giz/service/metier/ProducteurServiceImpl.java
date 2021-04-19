package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Producteur;
import com.Giz.repository.ProducteurRepository;
@Service
public class ProducteurServiceImpl implements ProducteurService{

	@Autowired
	private ProducteurRepository producteurRepository;
	
	@Override
	public List<Object[]> ListZone() {
		// TODO Auto-generated method stub
		return producteurRepository.ListZone();
	}

	@Override
	public List<Object[]> ListFkt(String zone) {
		// TODO Auto-generated method stub
		return producteurRepository.ListFkt(zone);
	}
	
	@Override
	public List<Object[]> ListProd(String code_fkt) {
		// TODO Auto-generated method stub
		return producteurRepository.ListProd(code_fkt);
	}

	@Override
	public List<Producteur> ListProducteur() {
		// TODO Auto-generated method stub
		return producteurRepository.ListProducteur();
	}
	
		@Override
	public void addProd(long id, String zone, String code_fkt, String code_prod, String nom_prod, String genre,
			String date_inspection, String date_naissance, String compte, String cin, String tel, String error_remonte,
			String photo_prod) {
		Producteur prod = new Producteur();
		prod.setId(id);
		prod.setZone(zone);
		prod.setCode_fkt(code_fkt);
		prod.setCode_prod(code_prod);
		prod.setNom_prod(nom_prod);
		prod.setGenre(genre);
		prod.setDate_inspection(date_inspection);
		prod.setDate_naissance(date_naissance);
		prod.setCompte(compte);
		prod.setCin(cin);
		prod.setTel(tel);
		prod.setError_remonte(error_remonte);
		prod.setPhoto_prod(photo_prod);
		producteurRepository.save(prod);
		
	}

}
