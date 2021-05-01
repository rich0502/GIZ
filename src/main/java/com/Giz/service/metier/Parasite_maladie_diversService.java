package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Parasite_maladie_divers;


public interface Parasite_maladie_diversService {

	List<Parasite_maladie_divers> ListParasite_maladie_divers(String code_prod);
	
	public void addParasiteMaladieDivers (long id, String code_prod,String constate, String nom_mp, String periode, String pourcentage, String traitement, String mecanique,
			String chimique, String chimique_qte, String biologique, String autre, String frequence, String effets);

	List<Parasite_maladie_divers> ListParasite_maladie_diversAll();
	
	Optional<Parasite_maladie_divers> existCodeProd(String code_prod);

	List<Parasite_maladie_divers> ListParasite_maladie_diversAllFkt(String zone);

	List<Parasite_maladie_divers> ListParasite_maladie_diversAllProd(String code_fkt);

}
