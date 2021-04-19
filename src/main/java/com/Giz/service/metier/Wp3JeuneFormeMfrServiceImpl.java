package com.Giz.service.metier;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.Giz.data.domain.Wp3JeuneFormeMfr;
import com.Giz.repository.Wp3JeuneFormeMfrRepository;

@Service
public class Wp3JeuneFormeMfrServiceImpl implements Wp3JeuneFormeMfrService {

	@Autowired
	Wp3JeuneFormeMfrRepository wp3JeuneFormeMfrRepository;
	
	@Override
	public Wp3JeuneFormeMfr createWp3JeuneFormeMfr(Wp3JeuneFormeMfr wp3JeuneFormeMfr) throws Exception {
		return wp3JeuneFormeMfr = wp3JeuneFormeMfrRepository.save(wp3JeuneFormeMfr);
	}

	@Override
	public List<Wp3JeuneFormeMfr> ListWp3JeuneFormeMfr() {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.findAll();
	}

	@Override
	public void addWp3JeuneFormeMfr(String code_village, String nom_prenom, String sexe, int annee_naissance,
			boolean forme, boolean accompagne_sortie, String type_accompagnement, Date date_suivi, String activite) {

		Wp3JeuneFormeMfr wp3JeuneFormeMfr = new Wp3JeuneFormeMfr();
		
		wp3JeuneFormeMfr.setCode_village(code_village);
		wp3JeuneFormeMfr.setNom_prenom(nom_prenom);
		wp3JeuneFormeMfr.setSexe(sexe);
		wp3JeuneFormeMfr.setAnnee_naissance(annee_naissance);
		wp3JeuneFormeMfr.setForme(forme);
		wp3JeuneFormeMfr.setAccompagne_sortie(accompagne_sortie);
		wp3JeuneFormeMfr.setType_accompagnement(type_accompagnement);
		wp3JeuneFormeMfr.setDate_suivi(date_suivi);
		wp3JeuneFormeMfr.setActivite(activite);
		
		wp3JeuneFormeMfrRepository.save(wp3JeuneFormeMfr);
		
	}

	@Override
	public long countChronologique(String dateChronologique) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3JeuneFormeMfrRepository.countAll();
		} else {
			return wp3JeuneFormeMfrRepository.countChronologie(dateChronologique);
		}
	}

	@Override
	public long countChronologiqueGenre(String dateChronologique, String genre) {
		if(StringUtils.isEmpty(dateChronologique)) {
			return wp3JeuneFormeMfrRepository.countGenre(genre);
		} else {
			return wp3JeuneFormeMfrRepository.countChronologieGenre(dateChronologique, genre);
		}
	}

	@Override
	public Optional<Wp3JeuneFormeMfr> findByIdJeuneFormeMfr(long id) {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.findById(id);
	}

	@Override
	public void modifyWp3JeuneFormeMfr(String code_village, String nom_prenom, String sexe, int annee_naissance,
			boolean forme, boolean accompagne_sortie, String type_accompagnement, Date date_suivi, long id) {

		Wp3JeuneFormeMfr wp3JeuneFormeMfr = new Wp3JeuneFormeMfr();
		
		wp3JeuneFormeMfr.setCode_village(code_village);
		wp3JeuneFormeMfr.setNom_prenom(nom_prenom);
		wp3JeuneFormeMfr.setSexe(sexe);
		wp3JeuneFormeMfr.setAnnee_naissance(annee_naissance);
		wp3JeuneFormeMfr.setForme(forme);
		wp3JeuneFormeMfr.setAccompagne_sortie(accompagne_sortie);
		wp3JeuneFormeMfr.setType_accompagnement(type_accompagnement);
		wp3JeuneFormeMfr.setDate_suivi(date_suivi);
		wp3JeuneFormeMfr.setId(id);
		wp3JeuneFormeMfrRepository.save(wp3JeuneFormeMfr);
		
	}
	
	@Override
	public void deleteWp3JeuneFormeMfr(Long id) {
		wp3JeuneFormeMfrRepository.deleteWp3JeuneFormeMfr(id);		
	}
	
	//graphe

	@Override
	public long TotTotal(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.SomTotal(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListFetch() {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.fetchData();
	}

	@Override
	public long CamembertTot() {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.CamembertTot();
	}

	@Override
	public List<Object[]> ListGraphe(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.TpsData(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableau(Date debut_date, Date fin_date, List<String> params, String sexe) {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.TableData(debut_date, fin_date, params, sexe);
	}

	@Override
	public List<Object[]> ListTableauCommune(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.TableDataCommune(debut_date, fin_date, sexe);
	}

	@Override
	public List<Object[]> ListTableauDist(Date debut_date, Date fin_date, String sexe) {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.TableDataDist(debut_date, fin_date, sexe);
	}

	@Override
	public List<Object[]> ListTableauAll(Date debut_date, Date fin_date, List<String> params) {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.TableDataAll(debut_date, fin_date, params);
	}

	@Override
	public List<Object[]> ListTableauCommuneAll(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.TableDataCommuneAll(debut_date, fin_date);
	}

	@Override
	public List<Object[]> ListTableauDistAll(Date debut_date, Date fin_date) {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.TableDataDistAll(debut_date, fin_date);
	}
	
	// VILLAGE DETAIL TABLEAU COUNT

	@Override
	public List<Object[]> TableauCountDetailGenre(String village, String sexe) {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.TableCountDetailGenre(village, sexe);
	}
	@Override
	public List<Object[]> TableauCountDetailGenreAll(String village) {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.TableCountDetailGenreAll(village);
	}
	
		// COMMUNE DETAIL TABLEAU COUNT
	
	@Override
	public List<Object[]> TableauCountDetailGenreComm(String commune, String sexe) {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.TableCountDetailGenreComm(commune, sexe);
	}
	@Override
	public List<Object[]> TableauCountDetailGenreAllComm(String commune) {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.TableCountDetailGenreAllComm(commune);
	}
	
	// DISTRICT DETAIL TABLEAU COUNT
	
	@Override
	public List<Object[]> TableauCountDetailGenreDist(String district, String sexe) {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.TableCountDetailGenreDist(district, sexe);
	}
	@Override
	public List<Object[]> TableauCountDetailGenreAllDist(String district) {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.TableCountDetailGenreAllDist(district);
	}
	
	@Override
	public void deleteAll42() {
		// TODO Auto-generated method stub
		wp3JeuneFormeMfrRepository.deleteAll();
		
	}

	@Override
	public List<Object[]> historiqueList() {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.historiqueList();
	}
}
