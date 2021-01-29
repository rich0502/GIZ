package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.Giz.data.domain.Wp3UniteElevJeune;
import com.Giz.repository.Wp3UniteElevJeuneRepository;

@Service
public class Wp3UniteElevJeuneServiceImpl implements Wp3UniteElevJeuneService {

	@Autowired
	Wp3UniteElevJeuneRepository wp3UniteElevJeuneRepository;

	@Override
	public List<Wp3UniteElevJeune> ListWp3UniteElevJeune() {
		// TODO Auto-generated method stub
		return wp3UniteElevJeuneRepository.findAll();
	}

	@Override
	public void addWp3UniteElevJeune(String code_village, String nom_prenom, String sexe, int annee_naissance,
			Boolean demarrage_unite, Date date_dem, String type_activite, String theme1_traite, Date date_suivi1, String activite) {

		Wp3UniteElevJeune wp3UniteElevJeune = new Wp3UniteElevJeune();

		wp3UniteElevJeune.setCode_village(code_village);
		wp3UniteElevJeune.setNom_prenom(nom_prenom);
		wp3UniteElevJeune.setSexe(sexe);
		wp3UniteElevJeune.setAnnee_naissance(annee_naissance);
		wp3UniteElevJeune.setDemarrage_unite(demarrage_unite);
		wp3UniteElevJeune.setDate_dem(date_dem);
		wp3UniteElevJeune.setType_activite(type_activite);
		wp3UniteElevJeune.setTheme1_traite(theme1_traite);
		wp3UniteElevJeune.setDate_suivi1(date_suivi1);
		wp3UniteElevJeune.setActivite(activite);
		/*
		 * wp3UniteElevJeune.setTheme2_traite(theme2_traite);
		 * wp3UniteElevJeune.setDate_suivi2(date_suivi2);
		 * wp3UniteElevJeune.setTheme3_traite(theme3_traite);
		 * wp3UniteElevJeune.setDate_suivi3(date_suivi3);
		 */

		wp3UniteElevJeuneRepository.save(wp3UniteElevJeune);

	}

	@Override
	public long countChronologique(String dateChronologique) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3UniteElevJeuneRepository.count();
		} else {
			return wp3UniteElevJeuneRepository.countChronologique(dateChronologique);
		}
	}

	@Override
	public long countChronologiqueGenre(String dateChronologique, String genre) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3UniteElevJeuneRepository.countGenre(genre);
		} else {
			return wp3UniteElevJeuneRepository.countChronologiqueGenre(dateChronologique, genre);
		}
	}

	@Override
	public Optional<Wp3UniteElevJeune> findByIdUniteElevJeune(long id) {
		// TODO Auto-generated method stub
		return wp3UniteElevJeuneRepository.findById(id);
	}

	@Override
	public void modifyWp3UniteElevJeune(String code_village, String nom_prenom, String sexe, int annee_naissance,
			Boolean demarrage_unite, Date date_dem, String type_activite, String theme1_traite, Date date_suivi1,
			long id) {
		Wp3UniteElevJeune wp3UniteElevJeune = new Wp3UniteElevJeune();

		wp3UniteElevJeune.setCode_village(code_village);
		wp3UniteElevJeune.setNom_prenom(nom_prenom);
		wp3UniteElevJeune.setSexe(sexe);
		wp3UniteElevJeune.setAnnee_naissance(annee_naissance);
		wp3UniteElevJeune.setDemarrage_unite(demarrage_unite);
		wp3UniteElevJeune.setDate_dem(date_dem);
		wp3UniteElevJeune.setType_activite(type_activite);
		wp3UniteElevJeune.setTheme1_traite(theme1_traite);
		wp3UniteElevJeune.setDate_suivi1(date_suivi1);
		wp3UniteElevJeune.setId(id);
		wp3UniteElevJeuneRepository.save(wp3UniteElevJeune);
		
	}
	
	@Override
	public void deleteWp3UniteElevJeune(Long id) {
		wp3UniteElevJeuneRepository.deleteWp3UniteElevJeune(id);		
	}
	
	//graphe

	@Override
	public long TotTotal(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3UniteElevJeuneRepository.SomTotal(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListFetch() {
		// TODO Auto-generated method stub
		return wp3UniteElevJeuneRepository.fetchData();
	}

	@Override
	public long CamembertTot() {
		// TODO Auto-generated method stub
		return wp3UniteElevJeuneRepository.CamembertTot();
	}

	@Override
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3UniteElevJeuneRepository.TpsData(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableau(Date debut_date, Date fin_date, List<String> params, String sexe) {
		// TODO Auto-generated method stub
		return wp3UniteElevJeuneRepository.TableData(debut_date, fin_date, params, sexe);
	}

	@Override
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3UniteElevJeuneRepository.TableDataCommune(debut_date, fin_date, sexe);
	}

	@Override
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3UniteElevJeuneRepository.TableDataDist(debut_date, fin_date, sexe);
	}
}
