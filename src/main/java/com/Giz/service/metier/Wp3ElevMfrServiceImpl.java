package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.Giz.data.domain.Wp3ElevMfr;
import com.Giz.repository.Wp3ElevMfrRepository;

@Service
public class Wp3ElevMfrServiceImpl implements Wp3ElevMfrService {

	@Autowired
	Wp3ElevMfrRepository wp3ElevMfrRepository;

	@Override
	public List<Wp3ElevMfr> ListWp3ElevMfr() {
		// TODO Auto-generated method stub
		return wp3ElevMfrRepository.findAll();
	}

	@Override
	public void addWp3ElevMfr(String code_village, String nom_prenom, String village_origine, String sexe,
			int annee_naissance, boolean inscrit, int annee_inscription, Date date_suivi, String type_frm,
			int annee_etude, Date date_sortie, String type_projet, String niveau_demarrage, Date date_validation,
			boolean accompagne, Date date_suivi1) {

		Wp3ElevMfr wp3ElevMfr = new Wp3ElevMfr();

		wp3ElevMfr.setCode_village(code_village);
		wp3ElevMfr.setNom_prenom(nom_prenom);
		wp3ElevMfr.setVillage_origine(village_origine);
		wp3ElevMfr.setSexe(sexe);
		wp3ElevMfr.setAnnee_naissance(annee_naissance);
		wp3ElevMfr.setInscrit(inscrit);
		wp3ElevMfr.setAnnee_inscription(annee_inscription);
		wp3ElevMfr.setDate_suivi(date_suivi);
		wp3ElevMfr.setType_frm(type_frm);
		wp3ElevMfr.setAnnee_etude(annee_etude);
		wp3ElevMfr.setDate_sortie(date_sortie);
		wp3ElevMfr.setType_projet(type_projet);
		wp3ElevMfr.setNiveau_demarrage(niveau_demarrage);
		wp3ElevMfr.setDate_validation(date_validation);
		wp3ElevMfr.setAccompagne(accompagne);
		wp3ElevMfr.setDate_suivi1(date_suivi1);
		/*
		 * wp3ElevMfr.setDate_suivi2(date_suivi2);
		 * wp3ElevMfr.setDate_suivi3(date_suivi3);
		 * wp3ElevMfr.setDate_suivi4(date_suivi4);
		 */

		wp3ElevMfrRepository.save(wp3ElevMfr);

	}

	@Override
	public long countChronologie(String dateChronologie) {
		if(StringUtils.isEmpty(dateChronologie)) {
			return wp3ElevMfrRepository.count();
		} else {
			return wp3ElevMfrRepository.countChronologie(dateChronologie);
		}
	}

	@Override
	public long countChronologieGenre(String dateChronologie, String genre) {
		if(StringUtils.isEmpty(dateChronologie)) {
			return wp3ElevMfrRepository.countGenre(genre);
		} else {
			return wp3ElevMfrRepository.countChronologieGenre(dateChronologie, genre);
		}
	}

	@Override
	public Optional<Wp3ElevMfr> findByIdWp3ElevMfr(long id) {
		// TODO Auto-generated method stub
		return wp3ElevMfrRepository.findById(id);
	}

	@Override
	public void modifyWp3ElevMfr(String code_village, String nom_prenom, String village_origine, String sexe,
			int annee_naissance, boolean inscrit, int annee_inscription, Date date_suivi, String type_frm,
			int annee_etude, Date date_sortie, String type_projet, String niveau_demarrage, Date date_validation,
			boolean accompagne, Date date_suivi1, long id) {
		Wp3ElevMfr wp3ElevMfr = new Wp3ElevMfr();

		wp3ElevMfr.setCode_village(code_village);
		wp3ElevMfr.setNom_prenom(nom_prenom);
		wp3ElevMfr.setVillage_origine(village_origine);
		wp3ElevMfr.setSexe(sexe);
		wp3ElevMfr.setAnnee_naissance(annee_naissance);
		wp3ElevMfr.setInscrit(inscrit);
		wp3ElevMfr.setAnnee_inscription(annee_inscription);
		wp3ElevMfr.setDate_suivi(date_suivi);
		wp3ElevMfr.setType_frm(type_frm);
		wp3ElevMfr.setAnnee_etude(annee_etude);
		wp3ElevMfr.setDate_sortie(date_sortie);
		wp3ElevMfr.setType_projet(type_projet);
		wp3ElevMfr.setNiveau_demarrage(niveau_demarrage);
		wp3ElevMfr.setDate_validation(date_validation);
		wp3ElevMfr.setAccompagne(accompagne);
		wp3ElevMfr.setDate_suivi1(date_suivi1);
		wp3ElevMfr.setId(id);
		wp3ElevMfrRepository.save(wp3ElevMfr);

		
	}
	
	@Override
	public void deleteWp3ElevMfr(Long id) {
		wp3ElevMfrRepository.deleteWp3ElevMfr(id);		
	}
	
	//graphe

	@Override
	public long TotTotal(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3ElevMfrRepository.SomTotal(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListFetch() {
		// TODO Auto-generated method stub
		return wp3ElevMfrRepository.fetchData();
	}

	@Override
	public long CamembertTot() {
		// TODO Auto-generated method stub
		return wp3ElevMfrRepository.CamembertTot();
	}

	@Override
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3ElevMfrRepository.TpsData(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableau(Date debut_date, Date fin_date, List<String> params, String sexe) {
		// TODO Auto-generated method stub
		return wp3ElevMfrRepository.TableData(debut_date, fin_date, params, sexe);
	}

	@Override
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3ElevMfrRepository.TableDataCommune(debut_date, fin_date, sexe);
	}

	@Override
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3ElevMfrRepository.TableDataDist(debut_date, fin_date, sexe);
	}
}
