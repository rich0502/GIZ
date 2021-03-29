package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Formation_bpa;;


public interface FormationBpaService {


	public List<Formation_bpa> ListFormation_bpa();
	
	public long countbpa();

	public void deleteFormation_bpa(Long id_bpa);
	
	public void addFormation_bpa(String code_pro, String code_village, String nomPrenom_bpa, String genre_ai,
			int annee_naiss, String frm_recu, Date date_frm, String theme_frm);
	
	
	public void modifyFormation_bpa(Formation_bpa formation_bpa,String code_pro, String code_village, String nomPrenom_bpa, String genre_ai,
			int annee_naiss, String frm_recu, Date date_frm, String theme_frm, Long id_bpa);

	public void deleteAllFomBpa();
	
}
