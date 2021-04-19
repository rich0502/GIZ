package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Parasite_maladie_divers;
import com.Giz.repository.Parasite_maladie_diversRepository;

@Service
public class Parasite_maladie_diversServiceImpl implements Parasite_maladie_diversService {

	@Autowired
	Parasite_maladie_diversRepository parasite_maladie_diversRepository;
	
	@Override
	public List<Parasite_maladie_divers> ListParasite_maladie_divers(String code_prod) {
		// TODO Auto-generated method stub
		return parasite_maladie_diversRepository.findByCodeProd(code_prod);
	}

	@Override
	public void addParasiteMaladieDivers(long id,String code_prod, String constate, String nom_mp, String periode,
			String pourcentage, String traitement, String mecanique, String chimique, String chimique_qte,
			String biologique, String autre, String frequence, String effets) {
			Parasite_maladie_divers parasite = new Parasite_maladie_divers();
			Optional<Parasite_maladie_divers> getId = parasite_maladie_diversRepository.existCodeProd(code_prod);
			parasite.setCode_prod(code_prod);
			parasite.setConstate(constate);
			parasite.setNom_mp(nom_mp);
			parasite.setPeriode(periode);
			parasite.setPourcentage(pourcentage);
			parasite.setTraitement(traitement);
			parasite.setMecanique(mecanique);
			parasite.setChimique(chimique_qte);
			parasite.setChimique_qte(chimique_qte);
			parasite.setBiologique(biologique);
			parasite.setAutre(autre);
			parasite.setFrequence(frequence);
			parasite.setEffets(effets);
			
			if(existCodeProd(code_prod).isPresent()) {
				parasite.setId(getId.get().getId());
				parasite_maladie_diversRepository.save(parasite);
			}else {
				parasite.setId(id);
				parasite_maladie_diversRepository.save(parasite);
			}
		
	}
	public List<Parasite_maladie_divers> ListParasite_maladie_diversAll() {
		// TODO Auto-generated method stub
		return parasite_maladie_diversRepository.findAll();
	}

	@Override
	public Optional<Parasite_maladie_divers> existCodeProd(String code_prod) {
		// TODO Auto-generated method stub
		return parasite_maladie_diversRepository.existCodeProd(code_prod);
	}

}
