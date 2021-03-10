package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.Concours;


public interface ConcoursService {


	public List<Concours> ListConcours();

	public void deleteConcours(Long id_con);
	
	public void addConcours(String code_village, boolean exist, Date date_eval, Date date_suivi);
	
	
	public void modifyConcours(Concours concours,String code_village, boolean exist, Date date_eval, Date date_suivi, Long id_con);

	
}
