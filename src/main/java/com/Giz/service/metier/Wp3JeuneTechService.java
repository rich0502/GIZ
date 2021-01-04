package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Wp3JeuneTech;

public interface Wp3JeuneTechService {

	public List<Wp3JeuneTech> ListWp3JeuneTech();

	public void addWp3JeuneTech(String code_village, String organisme_formateur, boolean frm_recue, String theme_frm1,
			Date date_fin_frm1, String etape_frm1);
	
	public long countChronologique(String dateChronologique);
	
	public long countChronologiqueGenre(String dateChronologique,String genre);
}
