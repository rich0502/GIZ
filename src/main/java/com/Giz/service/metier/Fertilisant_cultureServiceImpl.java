package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

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
		return fertilisant_cultureRepository.findByCodeProd(code_prod);
	}
	
	@Override
	public void addFertilisantCulture(long id,String code_pro, String use_fertilisant, String type_use, String autre,
			String qte, int nbr_ans) {
		Fertilisant_culture fertil = new Fertilisant_culture();
		Optional<Fertilisant_culture> getId = fertilisant_cultureRepository.existCodeProd(code_pro);
		fertil.setCode_pro(code_pro);
		fertil.setUse_fertilisant(use_fertilisant);
		fertil.setType_use(type_use);
		fertil.setAutre(autre);
		fertil.setQte(qte);
		fertil.setNbr_ans(nbr_ans);
		
		if(existCodeProd(code_pro).isPresent()) {
			fertil.setId(getId.get().getId());
			fertilisant_cultureRepository.save(fertil);
		}else {
			fertil.setId(id);
			fertilisant_cultureRepository.save(fertil);
		}	
		
	}

	@Override
	public List<Fertilisant_culture> ListFertilisant_cultureAll() {
		// TODO Auto-generated method stub
		return fertilisant_cultureRepository.findAll();
	}

	@Override
	public Optional<Fertilisant_culture> existCodeProd(String code_prod) {
		// TODO Auto-generated method stub
		return fertilisant_cultureRepository.existCodeProd(code_prod);
	}

	@Override
	public List<Fertilisant_culture> ListFertilisant_cultureAllFkt(String zone) {
		// TODO Auto-generated method stub
		return fertilisant_cultureRepository.ListFertilisant_cultureAllFkt(zone);
	}

	@Override
	public List<Fertilisant_culture> ListFertilisant_cultureAllProd(String code_fkt) {
		// TODO Auto-generated method stub
		return fertilisant_cultureRepository.ListFertilisant_cultureAllProd(code_fkt);
	}

}
