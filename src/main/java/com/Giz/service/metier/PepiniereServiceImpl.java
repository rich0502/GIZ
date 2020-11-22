package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Adoption_innovation;
import com.Giz.data.domain.Parcelle_test;
import com.Giz.data.domain.Pepiniere;
import com.Giz.repository.Adopte_InnovationRepository;
import com.Giz.repository.Parcelle_testRepository;
import com.Giz.repository.PepiniereRepository;

@Service
public class PepiniereServiceImpl implements PepiniereService {

	@Autowired
	PepiniereRepository pepiniereRepository;
	
	@Override
	public List<Pepiniere> ListPepiniere() {
		// TODO Auto-generated method stub
		return pepiniereRepository.findAll();
	}

	@Override
	public void deletePepiniere(Long id_pep) {
		pepiniereRepository.deleteById(id_pep);
		
	}

	@Override
	public void addPepiniere(String code_village, float x, float y, String nomResp, String genre_pep,
			int annee_naiss, int annee_mise_place, boolean operationnel, Date date_suivi) {
		Pepiniere pepiniere =  new Pepiniere();
		pepiniere.setCode_village(code_village);
		pepiniere.setX(x);
		pepiniere.setY(y);
		pepiniere.setNomResp(nomResp);
		pepiniere.setGenre_pep(genre_pep);
		pepiniere.setAnnee_naiss(annee_naiss);
		pepiniere.setAnnee_mise_place(annee_mise_place);
		pepiniere.setOperationnel(operationnel);
		pepiniere.setDate_suivi(date_suivi);
		pepiniereRepository.save(pepiniere);
		
	}

	@Override
	public void modifyPepiniere(Pepiniere pepiniere, String code_village, float x, float y, String nomResp,
			String genre_pep, int annee_naiss, int annee_mise_place, boolean operationnel, Date date_suivi,
			Long id_pep) {
		pepiniere.setCode_village(code_village);
		pepiniere.setX(x);
		pepiniere.setY(y);
		pepiniere.setNomResp(nomResp);
		pepiniere.setGenre_pep(genre_pep);
		pepiniere.setAnnee_naiss(annee_naiss);
		pepiniere.setAnnee_mise_place(annee_mise_place);
		pepiniere.setOperationnel(operationnel);
		pepiniere.setDate_suivi(date_suivi);
		pepiniereRepository.save(pepiniere);	
	}

	
	
}
