package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Plateforme;


public interface PlateformeService {


	public List<Plateforme> ListPlateforme();
	
	public List<Plateforme> fetchPlateforme(String type_plateform);

	public void deletePlateforme(Long id_am);
	
	public void addPlateforme(String code_village, boolean exist_platform, boolean operationnel, Date date_suivi,
			String commentaire, String type_plateform);
	
	
	public void modifyPlateforme(Plateforme plateforme,String code_village, boolean exist_platform, boolean operationnel, Date date_suivi,
			String commentaire, String type_plateform, Long id_am);
	
}
