package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Wp3ActivEcoJeune;

public interface Wp3ActivEcoJeuneService {

	public List<Wp3ActivEcoJeune> ListWp3ActivEcoJeune();

	public void addWp3ActivEcoJeune(String code_village, String nom_prenom, String sexe, int annee_naissance,
			String organisme_formateur, String frm_tech_suivi, Date date_fin_frm, String activite_eco,
			Date date_demarrage);
}
