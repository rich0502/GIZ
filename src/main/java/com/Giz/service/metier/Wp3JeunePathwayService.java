package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Wp3JeunePathway;

public interface Wp3JeunePathwayService {

	public List<Wp3JeunePathway> ListWp3JeunePathway();

	public void addWp3JeunePathway(String code_village, String nom_prenom, String sexe, int annee_naissance,
			Date date_fin_frm);
}
