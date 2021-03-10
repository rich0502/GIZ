package com.Giz.service.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giz.data.domain.Accueil;
import com.Giz.repository.AccueilRepository;

@Service
public class AccueilServiceImpl implements AccueilService{
	
	@Autowired
	AccueilRepository accueilRepository;
	
	@Override
	public List<Accueil> ListAccueil() {
		// TODO Auto-generated method stub
		return accueilRepository.findAll();
	}
	
	@Override
	public void modifyAccueil(Accueil accueil, String contenu_acc, Long id_acc) {	
		accueil.setContenu_acc(contenu_acc);
		accueilRepository.save(accueil);
		
	}
}
