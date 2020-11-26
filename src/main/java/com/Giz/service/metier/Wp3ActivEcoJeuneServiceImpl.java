package com.Giz.service.metier;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Wp3ActivEcoJeune;
import com.Giz.repository.Wp3ActivEcoJeuneRepository;

@Service
public class Wp3ActivEcoJeuneServiceImpl implements Wp3ActivEcoJeuneService {

	@Autowired
	Wp3ActivEcoJeuneRepository wp3ActivEcoJeuneRepository;

	@Override
	public List<Wp3ActivEcoJeune> ListWp3ActivEcoJeune() {
		// TODO Auto-generated method stub
		return wp3ActivEcoJeuneRepository.findAll();
	}

	@Override
	public void addWp3ActivEcoJeune(String code_village, String nom_prenom, String sexe, int annee_naissance,
			String organisme_formateur, String frm_tech_suivi, Date date_fin_frm, String activite_eco,
			Date date_demarrage) {

		Wp3ActivEcoJeune wp3ActivEcoJeune = new Wp3ActivEcoJeune();
		
		wp3ActivEcoJeune.setCode_village(code_village);
		wp3ActivEcoJeune.setNom_prenom(nom_prenom);
		wp3ActivEcoJeune.setSexe(sexe);
		wp3ActivEcoJeune.setAnnee_naissance(annee_naissance);
		wp3ActivEcoJeune.setOrganisme_formateur(organisme_formateur);
		wp3ActivEcoJeune.setFrm_tech_suivi(frm_tech_suivi);
		wp3ActivEcoJeune.setDate_fin_frm(date_fin_frm);
		wp3ActivEcoJeune.setActivite_eco(activite_eco);
		wp3ActivEcoJeune.setDate_demarrage(date_demarrage);

		wp3ActivEcoJeuneRepository.save(wp3ActivEcoJeune);
		
	}
}
