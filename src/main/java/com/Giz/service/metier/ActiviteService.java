package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Activite;

public interface ActiviteService {

	List<Activite> ListActivite();
	
	public void addActivite(long id,String type_intervention, String theme_principal, String sous_theme, String date_enreg,String nom_utilisateur, String gps_lat, String gps_long,String formateur
			,String code_formateur,String lieu_formation, String prod_present,String prod_externe,String participant_externe,String image1, String image2,String image3,String remarques);

}
