package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import com.Giz.data.domain.SensibEnv;


public interface SensiEnvService {


	public List<SensibEnv> ListSensibEnv();

	public void deleteSensibEnv(Long id_se);
	
	public void addSensibEnv( String code_village, boolean exist_sens, Date date_fin, String theme_sens,
			int nbr_participant, int nbr_homme, int nbr_femme);
	
	
	public void modifySensibEnv(SensibEnv sensibEnv, String code_village, boolean exist_sens, Date date_fin, String theme_sens,
			int nbr_participant, int nbr_homme, int nbr_femme, Long id_se);
	
}
