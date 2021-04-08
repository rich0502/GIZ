package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Fertilisant_vanille;
import com.Giz.repository.Fertilisant_vanilleRepository;

@Service
public class Fertilisant_vanilleServiceImpl implements Fertilisant_vanilleService{

	@Autowired
	private Fertilisant_vanilleRepository fertilisant_vanilleRepository ;
	
	@Override
	public List<Fertilisant_vanille> ListFertilisant_vanille(String code_prod) {
		// TODO Auto-generated method stub
		return fertilisant_vanilleRepository.findByCodeProd(code_prod);
	}

	@Override
	public List<Fertilisant_vanille> ListFertilisant_vanilleAll() {
		// TODO Auto-generated method stub
		return fertilisant_vanilleRepository.findAll();
	}

}
