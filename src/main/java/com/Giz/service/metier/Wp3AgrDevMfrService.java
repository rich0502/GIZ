package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Wp3AgrDevMfr;

public interface Wp3AgrDevMfrService {
	
	public void deleteAll45();

	public Wp3AgrDevMfr createWp3AgrDevMfr(Wp3AgrDevMfr wp3AgrDevMfr) throws Exception;

	public List<Wp3AgrDevMfr> ListWp3AgrDevMfr();

	public void addWp3AgrDevMfr(String code_village, String nom_mfr, int annee_miseplace, Boolean agr_developpe,
			Date date_eval, String type_agr_dev1, Date date_suivi1);

	public long countChronologique(String dateChronologique);

	public long countChronologiqueGenre(String dateChronologique, String genre);

	public Optional<Wp3AgrDevMfr> finbByIdAgrDevMfr(long id);

	public void modifyWp3AgrDevMfr(String code_village, String nom_mfr, String sexe, int annee_miseplace,
			Boolean agr_developpe, Date date_eval, String type_agr_dev1, Date date_suivi1, long id);

	public void deleteWp3AgrDevMfr(Long id);

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

	public List<Object[]> historiqueList();

}
