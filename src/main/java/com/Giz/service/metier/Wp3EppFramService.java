package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Wp3EppFram;

public interface Wp3EppFramService {
	
	public Wp3EppFram createWp3EppFram(Wp3EppFram wp3EppFram) throws Exception;

	public List<Wp3EppFram> ListWp3EppFram();

	public void addWp3EppFram(String code_village, String nom_ecole, boolean projet_fram, boolean projet_valide,
			String type_projet, Date date_validation);
	
	public long countChronologique(String dateChronologique);
	
	public long countChronologiqueGenre(String dateChronologique, String genre);
	
	public Optional<Wp3EppFram> findByIdEppFram (long id);
	
	public void modifyWp3EppFram(String code_village, String nom_ecole, boolean projet_fram, boolean projet_valide,
			String type_projet, Date date_validation,long id);
	
	public void deleteWp3EppFram(Long id);
	
	//graphe

	public long TotTotal(Date debut_date, Date fin_date);

	public List<Object[]> ListFetch();

	public long CamembertTot();

	public List<Object[]> ListGraphe(Date debut_date, Date fin_date);
	
	public List<Object[]> ListTableau(Date debut_date, Date fin_date,List<String> params,String sexe);
	
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe);
	
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe);

	
}
