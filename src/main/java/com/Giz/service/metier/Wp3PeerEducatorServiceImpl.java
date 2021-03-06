package com.Giz.service.metier;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.Giz.data.domain.Wp3PeerEducator;
import com.Giz.repository.Wp3PeerEducatorRepository;

@Service
public class Wp3PeerEducatorServiceImpl implements Wp3PeerEducatorService {

	@Autowired
	Wp3PeerEducatorRepository wp3PeerEducatorRepository;
	
	@Override
	public Wp3PeerEducator createWp3PeerEducator(Wp3PeerEducator wp3PeerEducator) throws Exception {
		return wp3PeerEducator = wp3PeerEducatorRepository.save(wp3PeerEducator);
	}

	@Override
	public List<Wp3PeerEducator> ListWp3PeerEducator() {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.findAll();
	}

	@Override
	public void addWp3PeerEducator(String code_village, String nom_prenom, String sexe, int annee_naissance,
			boolean operationnelle, Date date_suivi, String activite) {

		Wp3PeerEducator wp3PeerEducator = new Wp3PeerEducator();
		
		wp3PeerEducator.setCode_village(code_village);
		wp3PeerEducator.setNom_prenom(nom_prenom);
		wp3PeerEducator.setSexe(sexe);
		wp3PeerEducator.setAnnee_naissance(annee_naissance);
		wp3PeerEducator.setOperationnelle(operationnelle);
		wp3PeerEducator.setDate_suivi(date_suivi);
		wp3PeerEducator.setActivite(activite);
		
		wp3PeerEducatorRepository.save(wp3PeerEducator);
		
	}

	@Override
	public long countChronologique(String dateChronologique) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3PeerEducatorRepository.count();
		} else {
			return wp3PeerEducatorRepository.countChronologique(dateChronologique);
		}
	}

	@Override
	public long countChronologiqueGenre(String dateChronologique, String genre) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3PeerEducatorRepository.countGenre(genre);
		} else {
			return wp3PeerEducatorRepository.countChronologiqueGenre(dateChronologique, genre);
		}
	}

	@Override
	public Optional<Wp3PeerEducator> findByIdPeerEducator(long id) {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.findById(id);
	}

	@Override
	public void modifyWp3PeerEducator(String code_village, String nom_prenom, String sexe, int annee_naissance,
			boolean operationnelle, Date date_suivi, long id) {

		Wp3PeerEducator wp3PeerEducator = new Wp3PeerEducator();
		
		wp3PeerEducator.setCode_village(code_village);
		wp3PeerEducator.setNom_prenom(nom_prenom);
		wp3PeerEducator.setSexe(sexe);
		wp3PeerEducator.setAnnee_naissance(annee_naissance);
		wp3PeerEducator.setOperationnelle(operationnelle);
		wp3PeerEducator.setDate_suivi(date_suivi);
		wp3PeerEducator.setId(id);
		wp3PeerEducatorRepository.save(wp3PeerEducator);
		
	}
	
	@Override
	public void deleteWp3PeerEducator(Long id) {
		wp3PeerEducatorRepository.deleteWp3PeerEducator(id);		
	}
	
	//graphe

	@Override
	public long TotTotal(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.SomTotal(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListFetch() {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.fetchData();
	}

	@Override
	public long CamembertTot() {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.CamembertTot();
	}

	@Override
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.TpsData(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableau(Date debut_date, Date fin_date, List<String> params, String sexe) {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.TableData(debut_date, fin_date, params, sexe);
	}

	@Override
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.TableDataCommune(debut_date, fin_date, sexe);
	}

	@Override
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.TableDataDist(debut_date, fin_date, sexe);
	}
	
	@Override
	public List<Object[]> ListTableauAll(Date debut_date, Date fin_date, List<String> params) {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.TableDataAll(debut_date, fin_date, params);
	}

	@Override
	public List<Object[]> ListTableauCommuneAll(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.TableDataCommuneAll(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableauDistAll(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.TableDataDistAll(debut_date, fin_date);
	}
	
	// VILLAGE DETAIL TABLEAU COUNT

	@Override
	public List<Object[]> TableauCountDetailGenre(String village, String sexe) {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.TableCountDetailGenre(village, sexe);
	}
	@Override
	public List<Object[]> TableauCountDetailGenreAll(String village) {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.TableCountDetailGenreAll(village);
	}
	
		// COMMUNE DETAIL TABLEAU COUNT
	
	@Override
	public List<Object[]> TableauCountDetailGenreComm(String commune, String sexe) {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.TableCountDetailGenreComm(commune, sexe);
	}
	@Override
	public List<Object[]> TableauCountDetailGenreAllComm(String commune) {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.TableCountDetailGenreAllComm(commune);
	}
	
	// DISTRICT DETAIL TABLEAU COUNT
	
	@Override
	public List<Object[]> TableauCountDetailGenreDist(String district, String sexe) {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.TableCountDetailGenreDist(district, sexe);
	}
	@Override
	public List<Object[]> TableauCountDetailGenreAllDist(String district) {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.TableCountDetailGenreAllDist(district);
	}
	
	@Override
	public void deleteAll49() {
		// TODO Auto-generated method stub
		wp3PeerEducatorRepository.deleteAll();
		
	}

	@Override
	public List<Object[]> historiqueList() {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.historiqueList();
	}
}
