package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.AtelierMFR;


public interface AtelierMFRService {


	public List<AtelierMFR> ListAtelierMFR();
	
	public List<AtelierMFR> fetchAtelier(String type_atelier);

	public void deleteAtelierMFR(Long id_am);
	
	public void addAtelierMFR(String code_village, String atelier_resp, Date date_realise, String lieu_realise, String theme_choise,
			long nbr_particip, int nbr_homme, int nbr_femme, String cible_atelier, String type_atelier);
	
	
	public Optional<AtelierMFR> findByIdAtelierMFR(long id_am);
	
	
	public void modifyAtelierMFR(String code_village, String atelier_resp, Date date_realise, String lieu_realise, String theme_choise,
			long nbr_particip, int nbr_homme, int nbr_femme, String cible_atelier, String type_atelier, Long id_am);
	
	/*canevas 52 */
	
	public List<Object[]> ListAtelierFetch(String type_atelier);
	
	public long TotAtelierMFR(String type_atelier);
	
	public long TotAtelierParticipant(String type_atelier,Date debut_date, Date fin_date);
	
	public List<Object[]> TpsAtelierMFR(String type_atelier,Date debut_date, Date fin_date);
	
	//indicateur
	public long getCountHomme(String dateChronologique, String type_atelier);
	
	public long getCountFemme(String dateChronologique, String type_atelier);
	
	public long countAtelier(String dateChronologique, String type_atelier);
	
	public List<Object[]> ListTableau(String type_atelier,List<String> params, Date debut_date, Date fin_date);
	
	public List<Object[]> ListTableauCommune(String type_atelier,Date debut_date, Date fin_date);
	
	public List<Object[]> ListTableauDist(String type_atelier,Date debut_date, Date fin_date);
	
}
