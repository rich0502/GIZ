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
	public List<Producteur> ListZone() {
		// TODO Auto-generated method stub
		return producteurRepository.ListZone();
	}

	@Override
	public List<Producteur> ListFkt(String zone) {
		// TODO Auto-generated method stub
		return producteurRepository.ListFkt(zone);
	}
	
	@Override
	public List<Producteur> ListProd(String code_fkt) {
		// TODO Auto-generated method stub
		return producteurRepository.ListProd(code_fkt);
	}

}
