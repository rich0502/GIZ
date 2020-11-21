package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Recherche;
import com.Giz.repository.Adopte_InnovationRepository;
import com.Giz.repository.RechercheRepository;

@Service
public class RechercheServiceImpl implements RechercheService {
	
	@Autowired
	RechercheRepository rechercheRepository;

	@Override
	public List<Recherche> ListRecherche() {
		return rechercheRepository.findAll();
	}

	@Override
	public void deleteRecherche(Long id_re) {
		rechercheRepository.deleteById(id_re);
		
	}

	@Override
	public void addRecherche(String code_village, Date date_restitution, String theme, double nbr_homme, double nbr_femme, boolean pr, boolean producteurs,
			boolean ep, boolean std_ctd, boolean autres) {
		Recherche re = new Recherche();
		re.setCode_village(code_village);
		re.setNbr_homme(nbr_homme);
		re.setNbr_femme(nbr_femme);
		re.setPr(pr);
		re.setProducteurs(producteurs);
		re.setEp(ep);
		re.setStd_ctd(std_ctd);
		re.setAutres(autres);
		re.setDate_restitution(date_restitution);
		re.setTheme(theme);
		rechercheRepository.save(re);
		
		
	}

	@Override
	public void modifyRecherche(Recherche recherche, String code_village, Date date_restitution, String theme, double nbr_homme, double nbr_femme, boolean pr,
			boolean producteurs, boolean ep, boolean std_ctd, boolean autres, Long id_re) {
		recherche.setCode_village(code_village);
		recherche.setNbr_homme(nbr_homme);
		recherche.setNbr_femme(nbr_femme);
		recherche.setPr(pr);
		recherche.setProducteurs(producteurs);
		recherche.setEp(ep);
		recherche.setStd_ctd(std_ctd);
		recherche.setAutres(autres);
		recherche.setDate_restitution(date_restitution);
		recherche.setTheme(theme);
		rechercheRepository.save(recherche);
		
	}
	
	
}
