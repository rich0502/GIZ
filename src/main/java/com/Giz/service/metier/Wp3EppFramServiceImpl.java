package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.Giz.data.domain.Wp3EppFram;
import com.Giz.repository.Wp3EppFramRepository;

@Service
public class Wp3EppFramServiceImpl implements Wp3EppFramService {

	@Autowired
	Wp3EppFramRepository wp3EppFramRepository;
	
	@Override
	public Wp3EppFram createWp3EppFram(Wp3EppFram wp3EppFram) throws Exception {
		return wp3EppFram = wp3EppFramRepository.save(wp3EppFram);
	}

	@Override
	public List<Wp3EppFram> ListWp3EppFram() {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.findAll();
	}

	@Override
	public void addWp3EppFram(String code_village, String nom_ecole, boolean projet_fram, boolean projet_valide,
			String type_projet, Date date_validation) {

		Wp3EppFram wp3EppFram = new Wp3EppFram();

		wp3EppFram.setCode_village(code_village);
		wp3EppFram.setNom_ecole(nom_ecole);
		wp3EppFram.setProjet_fram(projet_fram);
		wp3EppFram.setProjet_valide(projet_valide);
		wp3EppFram.setType_projet(type_projet);
		wp3EppFram.setDate_validation(date_validation);

		wp3EppFramRepository.save(wp3EppFram);

	}

	@Override
	public long countChronologique(String dateChronologique) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3EppFramRepository.count();
		} else {
			return wp3EppFramRepository.countChronologie(dateChronologique);
		}
	}

	@Override
	public long countChronologiqueGenre(String dateChronologique, String genre) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3EppFramRepository.countGenre(genre);
		} else {
			return wp3EppFramRepository.countChronologieGenre(dateChronologique, genre);
		}
	}

	@Override
	public Optional<Wp3EppFram> findByIdEppFram(long id) {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.findById(id);
	}

	@Override
	public void modifyWp3EppFram(String code_village, String nom_ecole,String sexe, boolean projet_fram, boolean projet_valide,
			String type_projet, Date date_validation, long id) {
		Wp3EppFram wp3EppFram = new Wp3EppFram();

		wp3EppFram.setCode_village(code_village);
		wp3EppFram.setNom_ecole(nom_ecole);
		wp3EppFram.setSexe(sexe);
		wp3EppFram.setProjet_fram(projet_fram);
		wp3EppFram.setProjet_valide(projet_valide);
		wp3EppFram.setType_projet(type_projet);
		wp3EppFram.setDate_validation(date_validation);
		wp3EppFram.setId(id);
		wp3EppFramRepository.save(wp3EppFram);
		
	}
	
	@Override
	public void deleteWp3EppFram(Long id) {
		wp3EppFramRepository.deleteWp3EppFram(id);		
	}
	
	//graphe

	@Override
	public long TotTotal(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.SomTotal(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListFetch() {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.fetchData();
	}

	@Override
	public long CamembertTot() {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.CamembertTot();
	}

	@Override
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.TpsData(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableau(Date debut_date, Date fin_date, List<String> params, String sexe) {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.TableData(debut_date, fin_date, params, sexe);
	}

	@Override
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.TableDataCommune(debut_date, fin_date, sexe);
	}

	@Override
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.TableDataDist(debut_date, fin_date, sexe);
	}
	
	@Override
	public List<Object[]> ListTableauAll(Date debut_date, Date fin_date, List<String> params) {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.TableDataAll(debut_date, fin_date, params);
	}

	@Override
	public List<Object[]> ListTableauCommuneAll(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.TableDataCommuneAll(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableauDistAll(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.TableDataDistAll(debut_date, fin_date);
	}
	
	// VILLAGE DETAIL TABLEAU COUNT

	@Override
	public List<Object[]> TableauCountDetailGenre(String village, String sexe) {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.TableCountDetailGenre(village, sexe);
	}
	@Override
	public List<Object[]> TableauCountDetailGenreAll(String village) {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.TableCountDetailGenreAll(village);
	}
	
		// COMMUNE DETAIL TABLEAU COUNT
	
	@Override
	public List<Object[]> TableauCountDetailGenreComm(String commune, String sexe) {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.TableCountDetailGenreComm(commune, sexe);
	}
	@Override
	public List<Object[]> TableauCountDetailGenreAllComm(String commune) {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.TableCountDetailGenreAllComm(commune);
	}
	
	// DISTRICT DETAIL TABLEAU COUNT
	
	@Override
	public List<Object[]> TableauCountDetailGenreDist(String district, String sexe) {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.TableCountDetailGenreDist(district, sexe);
	}
	@Override
	public List<Object[]> TableauCountDetailGenreAllDist(String district) {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.TableCountDetailGenreAllDist(district);
	}
	
	@Override
	public void deleteAll47() {
		// TODO Auto-generated method stub
		wp3EppFramRepository.deleteAll();
		
	}

	@Override
	public List<Object[]> historiqueList() {
		// TODO Auto-generated method stub
		return wp3EppFramRepository.historiqueList();
	}
}
