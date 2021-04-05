package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Parasite_maladie_divers;
import com.Giz.repository.Parasite_maladie_diversRepository;

@Service
public class Parasite_maladie_diversServiceImpl implements Parasite_maladie_diversService {

	@Autowired
	Parasite_maladie_diversRepository parasite_maladie_diversRepository;
	
	@Override
	public List<Parasite_maladie_divers> ListParasite_maladie_divers(String code_prod) {
		// TODO Auto-generated method stub
		return parasite_maladie_diversRepository.findByCodeProd(code_prod);
	}

}
