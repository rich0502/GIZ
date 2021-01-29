package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Wp3UniteElevJeune;

public interface Wp3UniteElevJeuneService {

	public List<Wp3UniteElevJeune> ListWp3UniteElevJeune();

	public void addWp3UniteElevJeune(String code_village, String nom_prenom, String sexe, int annee_naissance,
			Boolean demarrage_unite, Date date_dem, String type_activite, String theme1_traite, Date date_suivi1, String activite);
	
	public long countChronologique(String dateChronologique);
	
	public long countChronologiqueGenre(String dateChronologique,String genre);
	
	public Optional<Wp3UniteElevJeune> findByIdUniteElevJeune(long id);
	
	public void modifyWp3UniteElevJeune(String code_village, String nom_prenom, String sexe, int annee_naissance,
			Boolean demarrage_unite, Date date_dem, String type_activite, String theme1_traite, Date date_suivi1,long id);
	
	public void deleteWp3UniteElevJeune(Long id);
	
	//graphe

	public long TotTotal(Date debut_date, Date fin_date);

	public List<Object[]> ListFetch();

	public long CamembertTot();

	public List<Object[]> ListGraphe(Date debut_date, Date fin_date);
	
	public List<Object[]> ListTableau(Date debut_date, Date fin_date,List<String> params,String sexe);
	
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe);
	
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe);
}
