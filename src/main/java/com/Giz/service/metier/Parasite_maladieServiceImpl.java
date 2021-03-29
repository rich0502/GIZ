package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Parasite_maladie;
import com.Giz.repository.Parasite_maladieRepository;

@Service
public class Parasite_maladieServiceImpl implements Parasite_maladieService{
	
	@Autowired
	private Parasite_maladieRepository parasite_maladieRepository ;

	@Override
	public List<Parasite_maladie> ListParasite_maladie() {
		// TODO Auto-generated method stub
		return parasite_maladieRepository.findAll();
	}

}
