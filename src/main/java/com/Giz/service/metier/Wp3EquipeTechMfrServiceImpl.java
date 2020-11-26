package com.Giz.service.metier;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Wp3EquipeTechMfr;
import com.Giz.repository.Wp3EquipeTechMfrRepository;

@Service
public class Wp3EquipeTechMfrServiceImpl implements Wp3EquipeTechMfrService {

	@Autowired
	Wp3EquipeTechMfrRepository wp3EquipeTechMfrRepository;

	@Override
	public List<Wp3EquipeTechMfr> ListWp3EquipeTechMfr() {
		// TODO Auto-generated method stub
		return wp3EquipeTechMfrRepository.findAll();
	}

	@Override
	public void addWp3EquipeTechMfr(String code_village, String nom_prenom, String sexe, int annee_naissance,
			String frm_recue1, boolean competence_frm, Date date_eval) {

		Wp3EquipeTechMfr wp3EquipeTechMfr = new Wp3EquipeTechMfr();
		
		wp3EquipeTechMfr.setCode_village(code_village);
		wp3EquipeTechMfr.setNom_prenom(nom_prenom);
		wp3EquipeTechMfr.setSexe(sexe);
		wp3EquipeTechMfr.setAnnee_naissance(annee_naissance);
		wp3EquipeTechMfr.setFrm_recue1(frm_recue1);
		/*
		 * wp3EquipeTechMfr.setFrm_recue2(frm_recue2);
		 * wp3EquipeTechMfr.setFrm_recue3(frm_recue3);
		 * wp3EquipeTechMfr.setFrm_recue4(frm_recue4);
		 */
		wp3EquipeTechMfr.setCompetence_frm(competence_frm);
		wp3EquipeTechMfr.setDate_eval(date_eval);
		
		wp3EquipeTechMfrRepository.save(wp3EquipeTechMfr);
		
	}
}
