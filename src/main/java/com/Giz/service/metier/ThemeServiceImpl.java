package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Adoption_innovation;
import com.Giz.data.domain.ThemeRealise;
import com.Giz.repository.Adopte_InnovationRepository;
import com.Giz.repository.ThemeRepository;

@Service
public class ThemeServiceImpl implements ThemeService {
	
	@Autowired
	private ThemeRepository themeRepository;

	@Override
	public List<ThemeRealise> ListThemeRealise() {
		// TODO Auto-generated method stub
		return themeRepository.findAll();
	}

	@Override
	public void deleteThemeRealise(Long id_tr) {
		themeRepository.deleteById(id_tr);
		
	}

	@Override
	public void addThemeRealise(String code_village, String epp_youth, boolean env, String activites, Date date_suivi) {
		ThemeRealise themeRealise = new ThemeRealise();
		themeRealise.setCode_village(code_village);
		themeRealise.setEpp_youth(epp_youth);
		themeRealise.setEnv(env);
		themeRealise.setActivites(activites);
		themeRealise.setDate_suivi(date_suivi);
		themeRepository.save(themeRealise);
		
	}

	@Override
	public void modifyThemeRealise(ThemeRealise themeRealise, String code_village, String epp_youth, boolean env,
			String activites, Date date_suivi, Long id_tr) {
		themeRealise.setCode_village(code_village);
		themeRealise.setEpp_youth(epp_youth);
		themeRealise.setEnv(env);
		themeRealise.setActivites(activites);
		themeRealise.setDate_suivi(date_suivi);
		themeRepository.save(themeRealise);
		
	}
	
	


}
