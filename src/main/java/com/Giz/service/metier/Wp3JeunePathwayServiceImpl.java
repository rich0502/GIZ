package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.Giz.data.domain.Wp3JeunePathway;
import com.Giz.repository.Wp3JeunePathwayRepository;

@Service
public class Wp3JeunePathwayServiceImpl implements Wp3JeunePathwayService {

	@Autowired
	Wp3JeunePathwayRepository wp3JeunePathwayRepository;

	@Override
	public Wp3JeunePathway createWp3JeunePathway(Wp3JeunePathway wp3JeunePathway) throws Exception {
		return wp3JeunePathway = wp3JeunePathwayRepository.save(wp3JeunePathway);
	}

	@Override
	public List<Wp3JeunePathway> ListWp3JeunePathway() {
		// TODO Auto-generated method stub
		return wp3JeunePathwayRepository.findAll();
	}

	@Override
	public void addWp3JeunePathway(String code_village, String nom_prenom, String sexe, int annee_naissance,
			Date date_fin_frm, String activite) {

		Wp3JeunePathway wp3JeunePathway = new Wp3JeunePathway();

		wp3JeunePathway.setCode_village(code_village);
		wp3JeunePathway.setNom_prenom(nom_prenom);
		wp3JeunePathway.setSexe(sexe);
		wp3JeunePathway.setAnnee_naissance(annee_naissance);
		wp3JeunePathway.setDate_fin_frm(date_fin_frm);
		wp3JeunePathway.setActivite(activite);

		wp3JeunePathwayRepository.save(wp3JeunePathway);

	}

	@Override
	public long countChronologique(String dateChronologique) {
		if (StringUtils.isEmpty(dateChronologique)) {
			return wp3JeunePathwayRepository.countAll();
		} else {
			return wp3JeunePathwayRepository.countChronologie(dateChronologique);
		}
	}

	@Override
	public long countChronologiqueGenre(String dateChronologique, String genre) {
		if (StringUtils.isEmpty(dateChronologique)) {
			return wp3JeunePathwayRepository.countGenre(genre);
		} else {
			return wp3JeunePathwayRepository.countChronologieGenre(dateChronologique, genre);
		}
	}

	@Override
	public Optional<Wp3JeunePathway> findByIdJeunePathway(long id) {
		// TODO Auto-generated method stub
		return wp3JeunePathwayRepository.findById(id);
	}

	@Override
	public void modifyWp3JeunePathway(String code_village, String nom_prenom, String sexe, int annee_naissance,
			boolean existance_agr, Date date_fin_frm, long id) {
		Wp3JeunePathway wp3JeunePathway = new Wp3JeunePathway();

		wp3JeunePathway.setCode_village(code_village);
		wp3JeunePathway.setNom_prenom(nom_prenom);
		wp3JeunePathway.setSexe(sexe);
		wp3JeunePathway.setAnnee_naissance(annee_naissance);
		wp3JeunePathway.setExistance_agr(existance_agr);
		wp3JeunePathway.setDate_fin_frm(date_fin_frm);
		wp3JeunePathway.setId(id);

		wp3JeunePathwayRepository.save(wp3JeunePathway);

	}

	@Override
	public void deleteWp3JeunePathway(Long id) {
		wp3JeunePathwayRepository.deleteWp3JeunePathway(id);
	}

	// graphe

	@Override
	public long TotTotal(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3JeunePathwayRepository.SomTotal(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListFetch() {
		// TODO Auto-generated method stub
		return wp3JeunePathwayRepository.fetchData();
	}

	@Override
	public long CamembertTot() {
		// TODO Auto-generated method stub
		return wp3JeunePathwayRepository.CamembertTot();
	}

	@Override
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3JeunePathwayRepository.TpsData(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableau(Date debut_date, Date fin_date, List<String> params, String sexe) {
		// TODO Auto-generated method stub
		return wp3JeunePathwayRepository.TableData(debut_date, fin_date, params, sexe);
	}

	@Override
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3JeunePathwayRepository.TableDataCommune(debut_date, fin_date, sexe);
	}

	@Override
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3JeunePathwayRepository.TableDataDist(debut_date, fin_date, sexe);
	}

	@Override
	public List<Object[]> ListTableauAll(Date debut_date, Date fin_date, List<String> params) {
		// TODO Auto-generated method stub
		return wp3JeunePathwayRepository.TableDataAll(debut_date, fin_date, params);
	}

	@Override
	public List<Object[]> ListTableauCommuneAll(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3JeunePathwayRepository.TableDataCommuneAll(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableauDistAll(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3JeunePathwayRepository.TableDataDistAll(debut_date, fin_date);
	}
}
