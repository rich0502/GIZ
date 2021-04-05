package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Technique_vanille;
import com.Giz.repository.Technique_vanilleRepository;

@Service
public class Technique_vanilleServiceImpl implements Technique_vanilleService{

	@Autowired
	private Technique_vanilleRepository technique_vanilleRepository ;
	
	@Override
	public List<Technique_vanille> ListTechnique_vanille(String code_prod) {
		// TODO Auto-generated method stub
		return technique_vanilleRepository.findByCodeProd(code_prod);
	}

}
