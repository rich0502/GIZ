package com.Giz.service.metier;

import java.sql.Date;
import java.util.List;

import com.Giz.data.domain.Adoption_innovation;


public interface AdopteInnovationService {


	public List<Adoption_innovation> ListAdoption_innovation();

	public void deleteAdoption_innovation(Long id_ai);
	
	public void addAdoption_innovation(String code_pro, String nomPrenom_ai, String genre_ai, Date annee_naiss,
			Date date_suivi, String type);
	
	
	public void modifyAdoption_innovation(Adoption_innovation adoption_innovation,String code_pro, String nomPrenom_ai, String genre_ai, Date annee_naiss,
			Date date_suivi, String type, Long id_ai);
	
}
