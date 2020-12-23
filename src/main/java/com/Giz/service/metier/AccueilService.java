package com.Giz.service.metier;

import java.util.List;

import com.Giz.data.domain.Accueil;

public interface AccueilService {
	
	public List<Accueil> ListAccueil();
	public void modifyAccueil(Accueil accueil, String contenu_acc, Long id_acc);
	
}
