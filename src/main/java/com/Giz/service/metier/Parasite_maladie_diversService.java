package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Parasite_maladie_divers;


public interface Parasite_maladie_diversService {

	List<Parasite_maladie_divers> ListParasite_maladie_divers(String code_prod);
	
	public void addParasiteMaladieDivers (String code_prod,String constate, String nom_mp, String periode, String pourcentage, String traitement, String mecanique,
			String chimique, String chimique_qte, String biologique, String autre, String frequence, String effets);

	List<Parasite_maladie_divers> ListParasite_maladie_diversAll();

}
