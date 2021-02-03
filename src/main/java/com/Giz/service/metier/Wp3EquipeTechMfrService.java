package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Wp3EquipeTechMfr;

public interface Wp3EquipeTechMfrService {

	public List<Wp3EquipeTechMfr> ListWp3EquipeTechMfr();

	public void addWp3EquipeTechMfr(String code_village, String nom_prenom, String sexe, int annee_naissance,
			String frm_recue1, boolean competence_frm, Date date_eval, String activite);
	
	public long countChronologique(String dateChronologique);
	
	public long countChronologiqueGenre(String dateChronologique, String genre);
	
	public Optional<Wp3EquipeTechMfr> findByIdEquipeTechMfr(long id);
	
	public void modifyWp3EquipeTechMfr(String code_village, String nom_prenom, String sexe, int annee_naissance,
			String frm_recue1, boolean competence_frm, Date date_eval,long id);
	
	public void deleteWp3EquipeTechMfr(Long id);
	
	//graphe

	public long TotTotal(Date debut_date, Date fin_date);

	public List<Object[]> ListFetch();

	public long CamembertTot();

	public List<Object[]> ListGraphe(Date debut_date, Date fin_date);
	
	public List<Object[]> ListTableau(Date debut_date, Date fin_date,List<String> params,String sexe);
	
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe);
	
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe);

}
