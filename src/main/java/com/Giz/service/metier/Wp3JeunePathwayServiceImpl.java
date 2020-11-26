package com.Giz.service.metier;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Wp3JeunePathway;
import com.Giz.repository.Wp3JeunePathwayRepository;

@Service
public class Wp3JeunePathwayServiceImpl implements Wp3JeunePathwayService {

	@Autowired
	Wp3JeunePathwayRepository wp3JeunePathwayRepository;

	@Override
	public List<Wp3JeunePathway> ListWp3JeunePathway() {
		// TODO Auto-generated method stub
		return wp3JeunePathwayRepository.findAll();
	}

	@Override
	public void addWp3JeunePathway(String code_village, String nom_prenom, String sexe, int annee_naissance,
			Date date_fin_frm) {

		Wp3JeunePathway wp3JeunePathway = new Wp3JeunePathway();
		
		wp3JeunePathway.setCode_village(code_village);
		wp3JeunePathway.setNom_prenom(nom_prenom);
		wp3JeunePathway.setSexe(sexe);
		wp3JeunePathway.setAnnee_naissance(annee_naissance);
		wp3JeunePathway.setDate_fin_frm(date_fin_frm);
		
		wp3JeunePathwayRepository.save(wp3JeunePathway);
		
	}
}
