package com.Giz.service.metier;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.Giz.data.domain.Wp3JeuneTech;
import com.Giz.repository.Wp3JeuneTechRepository;

@Service
public class Wp3JeuneTechServiceImpl implements Wp3JeuneTechService {

	@Autowired
	Wp3JeuneTechRepository wp3JeuneTechRepository;

	@Override
	public List<Wp3JeuneTech> ListWp3JeuneTech() {
		// TODO Auto-generated method stub
		return wp3JeuneTechRepository.findAll();
	}

	@Override
	public void addWp3JeuneTech(String code_village, String organisme_formateur, boolean frm_recue, String theme_frm1,
			Date date_fin_frm1, String etape_frm1) {

		Wp3JeuneTech wp3JeuneTech = new Wp3JeuneTech();
		
		wp3JeuneTech.setCode_village(code_village);
		wp3JeuneTech.setOrganisme_formateur(organisme_formateur);
		wp3JeuneTech.setFrm_recue(frm_recue);
		wp3JeuneTech.setTheme_frm1(theme_frm1);
		wp3JeuneTech.setDate_fin_frm1(date_fin_frm1);
		wp3JeuneTech.setEtape_frm1(etape_frm1);
		/*
		 * wp3JeuneTech.setTheme_frm2(theme_frm2);
		 * wp3JeuneTech.setDate_real2(date_real2);
		 * wp3JeuneTech.setEtape_frm2(etape_frm2);
		 * wp3JeuneTech.setTheme_frm3(theme_frm3);
		 * wp3JeuneTech.setDate_real3(date_real3);
		 * wp3JeuneTech.setEtape_frm3(etape_frm3);
		 */
		
		wp3JeuneTechRepository.save(wp3JeuneTech);
		
	}

	@Override
	public long countChronologique(String dateChronologique) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3JeuneTechRepository.count();
		} else {
			return wp3JeuneTechRepository.countChronologique(dateChronologique);
		}
	}

	@Override
	public long countChronologiqueGenre(String dateChronologique, String genre) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3JeuneTechRepository.countGenre(genre);
		} else {
			return wp3JeuneTechRepository.countChronologiqueGenre(dateChronologique, genre);
		}
	}
}
