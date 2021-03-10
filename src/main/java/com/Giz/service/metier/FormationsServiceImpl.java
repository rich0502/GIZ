package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Formations;
import com.Giz.repository.FormationsRepository;

@Service
public class FormationsServiceImpl implements FormationsService {

	@Autowired
	FormationsRepository formationsRepository;
	
	@Override
	public List<Formations> ListFormations() {

		return formationsRepository.findAll();
	}

	@Override
	public void deleteFormateur(Long id_ft) {
		formationsRepository.deleteById(id_ft);
		
	}
	
	@Override
	public Formations createFormEFA(Formations Formations) throws Exception {
		return Formations = formationsRepository.save(Formations);
	}
	
	@Override
	public Formations createFormFBS(Formations Formations) throws Exception {
		return Formations = formationsRepository.save(Formations);
	}

	@Override
	public void addFormations(String code_village, String nom_eleveur, String genre_form, int annee_naiss,
			String formation_recu, String theme_formation, Date date_forma,
			String type_formation) {
			Formations formations = new Formations();
			formations.setCode_village(code_village);
			formations.setNom_eleveur(nom_eleveur);
			formations.setGenre_form(genre_form.toLowerCase());
			formations.setAnnee_naiss(annee_naiss);
			formations.setFormation_recu(formation_recu);
			formations.setTheme_formation(theme_formation);
			formations.setDate_forma(date_forma);
			formations.setType_formation(type_formation);
			
			formationsRepository.save(formations);
		
	}

	@Override
	public void modifyFormations(Formations formations, String code_village, String nom_eleveur, String genre_form,
			int annee_naiss, String formation_recu, String theme_formation, Date date_forma, String type_formation, Long id_forms) {
		formations.setCode_village(code_village);
		formations.setNom_eleveur(nom_eleveur);
		formations.setGenre_form(genre_form.toLowerCase());
		formations.setAnnee_naiss(annee_naiss);
		formations.setFormation_recu(formation_recu);
		formations.setTheme_formation(theme_formation);
		formations.setDate_forma(date_forma);
		formations.setType_formation(type_formation);
		
		formationsRepository.save(formations);
		
	}

	@Override
	public List<Formations> ListFormations(String type_form) {
		// TODO Auto-generated method stub
		return formationsRepository.findFormations(type_form);
	}

	@Override
	public void addFormEFA(String code_village, String nom_eleveur, String genre_form, int annee_naiss,
			String formation_recu, String theme_formation, Date date_forma, boolean adoption, String pratique_adopte, String type_formation) {
		Formations formations = new Formations();
		formations.setCode_village(code_village);
		formations.setNom_eleveur(nom_eleveur);
		formations.setGenre_form(genre_form.toLowerCase());
		formations.setAnnee_naiss(annee_naiss);
		formations.setFormation_recu(formation_recu);
		formations.setTheme_formation(theme_formation);
		formations.setDate_forma(date_forma);
		formations.setAdoption(adoption);
		formations.setPratique_adopte(pratique_adopte);
		formationsRepository.save(formations);
		
	}

	@Override
	public void modifyFormEFA(Formations formations, String code_village, String nom_eleveur, String genre_form,
			int annee_naiss, String formation_recu, String theme_formation, Date date_forma, boolean adoption,
			String pratique_adopte, String type_formation, Long id_forms) {
		formations.setCode_village(code_village);
		formations.setNom_eleveur(nom_eleveur);
		formations.setGenre_form(genre_form.toLowerCase());
		formations.setAnnee_naiss(annee_naiss);
		formations.setFormation_recu(formation_recu);
		formations.setTheme_formation(theme_formation);
		formations.setDate_forma(date_forma);
		formations.setAdoption(adoption);
		formations.setPratique_adopte(pratique_adopte);
		formationsRepository.save(formations);
		
	}

	

}
