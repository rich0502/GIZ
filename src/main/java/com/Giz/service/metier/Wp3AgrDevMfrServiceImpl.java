package com.Giz.service.metier;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Wp3AgrDevMfr;
import com.Giz.repository.Wp3AgrDevMfrRepository;

@Service
public class Wp3AgrDevMfrServiceImpl implements Wp3AgrDevMfrService {

	@Autowired
	Wp3AgrDevMfrRepository wp3AgrDevMfrRepository;

	@Override
	public List<Wp3AgrDevMfr> ListWp3AgrDevMfr() {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.findAll();
	}

	@Override
	public void addWp3AgrDevMfr(String code_village, String nom_mfr, int annee_miseplace, String agr_developpe,
			Date date_eval, String type_agr_dev1, Date date_suivi1) {

		Wp3AgrDevMfr wp3AgrDevMfr = new Wp3AgrDevMfr();
		
		wp3AgrDevMfr.setCode_village(code_village);
		wp3AgrDevMfr.setNom_mfr(nom_mfr);
		wp3AgrDevMfr.setAnnee_miseplace(annee_miseplace);
		wp3AgrDevMfr.setAgr_developpe(agr_developpe);
		wp3AgrDevMfr.setDate_eval(date_eval);
		wp3AgrDevMfr.setType_agr_dev1(type_agr_dev1);
		wp3AgrDevMfr.setDate_suivi1(date_suivi1);
		/*
		 * wp3AgrDevMfr.setType_agr_dev2(type_agr_dev2);
		 * wp3AgrDevMfr.setDate_suivi2(date_suivi2);
		 * wp3AgrDevMfr.setType_agr_dev3(type_agr_dev3);
		 * wp3AgrDevMfr.setDate_suivi3(date_suivi3);
		 * wp3AgrDevMfr.setType_agr_dev4(type_agr_dev4);
		 * wp3AgrDevMfr.setDate_suivi4(date_suivi4);
		 * wp3AgrDevMfr.setType_agr_dev5(type_agr_dev5);
		 * wp3AgrDevMfr.setDate_suivi5(date_suivi5);
		 */
		
		wp3AgrDevMfrRepository.save(wp3AgrDevMfr);
		
	}
}
