package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Activite;
import com.Giz.repository.ActiviteRepository;

@Service
public class ActiviteServiceImpl implements ActiviteService {
	
	@Autowired
	ActiviteRepository activiteRepository;
	
	@Override
	public List<Activite> ListActivite() {
		// TODO Auto-generated method stub
		return activiteRepository.findAll();
	}

	@Override
	public void addActivite(long id, String type_intervention, String theme_principal, String sous_theme, String date_enreg,
			String nom_utilisateur, String gps_lat, String gps_long, String formateur, String code_formateur,
			String lieu_formation, String prod_present, String prod_externe, String participant_externe, String image1,
			String image2, String image3, String remarques) {
		Activite activite = new Activite();
		activite.setId_activite(id);
		activite.setType_intervention(type_intervention);
		activite.setTheme_principal(theme_principal);
		activite.setSous_theme(sous_theme);
		activite.setDate_enreg(date_enreg);
		activite.setNom_utilisateur(nom_utilisateur);
		activite.setGps_lat(gps_lat);
		activite.setGps_long(gps_long);
		activite.setFormateur(formateur);
		activite.setCode_formateur(code_formateur);
		activite.setLieu_formation(lieu_formation);
		activite.setProd_present(prod_present);
		activite.setProd_externe(prod_externe);
		activite.setParticipant_externe(participant_externe);
		activite.setImage1(image1);
		activite.setImage2(image2);
		activite.setImage3(image3);
		activite.setRemarques(remarques);
		activiteRepository.save(activite);
		
	}
}
