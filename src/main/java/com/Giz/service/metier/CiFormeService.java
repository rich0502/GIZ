package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.CiForme;


public interface CiFormeService {


	public List<CiForme> ListCiForme();

	public void deleteCiForme(Long id_ci);
	
	public void addCiForme( String code_village, String nomPrenom_ci, String genre_ci, int annee_naiss,
			Date date_form, boolean equipe, String type_materiel, Date date_dotation);
	
	
	public void modifyCiForme(CiForme ciForme, String code_village, String nomPrenom_ci, String genre_ci, int annee_naiss,
			Date date_form, boolean equipe, String type_materiel, Date date_dotation, Long id_ci);

	public void deleteAllCI();
	
}
