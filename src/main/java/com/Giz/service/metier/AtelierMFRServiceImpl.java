package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Adoption_innovation;
import com.Giz.data.domain.AtelierMFR;
import com.Giz.repository.Adopte_InnovationRepository;
import com.Giz.repository.AtelierMFRRepository;

@Service
public class AtelierMFRServiceImpl implements AtelierMFRService {
	
	@Autowired
	private AtelierMFRRepository atelierMFRRepository;

	@Override
	public List<AtelierMFR> ListAtelierMFR() {
		// TODO Auto-generated method stub
		return atelierMFRRepository.findAll();
	}

	@Override
	public void deleteAtelierMFR(Long id_am) {
		atelierMFRRepository.deleteById(id_am);
		
	}

	@Override
	public void addAtelierMFR(String code_village, String atelier_resp, Date date_realise, String lieu_realise, String theme_choise,
			long nbr_particip, int nbr_homme, int nbr_femme, String cible_atelier, String type_atelier) {
		AtelierMFR atelierMFR = new AtelierMFR();
		atelierMFR.setCible_atelier(cible_atelier);
		atelierMFR.setCode_village(code_village);
		atelierMFR.setDate_realise(date_realise);
		atelierMFR.setLieu_realise(lieu_realise);
		atelierMFR.setNbr_femme(nbr_femme);
		atelierMFR.setNbr_homme(nbr_homme);
		atelierMFR.setNbr_particip(nbr_particip);
		atelierMFR.setTheme_choise(theme_choise);
		atelierMFR.setAtelier_resp(atelier_resp);
		atelierMFR.setType_atelier(type_atelier);
		atelierMFRRepository.save(atelierMFR);
		
		
	}

	@Override
	public void modifyAtelierMFR(AtelierMFR atelierMFR, String code_village,String atelier_resp, Date date_realise, String lieu_realise,
			String theme_choise, long nbr_particip, int nbr_homme, int nbr_femme, String cible_atelier,String type_atelier, Long id_am) {
		atelierMFR.setCible_atelier(cible_atelier);
		atelierMFR.setCode_village(code_village);
		atelierMFR.setDate_realise(date_realise);
		atelierMFR.setLieu_realise(lieu_realise);
		atelierMFR.setNbr_femme(nbr_femme);
		atelierMFR.setNbr_homme(nbr_homme);
		atelierMFR.setNbr_particip(nbr_particip);
		atelierMFR.setTheme_choise(theme_choise);
		atelierMFR.setAtelier_resp(atelier_resp);
		atelierMFR.setType_atelier(type_atelier);
		atelierMFRRepository.save(atelierMFR);
		
	}

	@Override
	public List<AtelierMFR> fetchAtelier(String type_atelier) {
		return atelierMFRRepository.fetchAtelier(type_atelier);
	}
}