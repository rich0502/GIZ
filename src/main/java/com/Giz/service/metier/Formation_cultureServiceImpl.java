package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

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

	@Override
	public void addFormationCulture(long id,String code_prod, String recu_formation, String quelle_formation,
			String autre_formation, String recu_dernier_form, String change_observer) {
		Formation_culture formation = new Formation_culture();
		Optional<Formation_culture> getId = formation_cultureRepository.existCodeProd(code_prod);

		formation.setCode_prod(code_prod);
		formation.setRecu_formation(recu_formation);
		formation.setQuelle_formation(quelle_formation);
		formation.setAutre_formation(autre_formation);
		formation.setRecu_dernier_form(recu_dernier_form);
		formation.setChange_observer(change_observer);
		
		if(existCodeProd(code_prod).isPresent()) {
			formation.setId(getId.get().getId());
			formation_cultureRepository.save(formation);
		}else {
			formation.setId(id);
			formation_cultureRepository.save(formation);
		}
		
	}

	@Override
	public Optional<Formation_culture> existCodeProd(String code_prod) {
		// TODO Auto-generated method stub
		return formation_cultureRepository.existCodeProd(code_prod);
	}

}
