package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Wp3JeunePathway;

public interface Wp3JeunePathwayService {
	
	public void deleteAll46();

	public Wp3JeunePathway createWp3JeunePathway(Wp3JeunePathway wp3JeunePathway) throws Exception;

	public List<Wp3JeunePathway> ListWp3JeunePathway();

	public void addWp3JeunePathway(String code_village, String nom_prenom, String sexe, int annee_naissance,
			Date date_fin_frm, String activite);

	public long countChronologique(String dateChronologique);

	public long countChronologiqueGenre(String dateChronologique, String genre);

	public Optional<Wp3JeunePathway> findByIdJeunePathway(long id);

	public void modifyWp3JeunePathway(String code_village, String nom_prenom, String sexe, int annee_naissance,
			boolean existance_agr, Date date_fin_frm, long id);

	public void deleteWp3JeunePathway(Long id);

	// graphe

	public long TotTotal(Date debut_date, Date fin_date);

	public List<Object[]> ListFetch();

	public long CamembertTot();

	public List<Object[]> ListGraphe(Date debut_date, Date fin_date);

	public List<Object[]> ListTableau(Date debut_date, Date fin_date, List<String> params, String sexe);

	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe);

	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe);

	public List<Object[]> ListTableauAll(Date debut_date, Date fin_date, List<String> params);

	public List<Object[]> ListTableauCommuneAll(Date debut_date, Date fin_date);

	public List<Object[]> ListTableauDistAll(Date debut_date, Date fin_date);

	// VILLAGE DETAIL TABLEAU COUNT
	public List<Object[]> TableauCountDetailGenre(String village, String sexe);

	public List<Object[]> TableauCountDetailGenreAll(String village);

	// COMMUNE DETAIL TABLEAU COUNT
	public List<Object[]> TableauCountDetailGenreComm(String commune, String sexe);

	public List<Object[]> TableauCountDetailGenreAllComm(String commune);

	// DISTRICT DETAIL TABLEAU COUNT
	public List<Object[]> TableauCountDetailGenreDist(String district, String sexe);

	public List<Object[]> TableauCountDetailGenreAllDist(String district);

}
