package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Wp3UniteElevJeune;
import com.Giz.repository.Wp3UniteElevJeuneRepository;

@Service
public class Wp3UniteElevJeuneServiceImpl implements Wp3UniteElevJeuneService {

	@Autowired
	Wp3UniteElevJeuneRepository wp3UniteElevJeuneRepository;

	@Override
	public List<Wp3UniteElevJeune> ListWp3UniteElevJeune() {
		// TODO Auto-generated method stub
		return wp3UniteElevJeuneRepository.findAll();
	}

	@Override
	public void addWp3UniteElevJeune(String code_village, String nom_prenom, String sexe, int annee_naissance,
			String demarrage_unite, Date date_dem, String type_activite, String theme1_traite, Date date_suivi1) {

		Wp3UniteElevJeune wp3UniteElevJeune = new Wp3UniteElevJeune();

		wp3UniteElevJeune.setCode_village(code_village);
		wp3UniteElevJeune.setNom_prenom(nom_prenom);
		wp3UniteElevJeune.setSexe(sexe);
		wp3UniteElevJeune.setAnnee_naissance(annee_naissance);
		wp3UniteElevJeune.setDemarrage_unite(demarrage_unite);
		wp3UniteElevJeune.setDate_dem(date_dem);
		wp3UniteElevJeune.setType_activite(type_activite);
		wp3UniteElevJeune.setTheme1_traite(theme1_traite);
		wp3UniteElevJeune.setDate_suivi1(date_suivi1);
		/*
		 * wp3UniteElevJeune.setTheme2_traite(theme2_traite);
		 * wp3UniteElevJeune.setDate_suivi2(date_suivi2);
		 * wp3UniteElevJeune.setTheme3_traite(theme3_traite);
		 * wp3UniteElevJeune.setDate_suivi3(date_suivi3);
		 */

		wp3UniteElevJeuneRepository.save(wp3UniteElevJeune);

	}
}
