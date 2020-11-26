package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Wp3UniteElevJeune;

public interface Wp3UniteElevJeuneService {

	public List<Wp3UniteElevJeune> ListWp3UniteElevJeune();

	public void addWp3UniteElevJeune(String code_village, String nom_prenom, String sexe, int annee_naissance,
			String demarrage_unite, Date date_dem, String type_activite, String theme1_traite, Date date_suivi1);
}
