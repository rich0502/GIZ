package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Formation_culture;
import com.Giz.repository.Formation_cultureRepository;

@Service
public class Formation_cultureServiceImpl implements Formation_cultureService{
	
	@Autowired
	Formation_cultureRepository formation_cultureRepository;
	
	@Override
	public List<Formation_culture> ListFormation_cultureAll() {
		// TODO Auto-generated method stub
		return formation_cultureRepository.findAll();
	}

	@Override
	public List<Formation_culture> ListFormation_culture(String code_prod) {
		// TODO Auto-generated method stub
		return formation_cultureRepository.findByCodeProd(code_prod);
	}

}
