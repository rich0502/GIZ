package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Adoption_innovation;
import com.Giz.repository.Adopte_InnovationRepository;

@Service
public class AdopteInnovationServiceImpl implements AdopteInnovationService {
	
	@Autowired
	private Adopte_InnovationRepository adopte_InnovationRepository;

	@Override
	public List<Adoption_innovation> ListAdoption_innovation() {
		// TODO Auto-generated method stub
		return adopte_InnovationRepository.findAll();
	}

	@Override
	public void deleteAdoption_innovation(Long id_ai) {
		adopte_InnovationRepository.deleteAdoption_innovation(id_ai);
		
	}

	@Override
	public void addAdoption_innovation(String code_pro, String nomPrenom_ai, String genre_ai, String annee_naiss,
			Date date_suivi, String type) {
		Adoption_innovation ai = new Adoption_innovation();
		ai.setNomPrenom_ai(nomPrenom_ai);
		ai.setCode_pro(code_pro);
		ai.setGenre_ai(genre_ai);
		ai.setAnnee_naiss(annee_naiss);
		ai.setDate_suivi(date_suivi);
		ai.setType(type);
		adopte_InnovationRepository.save(ai);
		
	}

	@Override
	public void modifyAdoption_innovation(Adoption_innovation adoption_innovation, String code_pro, String nomPrenom_ai,
			String genre_ai, String annee_naiss, Date date_suivi, String type, Long id_ai) {
		adoption_innovation.setNomPrenom_ai(nomPrenom_ai);
		adoption_innovation.setCode_pro(code_pro);
		adoption_innovation.setGenre_ai(genre_ai);
		adoption_innovation.setAnnee_naiss(annee_naiss);
		adoption_innovation.setDate_suivi(date_suivi);
		adoption_innovation.setType(type);
		adopte_InnovationRepository.save(adoption_innovation);
		
	}

	@Override
	public long CountAdoption() {
		return adopte_InnovationRepository.count();
	}

}
