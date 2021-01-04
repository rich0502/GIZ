package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.AtelierMFR;
import com.Giz.data.domain.GraphDist;
import com.Giz.data.domain.GraphDistrict;
import com.Giz.data.domain.TpsFormes;


public interface AtelierMFRService {


	public List<AtelierMFR> ListAtelierMFR();
	
	public List<AtelierMFR> fetchAtelier(String type_atelier);

	public void deleteAtelierMFR(Long id_am);
	
	public void addAtelierMFR(String code_village, String atelier_resp, Date date_realise, String lieu_realise, String theme_choise,
			long nbr_particip, int nbr_homme, int nbr_femme, String cible_atelier, String type_atelier);
	
	
	public void modifyAtelierMFR(AtelierMFR atelierMFR,String code_village, String atelier_resp, Date date_realise, String lieu_realise, String theme_choise,
			long nbr_particip, int nbr_homme, int nbr_femme, String cible_atelier, String type_atelier, Long id_am);
	
	/*canevas 52 */
	
	public List<Object[]> ListAtelierFetch(String type_atelier);
	
	public long TotAtelierMFR(String type_atelier);
	
	public long TotAtelierParticipant(String type_atelier,Date debut_date, Date fin_date);
	
	public List<Object[]> TpsAtelierMFR(String type_atelier,Date debut_date, Date fin_date);
	
}
