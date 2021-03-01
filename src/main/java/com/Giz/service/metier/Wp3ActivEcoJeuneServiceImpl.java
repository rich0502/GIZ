package com.Giz.service.metier;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.Giz.data.domain.Beneficiaire;
import com.Giz.data.domain.Storie;
import com.Giz.data.domain.TpsFormes;
import com.Giz.data.domain.Wp3ActivEcoJeune;
import com.Giz.repository.Wp3ActivEcoJeuneRepository;

@Service
public class Wp3ActivEcoJeuneServiceImpl implements Wp3ActivEcoJeuneService {

	@Autowired
	Wp3ActivEcoJeuneRepository wp3ActivEcoJeuneRepository;
	
	@Override
	public Wp3ActivEcoJeune createWp3ActivEcoJeune(Wp3ActivEcoJeune wp3ActivEcoJeune) throws Exception {
		return wp3ActivEcoJeune = wp3ActivEcoJeuneRepository.save(wp3ActivEcoJeune);
	}

	@Override
	public List<Wp3ActivEcoJeune> ListWp3ActivEcoJeune() {
		// TODO Auto-generated method stub
		return wp3ActivEcoJeuneRepository.findAll();
	}

	@Override
	public void addWp3ActivEcoJeune(String code_village, String nom_prenom, String sexe, int annee_naissance,
			String organisme_formateur, String frm_tech_suivi, Date date_fin_frm, String activite_eco,
			Date date_demarrage,String activite) {

		Wp3ActivEcoJeune wp3ActivEcoJeune = new Wp3ActivEcoJeune();
		wp3ActivEcoJeune.setCode_village(code_village);
		wp3ActivEcoJeune.setNom_prenom(nom_prenom);
		wp3ActivEcoJeune.setSexe(sexe.toLowerCase());
		wp3ActivEcoJeune.setAnnee_naissance(annee_naissance);
		wp3ActivEcoJeune.setOrganisme_formateur(organisme_formateur);
		wp3ActivEcoJeune.setFrm_tech_suivi(frm_tech_suivi);
		wp3ActivEcoJeune.setDate_fin_frm(date_fin_frm);
		wp3ActivEcoJeune.setActivite_eco(activite_eco);
		wp3ActivEcoJeune.setDate_demarrage(date_demarrage);
		wp3ActivEcoJeune.setActivite(activite);
		

		wp3ActivEcoJeuneRepository.save(wp3ActivEcoJeune);
		
	}

	@Override
	public long countActivEcoJeune(String dateChronologique) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3ActivEcoJeuneRepository.count();
		} else {
			return wp3ActivEcoJeuneRepository.getCountChronologique(dateChronologique);
		}
	}

	@Override
	public long countActivEcoJeuneGenre(String dateChronologique, String genre) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3ActivEcoJeuneRepository.getCountGenre(genre);
		} else {
			return wp3ActivEcoJeuneRepository.getCountChronologiqueGenre(dateChronologique, genre);
		}
	}

	@Override
	public Optional<Wp3ActivEcoJeune> findByIdActivEcoJeune(long id) {
		return wp3ActivEcoJeuneRepository.findById(id);
	}
	
	@Override
	public void modifyActivEcoJeune(String code_village, String nom_prenom, String sexe, int annee_naissance,
			String organisme_formateur, String frm_tech_suivi, Date date_fin_frm, String activite_eco,
			Date date_demarrage, Long id) {	
		Wp3ActivEcoJeune wp3ActivEcoJeune = new Wp3ActivEcoJeune();
		wp3ActivEcoJeune.setCode_village(code_village);
		wp3ActivEcoJeune.setNom_prenom(nom_prenom);
		wp3ActivEcoJeune.setSexe(sexe);
		wp3ActivEcoJeune.setAnnee_naissance(annee_naissance);
		wp3ActivEcoJeune.setOrganisme_formateur(organisme_formateur);
		wp3ActivEcoJeune.setFrm_tech_suivi(frm_tech_suivi);
		wp3ActivEcoJeune.setDate_fin_frm(date_fin_frm);
		wp3ActivEcoJeune.setDate_demarrage(date_demarrage);
		wp3ActivEcoJeune.setFrm_tech_suivi(frm_tech_suivi);
		wp3ActivEcoJeune.setActivite_eco(activite_eco);
		wp3ActivEcoJeune.setId(id);
		wp3ActivEcoJeuneRepository.save(wp3ActivEcoJeune);
		
	}
	
	@Override
	public void deleteWP3ActivEcoJeune(Long id) {
		wp3ActivEcoJeuneRepository.deleteWP3ActivEcoJeune(id);		
	}

	//graphe

	@Override
	public long TotTotal(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3ActivEcoJeuneRepository.SomTotal(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListFetch() {
		// TODO Auto-generated method stub
		return wp3ActivEcoJeuneRepository.fetchData();
	}

	@Override
	public long CamembertTot() {
		// TODO Auto-generated method stub
		return wp3ActivEcoJeuneRepository.CamembertTot();
	}
	
	@Override
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3ActivEcoJeuneRepository.TpsData(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableau(Date debut_date, Date fin_date, List<String> params, String sexe) {
		// TODO Auto-generated method stub
		return wp3ActivEcoJeuneRepository.TableData(debut_date, fin_date, params, sexe);
	}

	@Override
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3ActivEcoJeuneRepository.TableDataCommune(debut_date, fin_date, sexe);
	}

	@Override
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3ActivEcoJeuneRepository.TableDataDist(debut_date, fin_date, sexe);
	}
	

}
