package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Info_parcelle_divers;

public interface Info_parcelle_diversService {

	List<Info_parcelle_divers> ListInfo_parcelle_divers(String code_prod);
	
	public void addInfoParcelleDivers (String code_prod, String type_culture, String nom_parcel, String periode_mise_culture, String periode_culture,String occupation_sol,
			String autre_occupation_sol,float volume_annee_precedent,float volume_annee_venir,float surface_parcelle,float rendement,int nbr_pieds,String etape_visite,String systeme_protection_sol,
			String systeme_utilise,String associe_parcel,String autre_associe_parcel, String inclinaison, String mise_anti_errosif, String technic_use, String photo_technique, String photo_culture);

	List<Info_parcelle_divers> ListInfo_parcelle_diversAll();

}
