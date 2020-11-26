package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Wp3SanteeComm;

public interface Wp3SanteeCommService {

	public List<Wp3SanteeComm> ListWp3SanteeComm();

	public void addWp3SanteeComm(String code_village, String csb, float gps_x, float gps_y, String repro_sexuelle,
			Date date_suivi);
}
