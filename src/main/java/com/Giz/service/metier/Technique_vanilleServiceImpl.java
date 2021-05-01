package com.Giz.service.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Technique_vanille;
import com.Giz.repository.Technique_vanilleRepository;

@Service
public class Technique_vanilleServiceImpl implements Technique_vanilleService{

	@Autowired
	private Technique_vanilleRepository technique_vanilleRepository ;
	
	@Override
	public List<Technique_vanille> ListTechnique_vanille(String code_prod) {
		// TODO Auto-generated method stub
		return technique_vanilleRepository.findByCodeProd(code_prod);
	}

	@Override
	public List<Technique_vanille> ListTechnique_vanilleAll() {
		// TODO Auto-generated method stub
		return technique_vanilleRepository.findAll();
	}

	@Override
	public Optional<Technique_vanille> existCodeProd(String code_prod) {
		// TODO Auto-generated method stub
		return technique_vanilleRepository.existCodeProd(code_prod);
	}

	@Override
	public void addTechnique(long id, String code_pro, String ptv, String taille, String selectLiane, String plantVao,String descentBoucl,
			String entretienCan, String desherbFaush, String prepaBouton, String pollinisation, String limitGousse,
			String nettoyMort, String arretCoeur, String nettoyaParasit, String adyGasy, String appliCompo) {
		Technique_vanille tv = new Technique_vanille();
		Optional<Technique_vanille> getId = technique_vanilleRepository.existCodeProd(code_pro);
		tv.setCode_pro(code_pro);
		tv.setPtv(ptv);
		tv.setTaille(taille);
		tv.setSelectLiane(selectLiane);
		tv.setPlantVao(plantVao);
		tv.setEntretienCan(entretienCan);
		tv.setDesherbFaush(desherbFaush);
		tv.setPollinisation(pollinisation);
		tv.setLimitGousse(limitGousse);
		tv.setNettoyMort(nettoyMort);
		tv.setArretCoeur(arretCoeur);
		tv.setNettoyaParasit(nettoyaParasit);
		tv.setAdyGasy(adyGasy);
		tv.setAppliCompo(appliCompo);
		tv.setPrepaBouton(prepaBouton);
		tv.setDescentBoucl(descentBoucl);
		
		if(existCodeProd(code_pro).isPresent()) {
			tv.setId(getId.get().getId());
			technique_vanilleRepository.save(tv);
		}else {
			tv.setId(id);
			technique_vanilleRepository.save(tv);
		}	
		
	}

	@Override
	public List<Technique_vanille> ListTechnique_vanilleAllFkt(String zone) {
		// TODO Auto-generated method stub
		return technique_vanilleRepository.ListTechnique_vanilleAllFkt(zone);
	}

	@Override
	public List<Technique_vanille> ListTechnique_vanilleAllProd(String code_fkt) {
		// TODO Auto-generated method stub
		return technique_vanilleRepository.ListTechnique_vanilleAllProd(code_fkt);
	}

}
