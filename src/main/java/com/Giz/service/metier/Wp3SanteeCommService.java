package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Giz.data.domain.Wp3SanteeComm;

public interface Wp3SanteeCommService {
	
	public void deleteAll48();

	public Wp3SanteeComm createWp3SanteeComm(Wp3SanteeComm wp3SanteeComm) throws Exception;

	public List<Wp3SanteeComm> ListWp3SanteeComm();

	public void addWp3SanteeComm(String code_village, String csb, float gps_x, float gps_y, String repro_sexuelle,
			Date date_suivi);

	public long countChronologique(String dateChronologique);

	public long countChronologiqueGenre(String dateChronologique, String genre);

	public Optional<Wp3SanteeComm> findByIdSanteeComm(long id);

	public void modifyWp3SanteeComm(String code_village, String csb, float gps_x, float gps_y, String repro_sexuelle,
			String sexe, Date date_suivi, long id);

	public void deleteWp3SanteeComm(Long id);

	// graphe

	public long TotTotal(Date debut_date, Date fin_date);

	public List<Object[]> ListFetch();

	public long CamembertTot();

	public List<Object[]> ListGraphe(Date debut_date, Date fin_date);

	public List<Object[]> ListTableau(Date debut_date, Date fin_date, List<String> params, String sexe);

	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe);

	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe);

	public List<Object[]> ListTableauAll(Date debut_date, Date fin_date, List<String> params);

	public List<Object[]> ListTableauCommuneAll(Date debut_date, Date fin_date);

	public List<Object[]> ListTableauDistAll(Date debut_date, Date fin_date);

	// VILLAGE DETAIL TABLEAU COUNT
	public List<Object[]> TableauCountDetailGenre(String village, String sexe);

	public List<Object[]> TableauCountDetailGenreAll(String village);

	// COMMUNE DETAIL TABLEAU COUNT
	public List<Object[]> TableauCountDetailGenreComm(String commune, String sexe);

	public List<Object[]> TableauCountDetailGenreAllComm(String commune);

	// DISTRICT DETAIL TABLEAU COUNT
	public List<Object[]> TableauCountDetailGenreDist(String district, String sexe);

	public List<Object[]> TableauCountDetailGenreAllDist(String district);

}
