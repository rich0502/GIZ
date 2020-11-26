package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Wp3FedeMfr;

public interface Wp3FedeMfrService {

	public List<Wp3FedeMfr> ListWp3FedeMfr();

	public void addWp3FedeMfr(String code_region, String nom_mfr, int annee_miseplace, boolean statut,
			boolean reglement_interieur, boolean recepisse_mfr, Date date_recepisse, boolean plan_strategique,
			Date date_validation);
}
