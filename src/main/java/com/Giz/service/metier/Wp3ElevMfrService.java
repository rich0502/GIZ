package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Wp3ElevMfr;

public interface Wp3ElevMfrService {

	public List<Wp3ElevMfr> ListWp3ElevMfr();

	public void addWp3ElevMfr(String code_village, String nom_prenom, String village_origine, String sexe,
			int annee_naissance, boolean inscrit, int annee_inscription, Date date_suivi, String type_frm,
			int annee_etude, Date date_sortie, String type_projet, String niveau_demarrage, Date date_validation,
			boolean accompagne, Date date_suivi1, Date date_suivi2, Date date_suivi3, Date date_suivi4);
}
