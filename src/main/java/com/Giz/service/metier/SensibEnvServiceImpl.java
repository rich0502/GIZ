package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.SensibEnv;
import com.Giz.repository.SensiEnvRepository;

@Service
public class SensibEnvServiceImpl implements SensiEnvService {
	
	@Autowired
	private SensiEnvRepository sensiEnvRepository;

	@Override
	public List<SensibEnv> ListSensibEnv() {
		// TODO Auto-generated method stub
		return sensiEnvRepository.findAll();
	}

	@Override
	public void deleteSensibEnv(Long id_se) {
		sensiEnvRepository.deleteById(id_se);
		
	}

	@Override
	public void addSensibEnv(String code_village, boolean exist_sens, Date date_fin, String theme_sens,
			int nbr_participant, int nbr_homme, int nbr_femme) {
		SensibEnv sensibEnv = new SensibEnv();
		sensibEnv.setCode_village(code_village);
		sensibEnv.setExist_sens(exist_sens);
		sensibEnv.setDate_fin(date_fin);
		sensibEnv.setTheme_sens(theme_sens);
		sensibEnv.setNbr_participant(nbr_participant);
		sensibEnv.setNbr_homme(nbr_homme);
		sensibEnv.setNbr_femme(nbr_femme);
		sensiEnvRepository.save(sensibEnv);
		
	}

	@Override
	public void modifySensibEnv(SensibEnv sensibEnv, String code_village, boolean exist_sens, Date date_fin,
			String theme_sens, int nbr_participant, int nbr_homme, int nbr_femme, Long id_se) {
		sensibEnv.setCode_village(code_village);
		sensibEnv.setExist_sens(exist_sens);
		sensibEnv.setDate_fin(date_fin);
		sensibEnv.setTheme_sens(theme_sens);
		sensibEnv.setNbr_participant(nbr_participant);
		sensibEnv.setNbr_homme(nbr_homme);
		sensibEnv.setNbr_femme(nbr_femme);
		sensiEnvRepository.save(sensibEnv);
		
	}

	@Override
	public void deleteAllSE() {
		// TODO Auto-generated method stub
		sensiEnvRepository.deleteAll();
	}

	

}
