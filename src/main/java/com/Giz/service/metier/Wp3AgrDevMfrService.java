package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Wp3AgrDevMfr;

public interface Wp3AgrDevMfrService {

	public List<Wp3AgrDevMfr> ListWp3AgrDevMfr();

	public void addWp3AgrDevMfr(String code_village, String nom_mfr, int annee_miseplace, Boolean agr_developpe,
			Date date_eval, String type_agr_dev1, Date date_suivi1);
	
	public long countChronologique(String dateChronologique);
	
	public long countChronologiqueGenre(String dateChronologique, String genre);
	
	public Optional<Wp3AgrDevMfr> finbByIdAgrDevMfr(long id);
	
	public void modifyWp3AgrDevMfr(String code_village, String nom_mfr, int annee_miseplace, Boolean agr_developpe,
			Date date_eval, String type_agr_dev1, Date date_suivi1,long id);
	
	//graphe

	public long TotTotal(Date debut_date, Date fin_date);

	public List<Object[]> ListFetch();

	public long CamembertTot();

	public List<Object[]> ListGraphe(Date debut_date, Date fin_date);

}
