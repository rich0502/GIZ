package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Formateur;
import com.Giz.repository.FormateursRepository;

@Service
public class FormateurServiceImpl implements FormateurService {
	
	@Autowired
	FormateursRepository formateurRepository;

	@Override
	public List<Formateur> ListFormateur() {
		// TODO Auto-generated method stub
		return formateurRepository.findAll();
	}

	@Override
	public void deleteFormateur(Long id_ft) {
		formateurRepository.deleteById(id_ft);
		
	}
	
	@Override
	public Formateur createFormElev(Formateur Formateur) throws Exception {
		return Formateur = formateurRepository.save(Formateur);
	}

	@Override
	public void addFormateur(String code_village, String nomPrenom, String zoneInterv, String genre_ft,
			int date_naiss, boolean operationnel, Date date_mise_place, Date date_suivi, Date date_debut,
			Date date_fin, String type_form) {
		Formateur formateur = new Formateur();
		formateur.setCode_village(code_village);
		formateur.setNomPrenom(nomPrenom);
		formateur.setZoneInterv(zoneInterv);
		formateur.setGenre_ft(genre_ft.toLowerCase());
		formateur.setDate_naiss(date_naiss);
		formateur.setOperationnel(operationnel);
		formateur.setDate_mise_place(date_mise_place);
		formateur.setDate_suivi(date_suivi);
		formateur.setDate_debut(date_debut);
		formateur.setDate_fin(date_fin);
		formateur.setType_form(type_form);
		formateurRepository.save(formateur);
		
	}

	@Override
	public void modifyFormateur(Formateur formateur, String code_village, String nomPrenom, String zoneInterv,
			String genre_ft, int date_naiss, boolean operationnel, Date date_mise_place, Date date_suivi,
			Date date_debut, Date date_fin, String type_form, Long id_ft) {
		formateur.setCode_village(code_village);
		formateur.setNomPrenom(nomPrenom);
		formateur.setZoneInterv(zoneInterv);
		formateur.setGenre_ft(genre_ft.toLowerCase());
		formateur.setDate_naiss(date_naiss);
		formateur.setOperationnel(operationnel);
		formateur.setDate_mise_place(date_mise_place);
		formateur.setDate_suivi(date_suivi);
		formateur.setDate_debut(date_debut);
		formateur.setDate_fin(date_fin);
		formateur.setType_form(type_form);
		formateurRepository.save(formateur);
		
	}

	@Override
	public void addFormateurElevage(String code_village, String nomPrenom, String genre_ft, int date_naiss,
			boolean operationnel, Date date_mise_place, Date date_suivi, String type_form) {
		Formateur formateur = new Formateur();
		formateur.setCode_village(code_village);
		formateur.setNomPrenom(nomPrenom);
		formateur.setGenre_ft(genre_ft.toLowerCase());
		formateur.setDate_naiss(date_naiss);
		formateur.setOperationnel(operationnel);
		formateur.setDate_mise_place(date_mise_place);
		formateur.setDate_suivi(date_suivi);
		formateur.setType_form(type_form);
		formateurRepository.save(formateur);
		
	}

	@Override
	public List<Formateur> ListElevage(String type_form) {
		return formateurRepository.findElevage(type_form);
	}

	
	

}
