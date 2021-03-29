package com.Giz.service.metier;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Elevage;
import com.Giz.repository.ElevageRepository;

@Service
public class ElevageServiceImpl implements ElevageService {
	
	@Autowired
	ElevageRepository elevageRepository;

	@Override
	public List<Elevage> ListElevage() {
		// TODO Auto-generated method stub
		return elevageRepository.findAll();
	}

	@Override
	public void deleteElevage(Long id_elev) {
		elevageRepository.deleteById(id_elev);
		
	}

	@Override
	public void addElevage(String code_village, float x, float y, String nomResponsable, String genre_elev,
			int annee_naiss, String pratique_realise, int date_mise, String tf, double nbr_visiteur,
			java.util.Date date_suivi, boolean operationnel) {
		Elevage elevage = new Elevage();
		elevage.setCode_village(code_village);
		elevage.setX(x);
		elevage.setY(y);
		elevage.setNomResponsable(nomResponsable);
		elevage.setGenre_elev(genre_elev.toLowerCase());
		elevage.setAnnee_naiss(annee_naiss);
		elevage.setPratique_realise(pratique_realise);
		elevage.setDate_mise(date_mise);
		elevage.setNbr_visiteur(nbr_visiteur);
		elevage.setTf(tf);
		elevage.setDate_suivi(date_suivi);
		elevage.setOperationnel(operationnel);
		elevageRepository.save(elevage);
		
		
	}

	@Override
	public void modifyElevage(Elevage elevage, String code_village, float x, float y, String nomResponsable,
			String genre_elev, int annee_naiss, String pratique_realise, int date_mise, String tf,
			double nbr_visiteur, java.util.Date date_suivi, boolean operationnel, Long id_elev) {
		// TODO Auto-generated method stub
		elevage.setCode_village(code_village);
		elevage.setX(x);
		elevage.setY(y);
		elevage.setNomResponsable(nomResponsable);
		elevage.setGenre_elev(genre_elev.toLowerCase());
		elevage.setAnnee_naiss(annee_naiss);
		elevage.setPratique_realise(pratique_realise);
		elevage.setDate_mise(date_mise);
		elevage.setNbr_visiteur(nbr_visiteur);
		elevage.setDate_suivi(date_suivi);	
		elevage.setOperationnel(operationnel);
		elevageRepository.save(elevage);
		
	}

	@Override
	public void addFerme(String code_villag, float cord_x, float cord_y, String nomResponsabl, String genre,
			int annee_nais, java.util.Date date_suiv, boolean operationnels) {
		Elevage elevage = new Elevage();
		elevage.setCode_village(code_villag);
		elevage.setX(cord_x);
		elevage.setY(cord_y);
		elevage.setNomResponsable(nomResponsabl);
		elevage.setGenre_elev(genre.toLowerCase());
		elevage.setAnnee_naiss(annee_nais);
		elevage.setDate_suivi(date_suiv);
		elevage.setOperationnel(operationnels);
		elevageRepository.save(elevage);
		
	}

	@Override
	public void deleteElevageAll() {
		// TODO Auto-generated method stub
		elevageRepository.deleteAll();
		
	}

	
	
}
