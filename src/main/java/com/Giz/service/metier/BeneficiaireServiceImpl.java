package com.Giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Beneficiaire;
import com.Giz.repository.BeneficiaireRepository;



@Service
public class BeneficiaireServiceImpl implements BeneficiaireService {
	@Autowired
	private BeneficiaireRepository beneficiaireRepository;

	@Override
	public List<Beneficiaire> ListBeneficiaire() {
		// TODO Auto-generated method stub
		return beneficiaireRepository.fetchBeneficiaireData();
	}

	@Override
	public void deleteBeneficiaire(Long id_bf) {
		beneficiaireRepository.deleteBeneficiaire(id_bf);		
	}


	@Override
	public void addBeneficiaire(String nom_bf, String prenom_bf, String adresse_bf,
			String contact_bf, String date_naiss_bf) {
		Beneficiaire beneficiaire = new Beneficiaire();
		beneficiaire.setNom_bf(nom_bf);
		beneficiaire.setPrenom_bf(prenom_bf);
		beneficiaire.setAdresse_bf(adresse_bf);
		beneficiaire.setContact_bf(contact_bf);
		beneficiaire.setDate_naiss_bf(date_naiss_bf);
		beneficiaireRepository.save(beneficiaire);
		
	}

	@Override
	public void modifyBeneficiaire(Beneficiaire beneficiaire, String nom_bf, String prenom_bf, String adresse_bf,
			String contact_bf, String date_naiss_bf, Long id_bf) {	
		beneficiaire.setNom_bf(nom_bf);
		beneficiaire.setPrenom_bf(prenom_bf);
		beneficiaire.setAdresse_bf(adresse_bf);
		beneficiaire.setContact_bf(contact_bf);
		beneficiaire.setDate_naiss_bf(date_naiss_bf);
		beneficiaireRepository.save(beneficiaire);
		
	}


	

}
