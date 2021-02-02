package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.Giz.data.domain.Wp3SanteeComm;
import com.Giz.repository.Wp3SanteeCommRepository;

@Service
public class Wp3SanteeCommServiceImpl implements Wp3SanteeCommService {

	@Autowired
	Wp3SanteeCommRepository wp3SanteeCommRepository;

	@Override
	public List<Wp3SanteeComm> ListWp3SanteeComm() {
		// TODO Auto-generated method stub
		return wp3SanteeCommRepository.findAll();
	}

	@Override
	public void addWp3SanteeComm(String code_village, String csb, float gps_x, float gps_y, String repro_sexuelle,
			Date date_suivi) {

		Wp3SanteeComm wp3SanteeComm = new Wp3SanteeComm();
		
		wp3SanteeComm.setCode_village(code_village);
		wp3SanteeComm.setCsb(csb);
		wp3SanteeComm.setGps_x(gps_x);
		wp3SanteeComm.setGps_y(gps_y);
		wp3SanteeComm.setRepro_sexuelle(repro_sexuelle);
		wp3SanteeComm.setDate_suivi(date_suivi);
		
		wp3SanteeCommRepository.save(wp3SanteeComm);
		
	}

	@Override
	public long countChronologique(String dateChronologique) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3SanteeCommRepository.count();
		} else {
			return wp3SanteeCommRepository.countChronologique(dateChronologique);
		}
	}

	@Override
	public long countChronologiqueGenre(String dateChronologique, String genre) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3SanteeCommRepository.countGenre(genre);
		} else {
			return wp3SanteeCommRepository.countChronologiqueGenre(dateChronologique, genre);
		}
	}

	@Override
	public Optional<Wp3SanteeComm> findByIdSanteeComm(long id) {
		// TODO Auto-generated method stub
		return wp3SanteeCommRepository.findById(id);
	}

	@Override
	public void modifyWp3SanteeComm(String code_village, String csb, float gps_x, float gps_y, String repro_sexuelle,
			Date date_suivi, long id) {

		Wp3SanteeComm wp3SanteeComm = new Wp3SanteeComm();
		
		wp3SanteeComm.setCode_village(code_village);
		wp3SanteeComm.setCsb(csb);
		wp3SanteeComm.setGps_x(gps_x);
		wp3SanteeComm.setGps_y(gps_y);
		wp3SanteeComm.setRepro_sexuelle(repro_sexuelle);
		wp3SanteeComm.setDate_suivi(date_suivi);
		wp3SanteeComm.setId(id);
		wp3SanteeCommRepository.save(wp3SanteeComm);
		
	}
	
	@Override
	public void deleteWp3SanteeComm(Long id) {
		wp3SanteeCommRepository.deleteWp3SanteeComm(id);		
	}
	
	//graphe

	@Override
	public long TotTotal(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3SanteeCommRepository.SomTotal(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListFetch() {
		// TODO Auto-generated method stub
		return wp3SanteeCommRepository.fetchData();
	}

	@Override
	public long CamembertTot() {
		// TODO Auto-generated method stub
		return wp3SanteeCommRepository.CamembertTot();
	}

	@Override
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3SanteeCommRepository.TpsData(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableau(Date debut_date, Date fin_date, List<String> params, String sexe) {
		// TODO Auto-generated method stub
		return wp3SanteeCommRepository.TableData(debut_date, fin_date, params, sexe);
	}

	@Override
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3SanteeCommRepository.TableDataCommune(debut_date, fin_date, sexe);
	}

	@Override
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3SanteeCommRepository.TableDataDist(debut_date, fin_date, sexe);
	}
	
}
