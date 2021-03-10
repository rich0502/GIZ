package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Sante_animal;


public interface Sante_animalService {


	public List<Sante_animal> ListSante_animal();

	public void deleteSante_animal(Long id_sa);
	
	public void addSante_animal( String code_village, String nomPrenom, String genre_sa, int annee_naiss,
			boolean operationnel, java.util.Date date_mise_places, java.util.Date date_suivis);
	
	
	public void modifySante_animal(Sante_animal sante_animal,String code_village, String nomPrenom, String genre_sa, int annee_naiss,
			boolean operationnel, java.util.Date date_mise_place, java.util.Date date_suivi, Long id);
}
