package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Formations;

public interface FormationsService {
	
	public Formations createFormFBS(Formations Formations) throws Exception;
	
	public Formations createFormEFA(Formations Formations) throws Exception;

	public List<Formations> ListFormations();

	public void deleteFormateur(Long id_ft);
	
	public void addFormations( String code_village, String nom_eleveur, String genre_form, int annee_naiss,
			String formation_recu, String theme_formation, Date date_forma, String type_formation);
	
	public void modifyFormations(Formations formations,String code_village, String nom_eleveur, String genre_form, int annee_naiss,
			String formation_recu, String theme_formation, Date date_forma,
			String type_formation, Long id_forms);
	
	public void addFormEFA(String code_village, String nom_eleveur, String genre_form, int annee_naiss,
			String formation_recu, String theme_formation, Date date_forma, boolean adoption, String pratique_adopte, String type_formation);
	
	
	public void modifyFormEFA(Formations formations,String code_village, String nom_eleveur, String genre_form, int annee_naiss,
			String formation_recu, String theme_formation, Date date_forma, boolean adoption, String pratique_adopte, String type_formation, Long id_forms);
	
	public List<Formations> ListFormations(String type_form);
	
}
