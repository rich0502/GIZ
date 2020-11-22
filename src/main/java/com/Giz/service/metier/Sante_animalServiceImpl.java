package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Sante_animal;
import com.Giz.repository.Sante_animalRepository;

@Service
public class Sante_animalServiceImpl implements Sante_animalService {
	
	@Autowired
	Sante_animalRepository sante_animalRepository;

	@Override
	public List<Sante_animal> ListSante_animal() {
		// TODO Auto-generated method stub
		return sante_animalRepository.findAll();
	}

	@Override
	public void deleteSante_animal(Long id_sa) {
		sante_animalRepository.deleteById(id_sa);
		
	}

	@Override
	public void addSante_animal(String code_village, String nomPrenom, String genre_sa, int annee_naiss,
			boolean operationnel, java.util.Date date_mise_place, java.util.Date date_suivi) {
		Sante_animal sante_animal = new Sante_animal();
		sante_animal.setCode_village(code_village);
		sante_animal.setNomPrenom(nomPrenom);
		sante_animal.setGenre_sa(genre_sa);
		sante_animal.setAnnee_naiss(annee_naiss);
		sante_animal.setOperationnel(operationnel);
		sante_animal.setDate_mise_place(date_mise_place);
		sante_animal.setDate_suivi(date_suivi);
		
		sante_animalRepository.save(sante_animal);
		
	}

	@Override
	public void modifySante_animal(Sante_animal sante_animal, String code_village, String nomPrenom, String genre_sa,
			int annee_naiss, boolean operationnel, java.util.Date date_mise_place, java.util.Date date_suivi, Long id) {
		sante_animal.setCode_village(code_village);
		sante_animal.setNomPrenom(nomPrenom);
		sante_animal.setGenre_sa(genre_sa);
		sante_animal.setAnnee_naiss(annee_naiss);
		sante_animal.setOperationnel(operationnel);
		sante_animal.setDate_mise_place(date_mise_place);
		sante_animal.setDate_suivi(date_suivi);
		
		sante_animalRepository.save(sante_animal);
		
	}
	
	
	
}
