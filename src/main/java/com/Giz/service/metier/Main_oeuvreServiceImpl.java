package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Main_oeuvre;
import com.Giz.repository.Main_oeuvreRepository;

@Service
public class Main_oeuvreServiceImpl implements Main_oeuvreService {
	
	@Autowired
	private Main_oeuvreRepository main_oeuvreRepository ;
	
	@Override
	public List<Main_oeuvre> ListMain_oeuvre(String code_prod) {
		// TODO Auto-generated method stub
		return main_oeuvreRepository.findByCodeProd(code_prod);
	}

}
