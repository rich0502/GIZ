package com.Giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.Giz.data.domain.Beneficiaire;


public interface BeneficiaireService {


	public List<Beneficiaire> ListBeneficiaire();
	
	public List<Beneficiaire> ListSuccessStories();

	public void deleteBeneficiaire(Long id_bf);
	
	public void addBeneficiaire(String nom_bf,
			String prenom_bf, String adresse_bf, Boolean success, String contact_bf, String date_naiss_bf);
	
	
	public void modifyBeneficiaire(Beneficiaire beneficiaire, String nom_bf,
			String prenom_bf, String adresse_bf,Boolean success, String contact_bf, String date_naiss_bf, Long id_bf);
	
}
