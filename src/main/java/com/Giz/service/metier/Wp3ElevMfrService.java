package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Wp3ElevMfr;

public interface Wp3ElevMfrService {

	public List<Wp3ElevMfr> ListWp3ElevMfr();

	public void addWp3ElevMfr(String code_village, String nom_prenom, String village_origine, String sexe,
			int annee_naissance, boolean inscrit, int annee_inscription, Date date_suivi, String type_frm,
			int annee_etude, Date date_sortie, String type_projet, String niveau_demarrage, Date date_validation,
			boolean accompagne, Date date_suivi1);
	
	public long countChronologie(String dateChronologie);
	
	public long countChronologieGenre(String dateChronologie,String genre);
	
	public Optional<Wp3ElevMfr> findByIdWp3ElevMfr(long id);
	
	public void modifyWp3ElevMfr(String code_village, String nom_prenom, String village_origine, String sexe,
			int annee_naissance, boolean inscrit, int annee_inscription, Date date_suivi, String type_frm,
			int annee_etude, Date date_sortie, String type_projet, String niveau_demarrage, Date date_validation,
			boolean accompagne, Date date_suivi1,long id);
	
	public void deleteWp3ElevMfr(Long id);
	
	//graphe

	public long TotTotal(Date debut_date, Date fin_date);

	public List<Object[]> ListFetch();

	public long CamembertTot();

	public List<Object[]> ListGraphe(Date debut_date, Date fin_date);
	
	public List<Object[]> ListTableau(Date debut_date, Date fin_date,List<String> params,String sexe);
	
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe);
	
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe);

}
