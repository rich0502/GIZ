package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Adoption_innovation;


public interface AdopteInnovationService {


	public List<Adoption_innovation> ListAdoption_innovation();
	
	public long CountAdoption();
	
	public long CountGenre(String genre);

	public void deleteAdoption_innovation(Long id_ai);
	
	public void addAdoption_innovation(String code_pro, String nomPrenom_ai, String genre_ai, String annee_naiss,
			Date date_suivi, String type);
	
	
	public void modifyAdoption_innovation(Adoption_innovation adoption_innovation,String code_pro, String nomPrenom_ai, String genre_ai, String annee_naiss,
			Date date_suivi, String type, Long id_ai);
	
}
