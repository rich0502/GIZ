package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Plateforme;
import com.Giz.data.domain.TpsFormes;


public interface PlateformeService {


	public List<Plateforme> ListPlateforme();
	
	public List<Plateforme> fetchPlateforme(String type_plateform);

	public void deletePlateforme(Long id_am);
	
	public void addPlateforme(String code_village, boolean exist_platform, boolean operationnel, Date date_suivi,
			String commentaire, String type_plateform);
	
	
	public void modifyPlateforme(Plateforme plateforme,String code_village, boolean exist_platform, boolean operationnel, Date date_suivi,
			String commentaire, String type_plateform, Long id_am);
	
	/* canevas 57 */
	public List<Object[]> ListPlateformeFetch(String type_plateform);
	
	public long TotPlateforme(String type_plateform);
	
	public long TotPlateformeParticipant(String type_plateform,Date debut_date, Date fin_date);
	
	public List<Object[]> TpsPlateforme(String type_plateform,Date debut_date, Date fin_date);
	
	//indicateur
	public long getCount(String dateChronologique, String type_plateform);
	
	public long countPlateforme(String dateChronologique, String type_plateform);
	
}
