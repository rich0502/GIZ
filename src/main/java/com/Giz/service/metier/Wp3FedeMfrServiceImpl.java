package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Wp3FedeMfr;
import com.Giz.repository.Wp3FedeMfrRepository;

@Service
public class Wp3FedeMfrServiceImpl implements Wp3FedeMfrService {

	@Autowired
	Wp3FedeMfrRepository wp3FedeMfrRepository;

	@Override
	public List<Wp3FedeMfr> ListWp3FedeMfr() {
		// TODO Auto-generated method stub
		return wp3FedeMfrRepository.findAll();
	}

	@Override
	public void addWp3FedeMfr(String code_region, String nom_mfr, int annee_miseplace, boolean statut,
			boolean reglement_interieur, boolean recepisse_mfr, Date date_recepisse, boolean plan_strategique,
			Date date_validation) {

		Wp3FedeMfr wp3FedeMfr = new Wp3FedeMfr();

		wp3FedeMfr.setCode_region(code_region);
		wp3FedeMfr.setNom_mfr(nom_mfr);
		wp3FedeMfr.setAnnee_miseplace(annee_miseplace);
		wp3FedeMfr.setStatut(statut);
		wp3FedeMfr.setReglement_interieur(reglement_interieur);
		wp3FedeMfr.setRecepisse_mfr(recepisse_mfr);
		wp3FedeMfr.setDate_recepisse(date_recepisse);
		wp3FedeMfr.setPlan_strategique(plan_strategique);
		wp3FedeMfr.setDate_validation(date_validation);

		wp3FedeMfrRepository.save(wp3FedeMfr);

	}
}
