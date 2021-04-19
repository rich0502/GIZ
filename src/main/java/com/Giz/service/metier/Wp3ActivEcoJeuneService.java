package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Wp3ActivEcoJeune;

public interface Wp3ActivEcoJeuneService {
	
	public void deleteAll37();
	
	public Wp3ActivEcoJeune createWp3ActivEcoJeune(Wp3ActivEcoJeune wp3ActivEcoJeune) throws Exception;

	public List<Wp3ActivEcoJeune> ListWp3ActivEcoJeune();

	public void addWp3ActivEcoJeune(String code_village, String nom_prenom, String sexe, int annee_naissance,
			String organisme_formateur, String frm_tech_suivi, Date date_fin_frm, String activite_eco,
			Date date_demarrage,String activite);
	
	public long countActivEcoJeune(String dateChronologique);
	
	public long countActivEcoJeuneGenre(String dateChronologique, String genre);
	
	public Optional<Wp3ActivEcoJeune> findByIdActivEcoJeune(long id);
	
	public void modifyActivEcoJeune(String code_village, String nom_prenom, String sexe, int annee_naissance,
			String organisme_formateur, String frm_tech_suivi, Date date_fin_frm, String activite_eco,
			Date date_demarrage, Long id);
	
	public void deleteWP3ActivEcoJeune(Long id);
	
	//graphe
	
	public long TotTotal(Date debut_date, Date fin_date);
	
	public List<Object[]> ListFetch();
	
	public long CamembertTot();
	
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date);	
	
	//tableau
	
	public List<Object[]> ListTableau(Date debut_date, Date fin_date,List<String> params,String sexe);
	public List<Object[]> ListTableauAll(Date debut_date, Date fin_date,List<String> params);
	
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe);
	public List<Object[]> ListTableauCommuneAll(Date debut_date, Date fin_date);
	
	
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe);
	public List<Object[]> ListTableauDistAll(Date debut_date, Date fin_date);
	
	// VILLAGE DETAIL TABLEAU COUNT
	public List<Object[]> TableauCountDetailGenre(String village, String sexe);
	public List<Object[]> TableauCountDetailGenreAll(String village);
	
		//COMMUNE DETAIL TABLEAU COUNT
	public List<Object[]> TableauCountDetailGenreComm(String commune, String sexe);
	public List<Object[]> TableauCountDetailGenreAllComm(String commune);
	
	 	// DISTRICT DETAIL TABLEAU COUNT
	public List<Object[]> TableauCountDetailGenreDist(String district, String sexe);
	public List<Object[]> TableauCountDetailGenreAllDist(String district);

	public List<Object[]> historiqueList();

	
}
