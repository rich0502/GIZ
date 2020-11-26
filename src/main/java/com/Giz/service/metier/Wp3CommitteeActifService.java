package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Wp3CommitteeActif;

public interface Wp3CommitteeActifService {

	public List<Wp3CommitteeActif> ListWp3CommitteeActif();

	public void addWp3CommitteeActif(String code_village, String nom_comite, String mois_annee_creation,
			boolean committee_actif, Date date_suivi, int effectif_membre, int sexe_h, int sexe_f);
}
