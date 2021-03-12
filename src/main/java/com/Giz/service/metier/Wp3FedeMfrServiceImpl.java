package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.Giz.data.domain.Wp3FedeMfr;
import com.Giz.repository.Wp3FedeMfrRepository;

@Service
public class Wp3FedeMfrServiceImpl implements Wp3FedeMfrService {

	@Autowired
	Wp3FedeMfrRepository wp3FedeMfrRepository;
	
	@Override
	public Wp3FedeMfr createWp3FedeMfr(Wp3FedeMfr wp3FedeMfr) throws Exception {
		return wp3FedeMfr = wp3FedeMfrRepository.save(wp3FedeMfr);
	}

	@Override
	public List<Wp3FedeMfr> ListWp3FedeMfr() {
		// TODO Auto-generated method stub
		return wp3FedeMfrRepository.findAll();
	}

	@Override
	public void addWp3FedeMfr(String code_region, String nom_mfr, int annee_miseplace, boolean statut,
			boolean reglement_interieur, boolean recepisse_mfr, Date date_recepisse, boolean plan_strategique,
			Date date_validation) {

		Wp3FedeMfr wp3FedeMfr = new Wp3FedeMfr();

		wp3FedeMfr.setCode_region(code_region);
		wp3FedeMfr.setNom_mfr(nom_mfr);
		wp3FedeMfr.setAnnee_miseplace(annee_miseplace);
		wp3FedeMfr.setStatut(statut);
		wp3FedeMfr.setReglement_interieur(reglement_interieur);
		wp3FedeMfr.setRecepisse_mfr(recepisse_mfr);
		wp3FedeMfr.setDate_recepisse(date_recepisse);
		wp3FedeMfr.setPlan_strategique(plan_strategique);
		wp3FedeMfr.setDate_validation(date_validation);

		wp3FedeMfrRepository.save(wp3FedeMfr);

	}

	@Override
	public long countChronologique(String dateChronologique) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3FedeMfrRepository.countAll();
		} else {
			return wp3FedeMfrRepository.countChronolgique(dateChronologique);
		}
	}

	@Override
	public long countChronologiqueGenre(String dateChronologique, String genre) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3FedeMfrRepository.countGenre(genre);
		} else {
			return wp3FedeMfrRepository.countChronolgiqueGenre(dateChronologique, genre);
		}
	}

	@Override
	public Optional<Wp3FedeMfr> findByIdFedeMfr(long id) {
		// TODO Auto-generated method stub
		return wp3FedeMfrRepository.findById(id);
	}

	@Override
	public void modifyWp3FedeMfr(String code_region, String nom_mfr, int annee_miseplace, boolean statut,
			boolean reglement_interieur, boolean recepisse_mfr, Date date_recepisse, boolean plan_strategique,
			Date date_validation, long id) {
		Wp3FedeMfr wp3FedeMfr = new Wp3FedeMfr();

		wp3FedeMfr.setCode_region(code_region);
		wp3FedeMfr.setNom_mfr(nom_mfr);
		wp3FedeMfr.setAnnee_miseplace(annee_miseplace);
		wp3FedeMfr.setStatut(statut);
		wp3FedeMfr.setReglement_interieur(reglement_interieur);
		wp3FedeMfr.setRecepisse_mfr(recepisse_mfr);
		wp3FedeMfr.setDate_recepisse(date_recepisse);
		wp3FedeMfr.setPlan_strategique(plan_strategique);
		wp3FedeMfr.setDate_validation(date_validation);
		wp3FedeMfr.setId(id);
		wp3FedeMfrRepository.save(wp3FedeMfr);
		
	}
	
	@Override
	public void deleteWp3FedeMfr(Long id) {
		wp3FedeMfrRepository.deleteWp3FedeMfr(id);		
	}
	
	//graphe

	@Override
	public long TotTotal(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3FedeMfrRepository.SomTotal(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListFetch() {
		// TODO Auto-generated method stub
		return wp3FedeMfrRepository.fetchData();
	}

	@Override
	public long CamembertTot() {
		// TODO Auto-generated method stub
		return wp3FedeMfrRepository.CamembertTot();
	}

	@Override
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3FedeMfrRepository.TpsData(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableau(Date debut_date, Date fin_date, List<String> params, String sexe) {
		// TODO Auto-generated method stub
		return wp3FedeMfrRepository.TableData(debut_date, fin_date, params, sexe);
	}

	@Override
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3FedeMfrRepository.TableDataCommune(debut_date, fin_date, sexe);
	}

	@Override
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3FedeMfrRepository.TableDataDist(debut_date, fin_date, sexe);
	}
	
	@Override
	public List<Object[]> ListTableauAll(Date debut_date, Date fin_date, List<String> params) {
		// TODO Auto-generated method stub
		return wp3FedeMfrRepository.TableDataAll(debut_date, fin_date, params);
	}

	@Override
	public List<Object[]> ListTableauCommuneAll(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3FedeMfrRepository.TableDataCommuneAll(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableauDistAll(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3FedeMfrRepository.TableDataDistAll(debut_date, fin_date);
	}
}
