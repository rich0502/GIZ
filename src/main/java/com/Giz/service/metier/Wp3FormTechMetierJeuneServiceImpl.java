package com.Giz.service.metier;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.Giz.data.domain.Wp3FormTechMetierJeune;
import com.Giz.repository.Wp3FormTechMetierJeuneRepository;

@Service
public class Wp3FormTechMetierJeuneServiceImpl implements Wp3FormTechMetierJeuneService {

	@Autowired
	Wp3FormTechMetierJeuneRepository wp3FormTechMetierJeuneRepository;
	
	@Override
	public Wp3FormTechMetierJeune createWp3FormTechMetierJeune(Wp3FormTechMetierJeune wp3FormTechMetierJeune) throws Exception {
		return wp3FormTechMetierJeune = wp3FormTechMetierJeuneRepository.save(wp3FormTechMetierJeune);
	}

	@Override
	public List<Wp3FormTechMetierJeune> ListWp3FormTechMetierJeune() {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.findAll();
	}

	@Override
	public Wp3FormTechMetierJeune addWp3FormTechMetierJeune(String code_village, String sexe, int annee_naissance,
			String organisme_formateur, Boolean formation_recue, String theme, Date date_fin, String etape_suivre,
			Date date_realise) {
		Wp3FormTechMetierJeune wp3FormTechMetierJeune = new Wp3FormTechMetierJeune();
		wp3FormTechMetierJeune.setCode_village(code_village);
		wp3FormTechMetierJeune.setSexe(sexe);
		wp3FormTechMetierJeune.setAnnee_naissance(annee_naissance);
		wp3FormTechMetierJeune.setOrganisme_formateur(organisme_formateur);
		wp3FormTechMetierJeune.setFormation_recue(formation_recue);
		wp3FormTechMetierJeune.setTheme(theme);
		wp3FormTechMetierJeune.setDate_fin(date_fin);
		wp3FormTechMetierJeune.setEtape_suivre(etape_suivre);
		wp3FormTechMetierJeune.setDate_realise(date_realise);
		return wp3FormTechMetierJeuneRepository.save(wp3FormTechMetierJeune);
		
	}

	@Override
	public long countChronologique(String dateChronologique) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3FormTechMetierJeuneRepository.count();
		} else {
			return wp3FormTechMetierJeuneRepository.countChronologique(dateChronologique);
		}
	}

	@Override
	public long countChronologiqueGenre(String dateChronologique, String genre) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3FormTechMetierJeuneRepository.countGenre(genre);
		} else {
			return wp3FormTechMetierJeuneRepository.countChronologiqueGenre(dateChronologique, genre);
		}
	}

	@Override
	public Optional<Wp3FormTechMetierJeune> findByIdWp3FormTechMetierJeune(long id) {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.findById(id);
	}

	@Override
	public Wp3FormTechMetierJeune modifyWp3FormTechMetierJeune(String code_village, String sexe, int annee_naissance,
			String organisme_formateur, Boolean formation_recue, String theme, Date date_fin, String etape_suivre,
			Date date_realise, long id) {
		Wp3FormTechMetierJeune wp3FormTechMetierJeune = new Wp3FormTechMetierJeune();
		wp3FormTechMetierJeune.setCode_village(code_village);
		wp3FormTechMetierJeune.setSexe(sexe);
		wp3FormTechMetierJeune.setAnnee_naissance(annee_naissance);
		wp3FormTechMetierJeune.setOrganisme_formateur(organisme_formateur);
		wp3FormTechMetierJeune.setFormation_recue(formation_recue);
		wp3FormTechMetierJeune.setTheme(theme);
		wp3FormTechMetierJeune.setDate_fin(date_fin);
		wp3FormTechMetierJeune.setEtape_suivre(etape_suivre);
		wp3FormTechMetierJeune.setDate_realise(date_realise);
		wp3FormTechMetierJeune.setId(id);
		return wp3FormTechMetierJeuneRepository.save(wp3FormTechMetierJeune);
	}
	
	@Override
	public void deleteWp3FormTechMetierJeune(Long id) {
		wp3FormTechMetierJeuneRepository.deleteWp3FormTechMetierJeune(id);		
	}

	//graphe

	@Override
	public long TotTotal(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.SomTotal(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListFetch() {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.fetchData();
	}

	@Override
	public long CamembertTot() {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.CamembertTot();
	}

	@Override
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.TpsData(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableau(Date debut_date, Date fin_date, List<String> params, String sexe) {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.TableData(debut_date, fin_date, params, sexe);
	}

	@Override
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.TableDataCommune(debut_date, fin_date, sexe);
	}

	@Override
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.TableDataDist(debut_date, fin_date, sexe);
	}

	@Override
	public List<Object[]> ListTableauAll(Date debut_date, Date fin_date, List<String> params) {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.TableDataAll(debut_date, fin_date, params);
	}

	@Override
	public List<Object[]> ListTableauCommuneAll(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.TableDataCommuneAll(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableauDistAll(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.TableDataDistAll(debut_date, fin_date);
	}
	// VILLAGE DETAIL TABLEAU COUNT

	@Override
	public List<Object[]> TableauCountDetailGenre(String village, String sexe) {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.TableCountDetailGenre(village, sexe);
	}
	@Override
	public List<Object[]> TableauCountDetailGenreAll(String village) {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.TableCountDetailGenreAll(village);
	}
	
		// COMMUNE DETAIL TABLEAU COUNT
	
	@Override
	public List<Object[]> TableauCountDetailGenreComm(String commune, String sexe) {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.TableCountDetailGenreComm(commune, sexe);
	}
	@Override
	public List<Object[]> TableauCountDetailGenreAllComm(String commune) {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.TableCountDetailGenreAllComm(commune);
	}
	
	// DISTRICT DETAIL TABLEAU COUNT
	
	@Override
	public List<Object[]> TableauCountDetailGenreDist(String district, String sexe) {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.TableCountDetailGenreDist(district, sexe);
	}
	@Override
	public List<Object[]> TableauCountDetailGenreAllDist(String district) {
		// TODO Auto-generated method stub
		return wp3FormTechMetierJeuneRepository.TableCountDetailGenreAllDist(district);
	}
}
