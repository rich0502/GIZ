package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Wp3FedeMfr;

public interface Wp3FedeMfrService {

	public List<Wp3FedeMfr> ListWp3FedeMfr();

	public void addWp3FedeMfr(String code_region, String nom_mfr, int annee_miseplace, boolean statut,
			boolean reglement_interieur, boolean recepisse_mfr, Date date_recepisse, boolean plan_strategique,
			Date date_validation);
	
	public long countChronologique(String dateChronologique);
	
	public long countChronologiqueGenre(String dateChronologique, String genre);
	
	public Optional<Wp3FedeMfr> findByIdFedeMfr(long id);
	
	public void modifyWp3FedeMfr(String code_region, String nom_mfr, int annee_miseplace, boolean statut,
			boolean reglement_interieur, boolean recepisse_mfr, Date date_recepisse, boolean plan_strategique,
			Date date_validation,long id);
	
	//graphe

	public long TotTotal(Date debut_date, Date fin_date);

	public List<Object[]> ListFetch();

	public long CamembertTot();

	public List<Object[]> ListGraphe(Date debut_date, Date fin_date);

	
}
