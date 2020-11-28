package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Adoption_innovation;
import com.Giz.data.domain.Parcelle_test;


public interface ParcelleTestService {


	public List<Parcelle_test> ListParcelle_test();
	
	public List<Parcelle_test> ListParcellTestVanille(String type);
	
	public float countParcellTestVanille();

	public void deleteParcelle_test(Long id_pt);
	
	public void addParcelle_test(String code_village, float x, float y, String nomResponsable, String genre_pt,
			int annee_naiss, String pratique_realise, Date date_mise, float superficies, boolean operationnel,
			Date date_suivi, String technique_exergue, long nbr_participant, String type);
	
	
	public void modifyParcelle_test(Parcelle_test parcelle_test,String code_village, float x, float y, String nomResponsable, String genre_pt,
			int annee_naiss, String pratique_realise, Date date_mise, float superficies, boolean operationnel,
			Date date_suivi, String technique_exergue, long nbr_participant, String type, Long id_pt);
	
	public void addParcelle_AGC(String code_village, float x, float y, String nomResponsable, String genre_pt,
			int annee_naiss, float superficies, boolean operationnel,
			Date date_suivi, String technique_exergue);
	
	public void addParcelleParticipant(String code_village, float x, float y, String nomResponsable, String genre_pt,
			int annee_naiss,Long nbr_participant,
			long nbr_homme,long nbr_femme
			,Date date_suivi);
	
	
}
