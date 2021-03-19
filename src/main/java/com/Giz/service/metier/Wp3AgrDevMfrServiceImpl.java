package com.Giz.service.metier;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.Giz.data.domain.Wp3AgrDevMfr;
import com.Giz.repository.Wp3AgrDevMfrRepository;

@Service
public class Wp3AgrDevMfrServiceImpl implements Wp3AgrDevMfrService {

	@Autowired
	Wp3AgrDevMfrRepository wp3AgrDevMfrRepository;
	
	@Override
	public Wp3AgrDevMfr createWp3AgrDevMfr(Wp3AgrDevMfr wp3AgrDevMfr) throws Exception {
		return wp3AgrDevMfr = wp3AgrDevMfrRepository.save(wp3AgrDevMfr);
	}

	@Override
	public List<Wp3AgrDevMfr> ListWp3AgrDevMfr() {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.findAll();
	}

	@Override
	public void addWp3AgrDevMfr(String code_village, String nom_mfr, int annee_miseplace, Boolean agr_developpe,
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

	@Override
	public long countChronologique(String dateChronologique) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3AgrDevMfrRepository.count();
		} else {
			return wp3AgrDevMfrRepository.countChronologie(dateChronologique);
		}
	}

	@Override
	public long countChronologiqueGenre(String dateChronologique, String genre) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3AgrDevMfrRepository.countGenre(genre);
		} else {
			return wp3AgrDevMfrRepository.countChronologieGenre(dateChronologique, genre);
		}
	}

	@Override
	public Optional<Wp3AgrDevMfr> finbByIdAgrDevMfr(long id) {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.findById(id);
	}

	@Override
	public void modifyWp3AgrDevMfr(String code_village, String nom_mfr,String sexe, int annee_miseplace, Boolean agr_developpe,
			Date date_eval, String type_agr_dev1, Date date_suivi1, long id) {
Wp3AgrDevMfr wp3AgrDevMfr = new Wp3AgrDevMfr();
		
		wp3AgrDevMfr.setCode_village(code_village);
		wp3AgrDevMfr.setNom_mfr(nom_mfr);
		wp3AgrDevMfr.setSexe(sexe);
		wp3AgrDevMfr.setAnnee_miseplace(annee_miseplace);
		wp3AgrDevMfr.setAgr_developpe(agr_developpe);
		wp3AgrDevMfr.setDate_eval(date_eval);
		wp3AgrDevMfr.setType_agr_dev1(type_agr_dev1);
		wp3AgrDevMfr.setDate_suivi1(date_suivi1);
		wp3AgrDevMfr.setId(id);
		wp3AgrDevMfrRepository.save(wp3AgrDevMfr);
		
		
	}
	
	@Override
	public void deleteWp3AgrDevMfr(Long id) {
		wp3AgrDevMfrRepository.deleteWp3AgrDevMfr(id);		
	}
	
	//graphe

	@Override
	public long TotTotal(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.SomTotal(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListFetch() {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.fetchData();
	}

	@Override
	public long CamembertTot() {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.CamembertTot();
	}

	@Override
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.TpsData(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableau(Date debut_date, Date fin_date, List<String> params, String sexe) {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.TableData(debut_date, fin_date, params, sexe);
	}

	@Override
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.TableDataCommune(debut_date, fin_date, sexe);
	}

	@Override
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.TableDataDist(debut_date, fin_date, sexe);
	}
	
	@Override
	public List<Object[]> ListTableauAll(Date debut_date, Date fin_date, List<String> params) {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.TableDataAll(debut_date, fin_date, params);
	}

	@Override
	public List<Object[]> ListTableauCommuneAll(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.TableDataCommuneAll(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableauDistAll(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.TableDataDistAll(debut_date, fin_date);
	}
	
	// VILLAGE DETAIL TABLEAU COUNT

	@Override
	public List<Object[]> TableauCountDetailGenre(String village, String sexe) {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.TableCountDetailGenre(village, sexe);
	}
	@Override
	public List<Object[]> TableauCountDetailGenreAll(String village) {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.TableCountDetailGenreAll(village);
	}
	
		// COMMUNE DETAIL TABLEAU COUNT
	
	@Override
	public List<Object[]> TableauCountDetailGenreComm(String commune, String sexe) {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.TableCountDetailGenreComm(commune, sexe);
	}
	@Override
	public List<Object[]> TableauCountDetailGenreAllComm(String commune) {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.TableCountDetailGenreAllComm(commune);
	}
	
	// DISTRICT DETAIL TABLEAU COUNT
	
	@Override
	public List<Object[]> TableauCountDetailGenreDist(String district, String sexe) {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.TableCountDetailGenreDist(district, sexe);
	}
	@Override
	public List<Object[]> TableauCountDetailGenreAllDist(String district) {
		// TODO Auto-generated method stub
		return wp3AgrDevMfrRepository.TableCountDetailGenreAllDist(district);
	}

}
