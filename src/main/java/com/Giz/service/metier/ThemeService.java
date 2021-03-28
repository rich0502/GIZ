package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.ThemeRealise;


public interface ThemeService {


	public List<ThemeRealise> ListThemeRealise();

	public void deleteThemeRealise(Long id_tr);
	
	public void addThemeRealise( String code_village, String epp_youth, boolean env, String activites,
			Date date_suivi);
	
	
	public void modifyThemeRealise(ThemeRealise themeRealise, String code_village, String epp_youth, boolean env, String activites,
			Date date_suivi, Long id_tr);

	public void deleteAllTheme();
	
}
