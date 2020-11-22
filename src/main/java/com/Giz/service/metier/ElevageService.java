package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Elevage;


public interface ElevageService {


	public List<Elevage> ListElevage();

	public void deleteElevage(Long id_elev);
	
	public void addElevage(String code_village, float x, float y, String nomResponsable, String genre_elev,
			int annee_naiss, String pratique_realise, int date_mise, String tf, double nbr_visiteurs,
			Date date_suivi, boolean operationnel);
	
	
	public void modifyElevage(Elevage elevage,String code_village, float x, float y, String nomResponsable, String genre_elev,
			int annee_naiss, String pratique_realise, int date_mise, String tf, double nbr_visiteur,
			Date date_suivi, boolean operationnel, Long id_elev);

	public void addFerme(String code_villag, float cord_x, float cord_y, String nomResponsabl, String genre,
			int annee_nais, Date date_suiv, boolean operationnels);
	
}
