package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Recherche;


public interface RechercheService {


	public List<Recherche> ListRecherche();
	
	public float countRecherche();

	public void deleteRecherche(Long id_re);
	
	public void addRecherche(String code_village, Date date_restitution, String theme, double nbr_hom, double nbr_fem, boolean pr, boolean producteurs,
			boolean ep, boolean std_ctd, boolean autres);
	
	
	public void modifyRecherche(Recherche recherche,String code_village, Date date_restitution, String theme, double nbr_homme, double nbr_femme, boolean pr, boolean producteurs,
			boolean ep, boolean std_ctd, boolean autres, Long id_re);
	
}
