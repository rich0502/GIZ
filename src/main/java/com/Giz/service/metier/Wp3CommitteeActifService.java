package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Wp3CommitteeActif;

public interface Wp3CommitteeActifService {

	public List<Wp3CommitteeActif> ListWp3CommitteeActif();

	public void addWp3CommitteeActif(String code_village, String nom_comite, String mois_annee_creation,
			boolean committee_actif, Date date_suivi, int effectif_membre, int sexe_h, int sexe_f);
	
	public long countChronologique(String dateChronologique);
	
	public long countChronologiqueGenre(String dateChronologique, String genre);
	
	public Optional<Wp3CommitteeActif> findByIdCommitteeActif(long id);
	
	public void modifyWp3CommitteeActif(String code_village, String nom_comite, String mois_annee_creation,
			boolean committee_actif, Date date_suivi, int effectif_membre, int sexe_h, int sexe_f, long id);
	
	public void deleteWp3CommitteeActif(Long id);
	
	//graphe
	
	public long TotTotal(Date debut_date, Date fin_date);
	
	public List<Object[]> ListFetch();
	
	public long CamembertTot();
	
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date);
	
	public List<Object[]> ListTableau(Date debut_date, Date fin_date, List<String> params);
	
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date);
	
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date);
}
