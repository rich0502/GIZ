package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Parasite_maladie;
import com.Giz.repository.Parasite_maladieRepository;

@Service
public class Parasite_maladieServiceImpl implements Parasite_maladieService{
	
	@Autowired
	private Parasite_maladieRepository parasite_maladieRepository ;

	@Override
	public List<Parasite_maladie> ListParasite_maladie(String code_prod) {
		// TODO Auto-generated method stub
		return parasite_maladieRepository.findByCodeProd(code_prod);
	}

	@Override
	public void addParasiteMaladieDivers(long id,String code_prod, String constate, String nom_mp, String periode,
			String pourcentage, String traitement, String mecanique, String chimique, String chimique_qte,
			String biologique, String autre, String frequence, String effets) {
	Parasite_maladie parasite = new Parasite_maladie();
		Optional<Parasite_maladie> getId = parasite_maladieRepository.existCodeProd(code_prod);
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
			parasite_maladieRepository.save(parasite);
		}else {
			parasite.setId(id);
			parasite_maladieRepository.save(parasite);
		}	
	}	
	public List<Parasite_maladie> ListParasite_maladieAll() {
		// TODO Auto-generated method stub
		return parasite_maladieRepository.findAll();
	}

	@Override
	public Optional<Parasite_maladie> existCodeProd(String code_prod) {
		// TODO Auto-generated method stub
		return parasite_maladieRepository.existCodeProd(code_prod);
	}

	@Override
	public List<Parasite_maladie> ListParasite_maladieAllFkt(String zone) {
		// TODO Auto-generated method stub
		return parasite_maladieRepository.ListParasite_maladieAllFkt(zone);
	}

	@Override
	public List<Parasite_maladie> ListParasite_maladieAllProd(String code_fkt) {
		// TODO Auto-generated method stub
		return parasite_maladieRepository.ListParasite_maladieAllProd(code_fkt);
	}
}
