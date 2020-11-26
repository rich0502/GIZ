package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
