package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Wp3PeerEducator;
import com.Giz.repository.Wp3PeerEducatorRepository;

@Service
public class Wp3PeerEducatorServiceImpl implements Wp3PeerEducatorService {

	@Autowired
	Wp3PeerEducatorRepository wp3PeerEducatorRepository;

	@Override
	public List<Wp3PeerEducator> ListWp3PeerEducator() {
		// TODO Auto-generated method stub
		return wp3PeerEducatorRepository.findAll();
	}

	@Override
	public void addWp3PeerEducator(String code_village, String nom_prenom, String sexe, int annee_naissance,
			boolean operationnelle, Date date_suivi) {

		Wp3PeerEducator wp3PeerEducator = new Wp3PeerEducator();
		
		wp3PeerEducator.setCode_village(code_village);
		wp3PeerEducator.setNom_prenom(nom_prenom);
		wp3PeerEducator.setSexe(sexe);
		wp3PeerEducator.setAnnee_naissance(annee_naissance);
		wp3PeerEducator.setOperationnelle(operationnelle);
		wp3PeerEducator.setDate_suivi(date_suivi);
		
		wp3PeerEducatorRepository.save(wp3PeerEducator);
		
	}
}
