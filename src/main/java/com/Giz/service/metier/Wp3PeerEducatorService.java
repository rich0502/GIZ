package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Wp3PeerEducator;

public interface Wp3PeerEducatorService {

	public List<Wp3PeerEducator> ListWp3PeerEducator();

	public void addWp3PeerEducator(String code_village, String nom_prenom, String sexe, int annee_naissance,
			boolean operationnelle, Date date_suivi);
	
	public long countChronologique(String dateChronologique);
	
	public long countChronologiqueGenre(String dateChronologique, String genre);
	
	public Optional<Wp3PeerEducator> findByIdPeerEducator(long id);
	
	public void modifyWp3PeerEducator(String code_village, String nom_prenom, String sexe, int annee_naissance,
			boolean operationnelle, Date date_suivi,long id);
	
	public void deleteWp3PeerEducator(Long id);
	
	//graphe

	public long TotTotal(Date debut_date, Date fin_date);

	public List<Object[]> ListFetch();

	public long CamembertTot();

	public List<Object[]> ListGraphe(Date debut_date, Date fin_date);
	
	public List<Object[]> ListTableau(Date debut_date, Date fin_date,List<String> params,String sexe);
	
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe);
	
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe);

}
