package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Formateur;

public interface FormateurService {
	
	public Formateur createFormElev(Formateur Formateur) throws Exception;

	public List<Formateur> ListFormateur();

	public void deleteFormateur(Long id_ft);
	
	public void addFormateur(String code_village, String nomPrenom, String zoneInterv, String genre_ft,
			int date_naiss, boolean operationnel, Date date_mise_place, Date date_suivi, Date date_debut,
			Date date_fin, String type_form);
	
	
	public void modifyFormateur(Formateur formateur,String code_village, String nomPrenom, String zoneInterv, String genre_ft,
			int date_naiss, boolean operationnel, Date date_mise_place, Date date_suivi, Date date_debut,
			Date date_fin, String type_form, Long id_ft);
	
	public void addFormateurElevage(String code_village, String nomPrenom,String genre_ft,
			int date_naiss, boolean operationnel, Date date_mise_place, Date date_suivi, String type_form);
	
	public List<Formateur> ListElevage(String type_form);
	
}
