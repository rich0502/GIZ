package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Wp3FormTechMetierJeune;


public interface Wp3FormTechMetierJeuneService {

	public List<Wp3FormTechMetierJeune> ListWp3FormTechMetierJeune();

	public Wp3FormTechMetierJeune addWp3FormTechMetierJeune(String code_village, String sexe, int annee_naissance,
			String organisme_formateur, Boolean formation_recue, String theme, Date date_fin, String etape_suivre,
			Date date_realise);
	
	public Optional<Wp3FormTechMetierJeune> findByIdWp3FormTechMetierJeune(long id);
	
	public long countChronologique(String dateChronologique);
	
	public long countChronologiqueGenre(String dateChronologique,String genre);
	
	public Wp3FormTechMetierJeune modifyWp3FormTechMetierJeune(String code_village, String sexe, int annee_naissance,
			String organisme_formateur, Boolean formation_recue, String theme, Date date_fin, String etape_suivre,
			Date date_realise,long id);
	
	public void deleteWp3FormTechMetierJeune(Long id);
	
	//graphe

	public long TotTotal(Date debut_date, Date fin_date);

	public List<Object[]> ListFetch();

	public long CamembertTot();

	public List<Object[]> ListGraphe(Date debut_date, Date fin_date);
	
	public List<Object[]> ListTableau(Date debut_date, Date fin_date,List<String> params,String sexe);
	
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe);
	
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe);



}
