package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Plateforme;


public interface PlateformeService {

	public void deleteAllPlateform(String type_plateform);
	
	public List<Plateforme> ListPlateforme();
	
	public List<Plateforme> fetchPlateforme(String type_plateform);

	public void deletePlateforme(Long id_am);
	
	public void addPlateforme(String code_village, boolean exist_platform, boolean operationnel, Date date_suivi,
			String commentaire, String type_plateform);
	
	
	public Optional<Plateforme> findByIdPlateforme(long id_am);
	
	
	public void modifyPlateforme(String code_village, boolean exist_platform, boolean operationnel, Date date_suivi,
			String commentaire, String type_plateform, Long id_am);
	/* canevas 57 */
	public List<Object[]> ListPlateformeFetch(String type_plateform);
	
	public long TotPlateforme(String type_plateform);
	
	public long TotPlateformeParticipant(String type_plateform,Date debut_date, Date fin_date);
	
	public List<Object[]> TpsPlateforme(String type_plateform,Date debut_date, Date fin_date);
	
	//indicateur
	public long getCount(String dateChronologique, String type_plateform);
	
	public long countPlateforme(String dateChronologique, String type_plateform);
	
	
	public List<Object[]> ListTableau(String type_atelier,List<String> params, Date debut_date, Date fin_date);
	
	public List<Object[]> ListTableauCommune(String type_atelier,Date debut_date, Date fin_date);
	
	public List<Object[]> ListTableauDist(String type_atelier,Date debut_date, Date fin_date);

	public List<Object[]> historiqueList(String type_plateform);
	
}
