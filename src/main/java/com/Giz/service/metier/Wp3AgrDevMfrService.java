package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Wp3AgrDevMfr;

public interface Wp3AgrDevMfrService {

	public List<Wp3AgrDevMfr> ListWp3AgrDevMfr();

	public void addWp3AgrDevMfr(String code_village, String nom_mfr, int annee_miseplace, String agr_developpe,
			Date date_eval, String type_agr_dev1, Date date_suivi1);
}
