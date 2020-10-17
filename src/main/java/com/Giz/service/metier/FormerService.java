package com.Giz.service.metier;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.Giz.data.domain.Former;
import com.Giz.data.domain.GraphDistrict;
import com.Giz.data.domain.TpsFormes;


public interface FormerService {


	public List<Former> ListFormer();

	public void deleteFormer(Long id);
	
	public void addFormer(Date date_frm,
			Long id_bf, Long id_form);
	
	
	public void modifyFormer(Former former, Date date_frm,
			Long id_bf, Long id_form, Long id);
	
	public List<GraphDistrict> ListFormees();
	
	public int TotForms();
	
	public List<TpsFormes> TpsFormer(Date debut_date,Date fin_date);
}
