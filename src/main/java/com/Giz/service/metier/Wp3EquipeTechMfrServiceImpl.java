package com.Giz.service.metier;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
			String frm_recue1, boolean competence_frm, Date date_eval, String activite) {

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
		wp3EquipeTechMfr.setActivite(activite);
		
		wp3EquipeTechMfrRepository.save(wp3EquipeTechMfr);
		
	}

	@Override
	public long countChronologique(String dateChronologique) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3EquipeTechMfrRepository.count();
		} else {
			return wp3EquipeTechMfrRepository.countChronologique(dateChronologique);
		}
	}

	@Override
	public long countChronologiqueGenre(String dateChronologique, String genre) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3EquipeTechMfrRepository.countGenre(genre);
		} else {
			return wp3EquipeTechMfrRepository.countChronologiqueGenre(dateChronologique, genre);
		}
	}

	@Override
	public Optional<Wp3EquipeTechMfr> findByIdEquipeTechMfr(long id) {
		// TODO Auto-generated method stub
		return wp3EquipeTechMfrRepository.findById(id);
	}

	@Override
	public void modifyWp3EquipeTechMfr(String code_village, String nom_prenom, String sexe, int annee_naissance,
			String frm_recue1, boolean competence_frm, Date date_eval, long id) {
	Wp3EquipeTechMfr wp3EquipeTechMfr = new Wp3EquipeTechMfr();
		
		wp3EquipeTechMfr.setCode_village(code_village);
		wp3EquipeTechMfr.setNom_prenom(nom_prenom);
		wp3EquipeTechMfr.setSexe(sexe);
		wp3EquipeTechMfr.setAnnee_naissance(annee_naissance);
		wp3EquipeTechMfr.setFrm_recue1(frm_recue1);
		wp3EquipeTechMfr.setCompetence_frm(competence_frm);
		wp3EquipeTechMfr.setDate_eval(date_eval);
		wp3EquipeTechMfr.setId(id);
		wp3EquipeTechMfrRepository.save(wp3EquipeTechMfr);
		
	}
	
	@Override
	public void deleteWp3EquipeTechMfr(Long id) {
		wp3EquipeTechMfrRepository.deleteWp3EquipeTechMfr(id);		
	}
	
	//graphe

	@Override
	public long TotTotal(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3EquipeTechMfrRepository.SomTotal(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListFetch() {
		// TODO Auto-generated method stub
		return wp3EquipeTechMfrRepository.fetchData();
	}

	@Override
	public long CamembertTot() {
		// TODO Auto-generated method stub
		return wp3EquipeTechMfrRepository.CamembertTot();
	}

	@Override
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3EquipeTechMfrRepository.TpsData(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableau(Date debut_date, Date fin_date, List<String> params, String sexe) {
		// TODO Auto-generated method stub
		return wp3EquipeTechMfrRepository.TableData(debut_date, fin_date, params, sexe);
	}

	@Override
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3EquipeTechMfrRepository.TableDataCommune(debut_date, fin_date, sexe);
	}

	@Override
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3EquipeTechMfrRepository.TableDataDist(debut_date, fin_date, sexe);
	}
}
