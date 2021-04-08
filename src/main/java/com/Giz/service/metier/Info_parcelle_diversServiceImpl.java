package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Info_parcelle_divers;
import com.Giz.repository.Info_parcelle_diversRepository;

@Service
public class Info_parcelle_diversServiceImpl implements Info_parcelle_diversService {

	@Autowired
	private Info_parcelle_diversRepository info_parcelle_diversRepository ;
	
	@Override
	public List<Info_parcelle_divers> ListInfo_parcelle_divers(String code_prod) {
		// TODO Auto-generated method stub
		return info_parcelle_diversRepository.findByCodeProd(code_prod);
	}

	@Override
	public void addInfoParcelleDivers(String code_prod, String type_culture, String nom_parcel,
			String periode_mise_culture, String periode_culture, String occupation_sol, String autre_occupation_sol,
			float volume_annee_precedent, float volume_annee_venir, float surface_parcelle, float rendement,
			int nbr_pieds, String etape_visite, String systeme_protection_sol, String systeme_utilise,
			String associe_parcel, String autre_associe_parcel, String inclinaison, String mise_anti_errosif,
			String technic_use, String photo_technique, String photo_culture) {
		Info_parcelle_divers info = new Info_parcelle_divers();
		info.setCode_prod(code_prod);
		info.setType_culture(type_culture);
		info.setNom_parcel(nom_parcel);
		info.setPeriode_mise_culture(periode_mise_culture);
		info.setPeriode_culture(periode_culture);
		info.setOccupation_sol(occupation_sol);
		info.setAutre_occupation_sol(autre_occupation_sol);
		info.setVolume_annee_precedent(volume_annee_precedent);
		info.setVolume_annee_venir(volume_annee_venir);
		info.setSurface_parcelle(surface_parcelle);
		info.setRendement(rendement);
		info.setNbr_pieds(nbr_pieds);
		info.setEtape_visite(etape_visite);
		info.setSysteme_protection_sol(systeme_protection_sol);
		info.setSysteme_utilise(systeme_utilise);
		info.setAssocie_parcel(associe_parcel);
		info.setAutre_associe_parcel(autre_associe_parcel);
		info.setInclinaison(inclinaison);
		info.setMise_anti_errosif(mise_anti_errosif);
		info.setTechnic_use(technic_use);
		info.setPhoto_technique(photo_technique);
		info.setPhoto_culture(photo_culture);
		info_parcelle_diversRepository.save(info);
		
		
	}

}
