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
	public List<Wp3JeuneFormeMfr> ListWp3JeuneFormeMfr() {
		// TODO Auto-generated method stub
		return wp3JeuneFormeMfrRepository.findAll();
	}

	@Override
	public void addWp3JeuneFormeMfr(String code_village, String nom_prenom, String sexe, int annee_naissance,
			boolean forme, boolean accompagne_sortie, String type_accompagnement, Date date_suivi) {

		Wp3JeuneFormeMfr wp3JeuneFormeMfr = new Wp3JeuneFormeMfr();
		
		wp3JeuneFormeMfr.setCode_village(code_village);
		wp3JeuneFormeMfr.setNom_prenom(nom_prenom);
		wp3JeuneFormeMfr.setSexe(sexe);
		wp3JeuneFormeMfr.setAnnee_naissance(annee_naissance);
		wp3JeuneFormeMfr.setForme(forme);
		wp3JeuneFormeMfr.setAccompagne_sortie(accompagne_sortie);
		wp3JeuneFormeMfr.setType_accompagnement(type_accompagnement);
		wp3JeuneFormeMfr.setDate_suivi(date_suivi);
		
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
}
