package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Cooperative;

public interface CooperativeService {

	public List<Cooperative> ListCooperative();

	public void deleteCooperative(Long id_coop);
	
	public void addCooperative(String code_village, boolean exist, String nom_coop, Date date_creation,
			boolean socio, boolean environnement, Date date_suivi);
	
	public void modifyCooperative(Cooperative cooperative,String code_village, boolean exist, String nom_coop, Date date_creation,
			boolean socio, boolean environnement, Date date_suivi, Long id_coop);
	
}
