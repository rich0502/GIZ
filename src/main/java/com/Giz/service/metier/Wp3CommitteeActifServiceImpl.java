package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Wp3CommitteeActif;
import com.Giz.repository.Wp3CommitteeActifRepository;

@Service
public class Wp3CommitteeActifServiceImpl implements Wp3CommitteeActifService {

	@Autowired
	Wp3CommitteeActifRepository wp3CommitteeActifRepository;

	@Override
	public List<Wp3CommitteeActif> ListWp3CommitteeActif() {
		// TODO Auto-generated method stub
		return wp3CommitteeActifRepository.findAll();
	}

	@Override
	public void addWp3CommitteeActif(String code_village, String nom_comite, String mois_annee_creation,
			boolean committee_actif, Date date_suivi, int effectif_membre, int sexe_h, int sexe_f) {

		Wp3CommitteeActif wp3CommitteeActif = new Wp3CommitteeActif();

		wp3CommitteeActif.setCode_village(code_village);
		wp3CommitteeActif.setNom_comite(nom_comite);
		wp3CommitteeActif.setMois_annee_creation(mois_annee_creation);
		wp3CommitteeActif.setCommittee_actif(committee_actif);
		wp3CommitteeActif.setDate_suivi(date_suivi);
		wp3CommitteeActif.setEffectif_membre(effectif_membre);
		wp3CommitteeActif.setSexe_h(sexe_h);
		wp3CommitteeActif.setSexe_f(sexe_f);

		wp3CommitteeActifRepository.save(wp3CommitteeActif);

	}
}
