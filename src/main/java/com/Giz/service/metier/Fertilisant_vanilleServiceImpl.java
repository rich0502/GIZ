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
	public void addFertilisantVanille(long id,String code_prod, String use_fertilisant, String type_use, String autre,
			String qte, int nbr_ans) {
		Fertilisant_vanille fertil = new Fertilisant_vanille();
		fertil.setId(id);
		fertil.setCode_pro(code_prod);
		fertil.setUse_fertilisant(use_fertilisant);
		fertil.setType_use(type_use);
		fertil.setAutre(autre);
		fertil.setQte(qte);
		fertil.setNbr_ans(nbr_ans);
		fertilisant_vanilleRepository.save(fertil);
		}	
	public List<Fertilisant_vanille> ListFertilisant_vanilleAll() {
		// TODO Auto-generated method stub
		return fertilisant_vanilleRepository.findAll();
	}

}
