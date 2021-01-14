package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Wp3JeunePathway;

public interface Wp3JeunePathwayService {

	public List<Wp3JeunePathway> ListWp3JeunePathway();

	public void addWp3JeunePathway(String code_village, String nom_prenom, String sexe, int annee_naissance,
			Date date_fin_frm);
	
	public long countChronologique(String dateChronologique);
	
	public long countChronologiqueGenre(String dateChronologique,String genre);
	
	public Optional<Wp3JeunePathway> findByIdJeunePathway(long id);
	
	public void modifyWp3JeunePathway(String code_village, String nom_prenom, String sexe, int annee_naissance,
			Date date_fin_frm, long id);
	
	public void deleteWp3JeunePathway(Long id);
	
	//graphe

	public long TotTotal(Date debut_date, Date fin_date);

	public List<Object[]> ListFetch();

	public long CamembertTot();

	public List<Object[]> ListGraphe(Date debut_date, Date fin_date);

}
