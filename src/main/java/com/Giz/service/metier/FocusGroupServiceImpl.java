package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.FocusGroup;
import com.Giz.repository.FocusGroupRepository;

@Service
public class FocusGroupServiceImpl implements FocusGroupService {
	
	@Autowired
	private FocusGroupRepository focusGroupRepository ;

	@Override
	public List<FocusGroup> ListFocusGroup() {
		// TODO Auto-generated method stub
		return focusGroupRepository.findAll();
	}

	@Override
	public void deleteFocusGroup(Long id_fg) {
		focusGroupRepository.deleteById(id_fg);
		
	}

	@Override
	public void addFocusGroup(String code_village, boolean realisation, String nomResp, String genre_fg,
			String risque_env, String mesure_prise, Date date_fg) {
		FocusGroup focusGroup = new FocusGroup();
		focusGroup.setCode_village(code_village);
		focusGroup.setRealisation(realisation);
		focusGroup.setNomResp(nomResp);
		focusGroup.setGenre_fg(genre_fg.toLowerCase());
		focusGroup.setRisque_env(risque_env);
		focusGroup.setMesure_prise(mesure_prise);
		focusGroup.setDate_fg(date_fg);
		focusGroupRepository.save(focusGroup);
		
	}

	@Override
	public void modifyFocusGroup(FocusGroup focusGroup, String code_village, boolean realisation, String nomResp,
			String genre_fg, String risque_env, String mesure_prise, Date date_fg, Long id_fg) {
		focusGroup.setCode_village(code_village);
		focusGroup.setRealisation(realisation);
		focusGroup.setNomResp(nomResp);
		focusGroup.setGenre_fg(genre_fg.toLowerCase());
		focusGroup.setRisque_env(risque_env);
		focusGroup.setMesure_prise(mesure_prise);
		focusGroup.setDate_fg(date_fg);
		focusGroupRepository.save(focusGroup);
		
	}
	
	

	

}
