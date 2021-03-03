package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.FocusGroup;

public interface FocusGroupService {

	public List<FocusGroup> ListFocusGroup();

	public void deleteFocusGroup(Long id_fg);
	
	public void addFocusGroup(String code_village, boolean realisation, String nomResp, String genre_fg,
			String risque_env, String mesure_prise, Date date_fg);
	
	public void modifyFocusGroup(FocusGroup focusGroup,String code_village, boolean realisation, String nomResp, String genre_fg,
			String risque_env, String mesure_prise, Date date_fg, Long id_fg);
	
}
