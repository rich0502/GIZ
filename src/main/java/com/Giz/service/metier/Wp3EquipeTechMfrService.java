package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Wp3EquipeTechMfr;

public interface Wp3EquipeTechMfrService {

	public List<Wp3EquipeTechMfr> ListWp3EquipeTechMfr();

	public void addWp3EquipeTechMfr(String code_village, String nom_prenom, String sexe, int annee_naissance,
			String frm_recue1, boolean competence_frm, Date date_eval);
}
