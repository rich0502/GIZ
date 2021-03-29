package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Pepiniere;


public interface PepiniereService {


	public List<Pepiniere> ListPepiniere();
	
	public long countPepiniere();
	
	public long countGenre(String genre);

	public void deletePepiniere(Long id_pep);
	
	public void addPepiniere(String code_village, float x, float y, String nomResp, String genre_pep,
			int annee_naiss, int annee_mise_place, boolean operationnel, Date date_suivi);
	
	
	public void modifyPepiniere(Pepiniere pepiniere,String code_village, float x, float y, String nomResp, String genre_pep,
			int annee_naiss, int annee_mise_place, boolean operationnel, Date date_suivi, Long id_pep);

	public void deleteAllPepiniere();
	
}
