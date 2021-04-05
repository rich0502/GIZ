package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Fertilisant_culture;
import com.Giz.repository.Fertilisant_cultureRepository;

@Service
public class Fertilisant_cultureServiceImpl implements Fertilisant_cultureService {

	@Autowired
	private Fertilisant_cultureRepository fertilisant_cultureRepository ;
	
	@Override
	public List<Fertilisant_culture> ListFertilisant_culture(String code_prod) {
		// TODO Auto-generated method stub
		return fertilisant_cultureRepository.findAll();
	}

}
