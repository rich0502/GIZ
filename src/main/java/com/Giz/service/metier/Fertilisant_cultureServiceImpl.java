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
		return fertilisant_cultureRepository.findByCodeProd(code_prod);
	}
	
	@Override
	public void addFertilisantCulture(long id,String code_prod, String use_fertilisant, String type_use, String autre,
			String qte, int nbr_ans) {
		Fertilisant_culture fertil = new Fertilisant_culture();
		fertil.setId(id);
		fertil.setCode_pro(code_prod);
		fertil.setUse_fertilisant(use_fertilisant);
		fertil.setType_use(type_use);
		fertil.setAutre(autre);
		fertil.setQte(qte);
		fertil.setNbr_ans(nbr_ans);
		fertilisant_cultureRepository.save(fertil);
		
	}

	@Override
	public List<Fertilisant_culture> ListFertilisant_cultureAll() {
		// TODO Auto-generated method stub
		return fertilisant_cultureRepository.findAll();
	}

}
