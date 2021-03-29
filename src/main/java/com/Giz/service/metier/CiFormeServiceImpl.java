package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.CiForme;
import com.Giz.repository.CiFormeRepository;

@Service
public class CiFormeServiceImpl implements CiFormeService {
	
	@Autowired
	private CiFormeRepository ciFormeRepository;

	@Override
	public List<CiForme> ListCiForme() {
		// TODO Auto-generated method stub
		return ciFormeRepository.findAll();
	}

	@Override
	public void deleteCiForme(Long id_ci) {
		ciFormeRepository.deleteById(id_ci);
		
	}

	@Override
	public void addCiForme(String code_village, String nomPrenom_ci, String genre_ci, int annee_naiss,
			Date date_form, boolean equipe, String type_materiel, Date date_dotation) {
		CiForme ciForme = new CiForme();
		ciForme.setCode_village(code_village);
		ciForme.setNomPrenom_ci(nomPrenom_ci);
		ciForme.setGenre_ci(genre_ci.toLowerCase());
		ciForme.setAnnee_naiss(annee_naiss);
		ciForme.setDate_form(date_form);
		ciForme.setEquipe(equipe);
		ciForme.setType_materiel(type_materiel);
		ciForme.setDate_dotation(date_dotation);
		ciFormeRepository.save(ciForme);
		
	}

	@Override
	public void modifyCiForme(CiForme ciForme, String code_village, String nomPrenom_ci, String genre_ci,
			int annee_naiss, Date date_form, boolean equipe, String type_materiel, Date date_dotation, Long id_ci) {
		ciForme.setCode_village(code_village);
		ciForme.setNomPrenom_ci(nomPrenom_ci);
		ciForme.setGenre_ci(genre_ci.toLowerCase());
		ciForme.setAnnee_naiss(annee_naiss);
		ciForme.setDate_form(date_form);
		ciForme.setEquipe(equipe);
		ciForme.setType_materiel(type_materiel);
		ciForme.setDate_dotation(date_dotation);
		ciFormeRepository.save(ciForme);
		
	}

	@Override
	public void deleteAllCI() {
		// TODO Auto-generated method stub
		ciFormeRepository.deleteAll();
	}
	
	

	

}
