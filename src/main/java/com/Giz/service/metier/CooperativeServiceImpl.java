package com.Giz.service.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Cooperative;
import com.Giz.repository.CooperativeRepository;

@Service
public class CooperativeServiceImpl implements CooperativeService {
	
	@Autowired
	private CooperativeRepository cooperativeRepository;

	@Override
	public List<Cooperative> ListCooperative() {
		// TODO Auto-generated method stub
		return cooperativeRepository.findAll();
	}

	@Override
	public void deleteCooperative(Long id_coop) {
		cooperativeRepository.deleteById(id_coop);
		
	}

	@Override
	public void addCooperative(String code_village, boolean exist, String nom_coop, Date date_creation, boolean socio,
			boolean environnement, Date date_suivi) {
		Cooperative cooperative = new Cooperative();
		cooperative.setCode_village(code_village);
		cooperative.setExist(exist);
		cooperative.setNom_coop(nom_coop);
		cooperative.setDate_creation(date_creation);
		cooperative.setSocio(socio);
		cooperative.setEnvironnement(environnement);
		cooperative.setDate_suivi(date_suivi);
		cooperativeRepository.save(cooperative);
		
		
	}

	@Override
	public void modifyCooperative(Cooperative cooperative, String code_village, boolean exist, String nom_coop,
			Date date_creation, boolean socio, boolean environnement, Date date_suivi, Long id_coop) {
		cooperative.setCode_village(code_village);
		cooperative.setExist(exist);
		cooperative.setNom_coop(nom_coop);
		cooperative.setDate_creation(date_creation);
		cooperative.setSocio(socio);
		cooperative.setEnvironnement(environnement);
		cooperative.setDate_suivi(date_suivi);
		cooperativeRepository.save(cooperative);
		
	}

}
