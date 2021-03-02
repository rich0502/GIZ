package com.Giz.service.metier;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Formation_bpa;
import com.Giz.repository.Formation_bpaRepository;

@Service
public class FormationBpaServiceImpl implements FormationBpaService {
	@Autowired
	private Formation_bpaRepository formation_bpaRepository;

	@Override
	public List<Formation_bpa> ListFormation_bpa() {
		// TODO Auto-generated method stub
		return formation_bpaRepository.findAll();
	}

	@Override
	public void deleteFormation_bpa(Long id_bpa) {
		formation_bpaRepository.deleteById(id_bpa);
		
	}

	@Override
	public void addFormation_bpa(String code_pro, String code_village, String nomPrenom_bpa, String genre_ai,
			int annee_naiss, String frm_recu, java.util.Date date_frm, String theme_frm) {
		Formation_bpa formation_bpa = new Formation_bpa();
		formation_bpa.setCode_pro(code_pro);
		formation_bpa.setCode_village(code_village);
		formation_bpa.setNomPrenom_bpa(nomPrenom_bpa);
		formation_bpa.setGenre_ai(genre_ai.toLowerCase());
		formation_bpa.setAnnee_naiss(annee_naiss);
		formation_bpa.setFrm_recu(frm_recu);
		formation_bpa.setDate_frm(date_frm);
		formation_bpa.setTheme_frm(theme_frm);
		
		formation_bpaRepository.save(formation_bpa);
		
	}

	@Override
	public void modifyFormation_bpa(Formation_bpa formation_bpa, String code_pro, String code_village,
			String nomPrenom_bpa, String genre_ai, int annee_naiss, String frm_recu, java.util.Date date_frm,
			String theme_frm, Long id_bpa) {
		formation_bpa.setCode_pro(code_pro);
		formation_bpa.setCode_village(code_village);
		formation_bpa.setNomPrenom_bpa(nomPrenom_bpa);
		formation_bpa.setGenre_ai(genre_ai.toLowerCase());
		formation_bpa.setAnnee_naiss(annee_naiss);
		formation_bpa.setFrm_recu(frm_recu);
		formation_bpa.setDate_frm(date_frm);
		formation_bpa.setTheme_frm(theme_frm);
		
		formation_bpaRepository.save(formation_bpa);
		
	}

	@Override
	public long countbpa() {
		// TODO Auto-generated method stub
		return formation_bpaRepository.count();
	}



}
