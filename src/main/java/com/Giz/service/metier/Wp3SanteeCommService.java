package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Wp3SanteeComm;

public interface Wp3SanteeCommService {

	public List<Wp3SanteeComm> ListWp3SanteeComm();

	public void addWp3SanteeComm(String code_village, String csb, float gps_x, float gps_y, String repro_sexuelle,
			Date date_suivi);
	
	public long countChronologique(String dateChronologique);
	
	public long countChronologiqueGenre(String dateChronologique,String genre);
	
	public Optional<Wp3SanteeComm> findByIdSanteeComm(long id);
	
	public void modifyWp3SanteeComm(String code_village, String csb, float gps_x, float gps_y, String repro_sexuelle,
			Date date_suivi,long id);
	
	public void deleteWp3SanteeComm(Long id);
	
	//graphe

	public long TotTotal(Date debut_date, Date fin_date);

	public List<Object[]> ListFetch();

	public long CamembertTot();

	public List<Object[]> ListGraphe(Date debut_date, Date fin_date);

}
