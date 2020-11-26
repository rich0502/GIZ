package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Wp3JeuneFormeMfr;

public interface Wp3JeuneFormeMfrService {

	public List<Wp3JeuneFormeMfr> ListWp3JeuneFormeMfr();

	public void addWp3JeuneFormeMfr(String code_village, String nom_prenom, String sexe, int annee_naissance,
			boolean forme, boolean accompagne_sortie, String type_accompagnement, Date date_suivi);
}
